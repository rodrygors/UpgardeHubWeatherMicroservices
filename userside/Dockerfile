#Image that we are using
FROM openjdk:11
ADD target/userside-0.0.1-SNAPSHOT.jar userside.jar
#EXPOSE 8080
ENTRYPOINT ["java", "-jar", "userside.jar"]