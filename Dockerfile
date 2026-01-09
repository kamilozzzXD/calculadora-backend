#Build
FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /app

# Copiamos primero los archivos necesarios para descargar dependencias
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn

# Descarga dependencias (cacheable)
RUN mvn -B dependency:go-offline

# Copiamos el código fuente
COPY src ./src

# Construimos el jar
RUN mvn -B clean package -DskipTests


#RUNTIME
FROM eclipse-temurin:21-jre

WORKDIR /app

# Copiamos solo el jar desde el stage build
COPY --from=build /app/target/*.jar app.jar

# Puerto estándar Spring Boot
EXPOSE 8080

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]