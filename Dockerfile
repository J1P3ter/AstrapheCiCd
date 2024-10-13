# build에서 사용할 이미지
FROM gradle:8.10.1-jdk17 AS build

# Set the working directory inside the container
#WORKDIR /app

# Set variables for building
#ARG FILE_DIRECTORY
#
#COPY $FILE_DIRECTORY /app
#COPY . .

RUN gradle clean bootJar

# Set base image
FROM openjdk:17-jdk-slim

# COPY HOST_MACHINE_DIRECTORY CONTAINER_MACHINE_DIRECTORY
#COPY --from=build /app/build/libs/*SNAPSHOT.jar /app.jar

# [호스트 머신] [컨테이너] 순으로 파일이나 디렉토리를 지정하여 호스트 머신의 파일을 복사할 수 있습니다.
# 이 경우 컨테이너가 실행되면 app.jar 파일이 존재하게 됩니다.
COPY ./build/lib/*.jar /app.jar

CMD ["java", "-jar", "app.jar"]