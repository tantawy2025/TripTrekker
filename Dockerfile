FROM amazoncorretto:17
COPY target/*.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar","app.jar"]