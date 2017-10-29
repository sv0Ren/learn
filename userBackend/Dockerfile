FROM openjdk:8-jdk-alpine
EXPOSE 8080 8000
RUN mkdir /java
COPY target/userbackend-0.1.0.jar /java/app.jar
ENTRYPOINT [ "java","-Dspring.data.mongodb.uri=mongodb://user_db/users","-Djava.security.egd=file:/dev/./urandom","-agentlib:jdwp=transport=dt_socket,address=8000,suspend=n,server=y","-jar","/java/app.jar"]
