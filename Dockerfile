FROM openjdk:8-jdk-alpine3.7
RUN java -version

COPY target/movie-info-service-0.0.1-SNAPSHOT.jar /

CMD ["java -jar", "/movie-info-service-0.0.1-SNAPSHOT.jar"]


