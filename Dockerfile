FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
#ARG FILE_DIRECTORY
#ARG JAR_FILE=${FILE_DIRECTORY}/build/libs/*SNAPSHOT.jar
ARG JAR_FILE=build/libs/*SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]