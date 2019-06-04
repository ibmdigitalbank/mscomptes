FROM openjdk:8
ADD target/mscomptes-app.jar mscomptes-app.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar","mscomptes-app.jar"]