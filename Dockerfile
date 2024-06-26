# Start with a base image containing OpenJDK 11 runtime
FROM openjdk:11-jdk-slim

# Add a volume pointing to /tmp
VOLUME /tmp

# Copy the JAR file into the container at /app.jar
COPY target/spring-boot-crud-1.0.jar app.jar

# Specify the default command to run when the container starts
CMD ["java", "-jar", "app.jar"]
