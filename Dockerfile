FROM openjdk:8-jdk-alpine
 
# copy the packaged jar file into our docker image
COPY build/libs/word-management-0.0.1-SNAPSHOT.jar /demo.jar
 
# set the startup command to execute the jar
CMD ["java", "-jar", "/demo.jar"]