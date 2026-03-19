## 1. Compilação

FROM ubuntu:latest AS build

## 2. Java

RUN apt-get update
RUN apt-get install -y openjdk-21-jdk

## 3. Maven

RUN apt-get install -y maven

## 4. Copiar o projeto para o container
COPY . .

## 5. Compilar o projeto para .jar com o Maven

RUN mvn clean install -DskipTests

## 6. Execução

FROM eclipse-temurin:21-jdk-jammy

## 7. Abrir a porta padrão do Spring

EXPOSE 8080

## 8. Copiar o jar para o container de execução

COPY --from=build /target/gamestore-0.0.1-SNAPSHOT.jar app.jar

## 9. Definir o comando de execução do container

ENTRYPOINT [ "java", "-jar", "app.jar" ]