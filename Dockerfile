FROM maven:3.9.11-eclipse-temurin-21-alpine AS build

COPY . .

RUN mvn clean install package -DskipTests

FROM eclipse-temurin-21-alpine

COPY --from=build target/credentium-service.jar

EXPOSE 8080

CMD ["java", "-jar", "credentium-service.jar"]