# --- Etapa 1: Construir el JAR ---
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# --- Etapa 2: Ejecutar la App ---
FROM eclipse-temurin:21-jdk-alpine
COPY --from=build /app/target/*.jar app.jar
# CORRECCION AQUI: Sin corchetes ni comillas
ENTRYPOINT java -jar /app.jar