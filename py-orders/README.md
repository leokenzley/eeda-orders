### Executando o projeto

#### executando via container docker
#### buildando a aplicação
```shell
  docker build -t py-orders .
```
#### executando via container
```shell
    docker run -d \
      --name py-orders-api \
      --network docker_eda-network \
      -p 8081:8081 \
      py-orders
```
#### removendo container
```shell
  docker rm -f py-orders-api &&
  docker rmi py-orders 
```
