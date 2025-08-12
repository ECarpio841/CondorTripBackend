# ---- Build stage ----
FROM maven:3.9.6-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN --mount=type=cache,target=/root/.m2 mvn -q -DskipTests package

# ---- Runtime stage ----
FROM eclipse-temurin:21-jre
WORKDIR /app
# Copia el jar construido
COPY --from=build /app/target/*.jar app.jar

# Render expone un PORT dinámico; Spring debe escuchar en ese puerto
ENV JAVA_OPTS="-XX:MaxRAMPercentage=75.0"
EXPOSE 10000
CMD sh -c "java $JAVA_OPTS -Dserver.port=$PORT -jar app.jar"
