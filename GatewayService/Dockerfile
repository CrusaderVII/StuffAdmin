FROM eclipse-temurin:18-jdk-alpine
VOLUME /tmp

COPY target/GatewayService-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]