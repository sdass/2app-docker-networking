FROM openjdk:8
ADD target/spring-consume-0.0.1-SNAPSHOT.jar /tmp/spring-consume-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/tmp/spring-consume-0.0.1-SNAPSHOT.jar"]