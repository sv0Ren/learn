FROM openjdk:8-jdk-alpine
EXPOSE 8081 8001
RUN mkdir /java
COPY userBackend/target/userbackend-0.1.0.jar /java/app.jar
ENTRYPOINT [ "java","-Dspring.data.mongodb.uri=mongodb://user_db/users","-Djava.security.egd=file:/dev/./urandom","-agentlib:jdwp=transport=dt_socket,address=8001,suspend=n,server=y","-jar","/java/app.jar"]
