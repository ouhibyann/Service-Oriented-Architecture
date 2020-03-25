FROM openjdk:8-jre-alpine

MAINTAINER yann ouhib

WORKDIR /applications

COPY target/ms-basket-1.0-SNAPSHOT.jar /applications/app_basket.jar

ENTRYPOINT ["java", "-jar", "/applications/app_basket.jar"]