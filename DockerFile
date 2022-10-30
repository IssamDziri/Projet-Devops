FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} achat.jar
ENTRYPOINT ["java","-jar","/achat.jar"]
EXPOSE 8089