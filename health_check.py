from multiprocessing import Pool

import flask
import requests


IMAGE_PATH = "dog.jpg"
image = open(IMAGE_PATH, "rb").read()
payload = {"image": image}


def check_server(server_addr: str) -> bool:
    url = f"http://{server_addr}/predict"
    try:
        r = requests.post(url, files=payload).json()
        assert r["success"] is True
        return True
    except:
        return False


app = flask.Flask(__name__)


@app.route("/check", methods=["GET"])
def check():
    with open("/config/servers.txt") as fin:
        servers = fin.read().splitlines()

    with Pool() as p:
        health_status = p.map(check_server, servers)

    data = {"status": dict(zip(servers, health_status))}

    if sum(health_status) == len(servers):
        data["healthy"] = True
    else:
        data["healthy"] = False

    return flask.jsonify(data)


if __name__ == "__main__":
    app.run(host="0.0.0.0")
