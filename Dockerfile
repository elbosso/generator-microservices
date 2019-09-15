#Build stage
FROM maven:3.6.1-jdk-11 AS build-env

ADD . /generator-microservices

WORKDIR generator-microservices

RUN mvn compile package

# Run it
FROM openjdk:11

COPY --from=build-env /generator-microservices/target/*-jar-with-dependencies.jar /app/generator-microservices.jar

EXPOSE 7000

CMD ["java", "-jar", "/app/generator-microservices.jar"]