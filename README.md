# POC - CCE

## Crear imagen docker del servicio

* Crear imagen docker

```shell
#docker build -f <module>/Dockerfile -t sebastianbran/poc-cce-directory-service .
docker build -f directory/Dockerfile -t sebastianbran/poc-cce-directory-service .

#Con podman
podman build -f directory/Dockerfile -t sebastianbran/poc-cce-directory-service .
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