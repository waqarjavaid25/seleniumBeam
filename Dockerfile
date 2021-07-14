#mvn package -DskipTests
FROM openjdk:8u191-jre-alpine
RUN apk add curl jq


#WORKspace

WORKDIR /usr/share/test/

#ADD .jar under target from host

ADD target/selenium-docker.jar              selenium-docker.jar
ADD target/selenium-docker-tests.jar        selenium-docker-tests.jar
ADD target/libs                             libs

#Add Suit Files
ADD testng.xml                              testng.xml
ADD healthcheck.sh                          healthcheck.sh

ENTRYPOINT sh healthcheck.sh