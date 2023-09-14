FROM openjdk:17-jdk-slim
ARG JAR_FILE=build/libs/hanghae-plus-kotlin-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} hanghae-plus-kotlin-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/hanghae-plus-kotlin-0.0.1-SNAPSHOT.jar"]