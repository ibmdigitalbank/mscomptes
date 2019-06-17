FROM openjdk:8
ADD target/mscomptes.jar mscomptes.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","mscomptes.jar"]