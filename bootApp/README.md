# learn

# Docker
Install docker:
> docker-machine create --driver=virtualbox docker

Docker starten:
> docker-machine start docker 
192.168.99.100:2376
set| grep DOCKER
$DOCKER_HOST = tcp://192.168.99.199:2376



switch in bash eines containers:
> docker exec -it mongodb sh

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