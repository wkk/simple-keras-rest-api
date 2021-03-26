from concurrent.futures import ThreadPoolExecutor
import math
from multiprocessing import cpu_count
import os
import random
import sys
import time

import numpy as np
import requests

test_image_dir = "testSet"


def load_images():
    images = []
    print("loading images...")
    for file in os.listdir(test_image_dir):
        images.append(open(os.path.join(test_image_dir, file), "rb").read())
    print("images loaded")
    return images


def generate_interarrival_times(number_of_requests: int, rate: float):
    def exponential_reverse_cdf(x):
        return -math.log(1 - x) / rate

    rng = np.random.default_rng()
    return [exponential_reverse_cdf(x) for x in rng.random(number_of_requests)]


def health_check(addr: str) -> None:
    health_check_rul = f"http://{addr}/check"
    r = requests.get(health_check_rul).json()
    if not r["healthy"]:
        print(r)
        raise AssertionError


def generate(addr: str, number_of_requests: int, rate: float):
    interarrival_times = generate_interarrival_times(number_of_requests, rate)
    images = load_images()
    health_check(addr)

    predict_url = f"http://{addr}/predict"

    def request(request_index: int):
        payload = {"image": random.choice(images)}
        data = {
            "request_index": request_index,
            "start": time.time()
        }
        r = requests.post(predict_url, files=payload)
        data["end"] = time.time()
        data["status_code"] = r.status_code
        data["response_text"] = r.text
        return data

    futures = []
    with ThreadPoolExecutor(max_workers=cpu_count() * 2) as executor:
        for i in range(number_of_requests):
            time.sleep(interarrival_times[i])
            futures.append(executor.submit(request, i))

    with open(f"output/{time.strftime('%H%M%S')}-{number_of_requests}-{rate}.txt", "w") as fout:
        for future in futures:
            print(future.result(), file=fout)

    health_check(addr)


if __name__ == "__main__":
    if len(sys.argv) != 4:
        print("Usage: load_generator ip[:port] number_of_requests rate")
        sys.exit(os.EX_USAGE)
    addr = sys.argv[1]
    number_of_requests = int(sys.argv[2])
    rate = float(sys.argv[3])
    generate(addr, number_of_requests, rate)
