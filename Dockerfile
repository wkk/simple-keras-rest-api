FROM python:3.8

WORKDIR /app

RUN pip3 install flask==1.1.2 keras==2.4.3 pillow==8.2.0 tensorflow==2.4.1 h5py==2.10.0 numpy==1.19.5

ADD run_keras_server.py /app/

ENTRYPOINT [ "python", "/app/run_keras_server.py" ]
