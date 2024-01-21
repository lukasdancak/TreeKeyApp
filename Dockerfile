# Use Maven base image with OpenJDK 17
FROM maven:3.8.4-openjdk-17-slim as build

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file into the container
COPY pom.xml .

# Copy the source code into the container
COPY src ./src

# Package the application with tests skipped
RUN mvn package -DskipTests

# Use OpenJDK 17 as the base image for the final stage
FROM openjdk:17-jdk-slim-buster

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the build stage into the container
COPY --from=build /app/target/*.jar app.jar

# Set the command to start the application
ENTRYPOINT ["java","-jar","app.jar"]
