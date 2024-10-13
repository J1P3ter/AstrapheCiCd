# build에서 사용할 이미지
FROM gradle:8.10.1-jdk17 AS build
VOLUME /tmp
ARG JAR_FILE=build/libs/*jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]