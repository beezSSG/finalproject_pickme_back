FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY application.properties ./src/main/resources/
COPY db.properties ./src/main/resources/
COPY key.properties ./src/main/resources/
COPY mail.yml ./src/main/resources/
RUN mvn clean package -DskipTests

FROM openjdk:17
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]