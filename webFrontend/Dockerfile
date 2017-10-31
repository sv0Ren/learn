FROM openjdk:8-jdk-alpine
EXPOSE 8080 8000
RUN mkdir /java
COPY target/webfrontend-0.0.1.jar /java/app1.jar
ENTRYPOINT [ "java","-Djava.security.egd=file:/dev/./urandom","-agentlib:jdwp=transport=dt_socket,address=8000,suspend=n,server=y","-jar","/java/app1.jar"]
