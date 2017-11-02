# === learn === #

# Docker
> docker ps -a  
> docker rm -v <CONTAINER-ID> <CONTAINER-ID> // -v für volume  
> docker run -d -e PORT=4000 -p 8080:4000 --restart always --name <CONTAINERNAME> <IMGNAME>  
alpin ist ein sehr kleines linux  
-d startet Container im Detached-Mode  
-e setzt umgebungsvariablen  
-p leitet Porst weiter  
--restart legt die Restart-Policy fest  
--name gibt dem Container einen Namen
# Node.js
> npm install processenv --save