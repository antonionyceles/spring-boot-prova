FROM openjdk:11
RUN mkdir -p /opt/app
ENV PROJECT_HOME /opt/app
COPY target/prova-0.0.1-SNAPSHOT.jar $PROJECT_HOME/prova.jar
WORKDIR $PROJECT_HOME
CMD ["java", "-jar", "./prova.jar"]
EXPOSE 8090

