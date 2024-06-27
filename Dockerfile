FROM openjdk:11-jdk-slim

VOLUME /tmp

COPY target/spring-boot-crud-1.0.jar app.jar

CMD ["java", "-jar", "app.jar"]
