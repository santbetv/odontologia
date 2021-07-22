FROM openjdk:8-jre-alpine
ADD microservicio/build/libs/*.jar app.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/app.jar"]