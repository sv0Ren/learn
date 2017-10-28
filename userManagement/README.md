# learn

# Docker
Create docker-machine:
> docker-machine create --driver = virtualbox docker

Start/stop docker-machine
> docker-machine {start,stop} <MACHINE_NAME>

Docker-Machine starten:
> docker-machine start name 

remove docker-machine
> docker-machine rm <MACHINE_NAME>

list all docker-machine
> docker-machine ls

docker-machine per cmd (windows)
> docker-machine env --shell cmd <MACHINE_NAME>
> @FOR /f "tokens=*" %i IN ('docker-machine env --shell cmd <MACHINE_NAME>') DO @%i

Get Infos:
> docker-machine env

set enviroment variables
> env | grep DOCKER

switch in bash eines containers:
> docker exec -it mongodb sh

link MongoDB with application
> docker run -p 8080:8080 -d --name <CONTAINER_NAME> --link <IMAGE_NAME_MONGO> <IMAGE_NAME_APP>

run MongoDB container
> docker run -P -d --name mongodb mongo

stop container
> docker container stop <CONTAINER_ID>

remove container
> docker container rm <CONTAINER_ID>

List all running containers
> docker ps

build image
> docker build -t <IMAGE_NAME_APP> .

List all images on the machine
> docker images

remove image
> docker rmi <IMAGE_ID>

port Mapping:
0.0.0.0:32768->27017/tcp

# Maven
Start Build and run:
> mvn package && java -jar target/userbackend-0.1.0.jar

clean install 
> mvn clean install dockerfile:build


export DOCKER_TLS_VERIFY="1"
export DOCKER_HOST="tcp://192.168.99.101:2376"
export DOCKER_CERT_PATH="/Users/wagner/.docker/machine/machines/docker"
export DOCKER_MACHINE_NAME="docker"
export DOCKER_HOST=tcp://192.168.59.103:2375



