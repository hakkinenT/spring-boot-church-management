FROM maven:3.9.8-amazoncorretto-21-al2023 AS build

COPY src /app/src
COPY pom.xml /app

WORKDIR /app
RUN mvn clean install

FROM amazoncorretto:21-al2023 AS exec

COPY --from=build /app/target/churchmanagement-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]