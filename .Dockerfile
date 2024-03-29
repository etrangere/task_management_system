# Use the official OpenJDK base image with Java 17
FROM openjdk:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the entire application folder into the container at /app
COPY ./em_test.jar /app

# Expose the port your application will run on
EXPOSE 8446

# Command to run your application
CMD ["java", "-jar", "-Dspring.profiles.active=prod", "em_test.jar"]
