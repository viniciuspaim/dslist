FROM ubuntu:latest AS build

RUN apt-get update
RUN apt-get install amazoncorretto-23-jdk -y
COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM amazoncorretto:23-jdk

EXPOSE 8080

COPY --from=build target/dslist-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]