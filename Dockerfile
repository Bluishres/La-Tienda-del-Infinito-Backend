#
# Build stage, o fase build, donde le diremos a docker que compile nuestra API con maven.
#
FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/latiendadelinfinito/src
COPY pom.xml /home/latiendadelinfinito
RUN mvn -f /home/latiendadelinfinito/pom.xml clean package -Dmaven.test.skip=true

#
# Package stage, o fase de empaquetamiento, donde moveremos el .jar generado previamente al contenedor de docker hub,
# y le diremos con "ENTRYPOINT" el comando a ejecutyar cuando el contenedor este activo.
#
FROM openjdk:8
COPY --from=build /home/latiendadelinfinito/target/*.jar /usr/local/TDI/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/TDI/app.jar"]

