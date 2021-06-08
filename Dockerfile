FROM openjdk:8
MAINTAINER manuelsp7@outlook.es

ENTRYPOINT ["java", "-jar", "/usr/share/TDI/app.jar"]

ADD ./tienda_del_infinito-0.0.1.jar /usr/share/TDI/app.jar
