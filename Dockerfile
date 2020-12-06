FROM openjdk:8

ADD /target/office-employee-info-0.0.1-SNAPSHOT.jar office-employee-info-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "office-employee-info-0.0.1-SNAPSHOT.jar"]

EXPOSE 8081