FROM openjdk:8-jdk-alpine
EXPOSE 9999 9999
RUN mkdir /java
COPY testBackend/target/testbackend-0.1.0.jar /java/app2.jar
ENTRYPOINT [ "java","-Dspring.data.mongodb.uri=mongodb://user_db/users","-Djava.security.egd=file:/dev/./urandom","-jar","/java/app2.jar"]
