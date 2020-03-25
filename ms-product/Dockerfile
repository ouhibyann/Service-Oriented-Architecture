FROM openjdk:8-jre-alpine

MAINTAINER yann ouhib

WORKDIR /applications

COPY ms-product-1.0-SNAPSHOT.jar /applications/app_product.jar

ENTRYPOINT ["java", "-jar", "/applications/app_product.jar"]