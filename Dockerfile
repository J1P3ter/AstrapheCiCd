# build에서 사용할 이미지
FROM gradle:8.10.1-jdk17 AS build

# Set the working directory inside the container
WORKDIR /app

# Set variables for building
#ARG FILE_DIRECTORY

#COPY $FILE_DIRECTORY /app
COPY . .

RUN gradle clean bootJar

# Set base image
FROM openjdk:17-jdk-slim

# COPY HOST_MACHINE_DIRECTORY CONTAINER_MACHINE_DIRECTORY
COPY --from=build /app/build/libs/*SNAPSHOT.jar /app.jar

CMD ["java", "-jar", "app.jar"]