##FROM adoptopenjdk/openjdk11:jdk-11.0.11_9-alpine-slim
FROM eclipse-temurin:11-jdk-jammy

COPY ../../docker-compose-integration/integration/camel-demo-service-3.16.0.jar /opt/camel-example-spring-boot-rest-openapi-3.16.0.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar"]
CMD ["/opt/camel-example-spring-boot-rest-openapi-3.16.0.jar"]