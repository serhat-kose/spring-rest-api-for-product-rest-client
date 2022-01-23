#define base docker image
FROM openjdk:11
LABEL maintainer="serhat.kose"
ADD target/product-rest-api-0.0.1-SNAPSHOT.jar prodcut-rest-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","prodcut-rest-api.jar"]
