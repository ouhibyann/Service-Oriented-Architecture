FROM openjdk:8-jre-alpine

MAINTAINER yann ouhib

WORKDIR /applications

COPY ms-membership-1.0-SNAPSHOT.jar /applications/app_membership.jar

ENTRYPOINT ["java", "-jar", "/applications/app_membership.jar"]