FROM openjdk:8-alpine

ARG PROFILE

ARG ADDITIONAL_OPTS

WORKDIR /opt/cursowebservice

COPY /target/cursowebservice*.jar cursowebservice.jar

SHELL ["/bin/sh", "-c"]

EXPOSE 8080

EXPOSE 5005

CMD java ${ADDITIONAL_OPTS} -jar cursowebservice.jar --spring.profiles.active=${PROFILE}