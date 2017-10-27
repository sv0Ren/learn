# learn

# Docker
Install docker:
> docker-machine create --driver = virtualbox docker

Docker-Machine starten:
> docker-machine start name 
Get Infos: docker-machine env


switch in bash eines containers:
> docker exec -it mongodb sh

link MongoDB with application
>docker run -p 8080:8080 -d --name <CONTAINER_NAME> --link <IMAGE_NAME_MONGO> <IMAGE_NAME_APP>

port Mapping:
0.0.0.0:32768->27017/tcp

# Maven
Start Build:
> mvn package && java -jar target/bootApp-0.1.0.jar

clean install 
> mvn clean install dockerfile:build


export DOCKER_TLS_VERIFY="1"
export DOCKER_HOST="tcp://192.168.99.101:2376"
export DOCKER_CERT_PATH="/Users/wagner/.docker/machine/machines/docker"
export DOCKER_MACHINE_NAME="docker"
export DOCKER_HOST=tcp://192.168.59.103:2375



