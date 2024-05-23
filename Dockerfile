FROM maven:3.9.6-eclipse-temurin-22 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:22
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
VOLUME /tmp
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
