#Etapa de construccion
FROM maven:3.9.6-eclipse-temurin-21 AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa de ejecución
FROM openjdk:21-jdk-slim
WORKDIR /app

# Instalar curl
RUN apt-get update && apt-get install -y curl

ENV OTEL_AGENT_VERSION=2.19.0
RUN curl -L https://github.com/open-telemetry/opentelemetry-java-instrumentation/releases/download/v${OTEL_AGENT_VERSION}/opentelemetry-javaagent.jar -o opentelemetry-javaagent.jar

COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-javaagent:/app/opentelemetry-javaagent.jar","-jar","app.jar"]