# build에서 사용할 이미지
FROM gradle:8.10.1-jdk17 AS build
VOLUME /tmp
ARG FILE_DIRECTORY
ARG JAR_FILE=${FILE_DIRECTORY}/build/libs/*jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]