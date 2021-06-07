#Where we start
FROM openjdk:8-alpine AS builder

#Get APK up to date
RUN apk update && apk upgrade

#Install Maven
RUN apk add maven

#Build
RUN mvn clean install

# Build release image
FROM openjdk:8-alpine

#Copy result
WORKDIR /Executables
COPY --from=builder /target/docker .

#Add user and group for running as unprivileged user
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

#Define how to start
ENTRYPOINT ["java", "-jar", "HungryBoii-1.0-SNAPSHOT.jar"]