# Use a base image with Java 17 installed
FROM openjdk:17-jdk-slim

# Install necessary packages
RUN apt-get update && apt-get install -y \
    python \
    g++ \
    wget \
 && rm -rf /var/lib/apt/lists/*

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file from the host into the container at the working directory
COPY target/OnlineCompiler-0.0.1.jar /app/

# Command to run the Spring Boot application
CMD ["java", "-jar", "OnlineCompiler-0.0.1.jar"]
