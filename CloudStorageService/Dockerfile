FROM eclipse-temurin:18-jdk-alpine
VOLUME /tmp

COPY target/CloudStorageService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]