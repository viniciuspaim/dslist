FROM maven:3.9.9-amazoncorretto-23 AS build

COPY . .

RUN mvn clean install

FROM amazoncorretto:23-alpine-jdk

EXPOSE 8080

COPY --from=build target/dslist-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]