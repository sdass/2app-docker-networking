FROM openjdk:8
ADD target/spring-docker-0.0.1.jar /tmp/spring-docker-0.0.1.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/tmp/spring-docker-0.0.1.jar"]