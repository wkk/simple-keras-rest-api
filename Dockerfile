FROM python:3.8

WORKDIR /app

RUN pip install flask keras pillow tensorflow

ADD run_keras_server.py /app/

ENTRYPOINT ["python", "/app/run_keras_server.py"]
