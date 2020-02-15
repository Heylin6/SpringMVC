FROM openjdk:8
VOLUME /tmp
ADD spring-boot-docker-0.1.0.jar app.jar
EXPOSE 8086
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]