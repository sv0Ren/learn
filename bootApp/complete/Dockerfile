FROM openjdk:8-jdk-alpine
#java:8
#openjdk:8-jdk-alpine
EXPOSE 8080 8000
RUN mkdir /java
COPY target/bootApp-0.1.0.jar /java/app.jar
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom","-agentlib:jdwp=transport=dt_socket,address=8000,suspend=n,server=y","-jar","/java/app.jar" ]

#VOLUME /tmp
#ADD target/bootApp-0.1.0.jar app.jar
#ENV JAVA_OPTS=""
#ENTRYPOINT exec java $JAVA_OPTS -Djava.mvn package && java -jar target/bootApp-0.1.0.jarsecurity.egd=file:/dev/./urandom -jar /a

#FROM frolvlad/alpine-oraclejdk8:slim
#VOLUME /tmp
#ADD sp-boot-sample-1.0.9-SNAPSHOT.jar app.jar
#RUN sh -c 'touch /app.jar'
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]


#FROM java:8
#VOLUME /tmp
#ADD bootApp-0.1.0.jar bootApp.jar
#RUN bash -c 'touch /app.jar'
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/bootApp.jar"]