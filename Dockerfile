FROM openjdk:17-jdk-slim

ARG FILE_DIRECTORY

ARG JAR_FILE=${FILE_DIRECTORY}/build/libs/*SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

CMD ["java", "-jar", "app.jar"]
