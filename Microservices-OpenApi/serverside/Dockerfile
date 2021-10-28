#Image that we are using
FROM openjdk:11
ADD target/serverside-0.0.1-SNAPSHOT.jar serverside.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "serverside.jar"]