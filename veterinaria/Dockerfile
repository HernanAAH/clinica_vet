FROM eclipse-temurin:21-jdk-jammy AS build
WORKDIR /app

# Copia el contenido de la carpeta veterinaria (donde está el Dockerfile)
COPY . .

# Da permisos al mvnw para poder ejecutarlo
RUN chmod +x mvnw

# Compila el proyecto con el wrapper de Maven
RUN ./mvnw -B package -DskipTests

# Segunda etapa: imagen liviana
FROM eclipse-temurin:21-jdk-jammy
WORKDIR /app

# Copia el jar generado en la etapa anterior
COPY --from=build /app/target/*.jar app_veterinaria.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app_veterinaria.jar"]