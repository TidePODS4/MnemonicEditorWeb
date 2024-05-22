FROM maven:3.8.5-openjdk-22 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:22
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
VOLUME /tmp
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
