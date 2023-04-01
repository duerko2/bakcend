FROM openjdk:17-oracle
MAINTAINER defaglige5
COPY target/webshop-0.0.2.jar webshop-0.0.2.jar
ENTRYPOINT ["java","-jar","/webshop-0.0.2.jar"]