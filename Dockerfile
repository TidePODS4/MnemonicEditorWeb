FROM openjdk:22
VOLUME /tmp
COPY target/*.jar GraduationProjectTestApp-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/app.jar"]