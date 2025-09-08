# POC - CCE

## Crear imagen docker del servicio

* Imagen local

```shell
docker build -t poc-cce-directory-service:latest .

#with podman
podman build -t poc-cce-directory-service:latest .
```

* Imagen para el repositorio público de Docker Hub

```shell
#docker build -t <usuario-docker-hub>/<nombre-de-la-imagen>:<version> .
docker build -t sebastianbran/poc-cce-directory-service:latest .

#with podman
podman build -t docker.io/sebastianbran/poc-cce-directory-service:latest .
```

## Crear recursos de kubernetes

* Ir a la carpeta **kubernetes**

```shell
cd kubernetes
```

* Crear la infraestructura

```shell
kubectl apply -f .
```