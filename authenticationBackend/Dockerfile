FROM openjdk:8-jdk-alpine
EXPOSE 8080 8000
RUN mkdir /java
COPY target/authenticationServer-0.1.0.jar /java/app1.jar
ENTRYPOINT [ "java","-Djava.security.egd=file:/dev/./urandom","-jar","/java/app1.jar"]
