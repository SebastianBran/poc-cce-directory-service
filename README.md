# POC - CCE

## Crear imagen docker del servicio

* Crear imagen docker (situarse en la carpeta raiz)

```shell
#docker build -f <module>/Dockerfile -t sebastianbran/poc-cce-directory-service .
docker build -f directory/Dockerfile -t sebastianbran/poc-cce-directory-service .

#Con podman
podman build -f directory/Dockerfile -t docker.io/sebastianbran/poc-cce-directory-service .
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

## Forward de puertos

* Realizar el forward de puertos para acceder a los servicios desde el localhost

```shell
kubectl port-forward svc/grafana-svc 3000:3000

kubectl port-forward svc/ibm-mq-svc 9443:9443 #Admin Console

kubectl port-forward svc/keycloak 8081:8080

kubectl port-forward svc/ingress-nginx-controller 8080:80 -n ingress-nginx
```


## Cargar imagen de IBM-MQ al cluster de Kubernetes (Opcional)

* Descargar la imagen de IBM-MQ desde el repositorio de IBM (ICR)

```shell
podman pull --tls-verify=false icr.io/ibm-messaging/mq:latest
```
* Empaquetar la imagen en un archivo tar

```shell
podman save -o mq.tar icr.io/ibm-messaging/mq:latest
```

* Cargar la imagen en el cluster (Kind)

```shell
kind load image-archive mq.tar --name kind-cluster
```
 