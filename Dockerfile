#
# Build stage
#
FROM maven:3.6.0-jdk-8-slim AS build
COPY src /home/latiendadelinfinito/src
COPY pom.xml /home/latiendadelinfinito
RUN mvn -f /home/latiendadelinfinito/pom.xml clean package -Dmaven.test.skip=true

#
# Package stage
#
FROM openjdk:8
COPY --from=build /home/latiendadelinfinito/target/*.jar /usr/local/TDI/app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/TDI/app.jar"]

