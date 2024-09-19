# Stage 1: Build Stage
FROM eclipse-temurin:21-jdk AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle wrapper and build files
COPY sheblossoms/gradlew gradlew
COPY sheblossoms/gradle gradle
COPY sheblossoms/build.gradle .
COPY sheblossoms/settings.gradle .

# Copy the source code
COPY sheblossoms/src src

# Grant execution rights to the Gradle wrapper
RUN chmod +x gradlew

# Build the application
RUN ./gradlew clean build -x test

# Stage 2: Runtime Stage
FROM eclipse-temurin:21-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the built jar file from the build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Set the active Spring profile
ENV SPRING_PROFILES_ACTIVE=prod

# Expose the port that your application runs on
EXPOSE 8081

# Entry point to run the application
ENTRYPOINT ["java","-jar","/app/app.jar"]