# For Java 11
FROM openjdk:11.0.4-jdk-slim

MAINTAINER Georgios Marmaris

# Refer to Maven build -> finalName
ARG JAR_FILE=web/target/web-*.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar
#ADD /target/web-*.jar ${WORKING_DIR}/app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]
