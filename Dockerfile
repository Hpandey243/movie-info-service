# Maven build container

FROM maven:3.8.5-openjdk-11

COPY target/movie-info-service-0.0.1-SNAPSHOT.jar /

FROM openjdk
EXPOSE 8080
CMD java -jar /movie-info-service-0.0.1-SNAPSHOT.jar
