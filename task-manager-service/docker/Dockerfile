FROM openjdk:8
ADD /taskmanager-service-0.0.1-SNAPSHOT.jar taskmanager-service.jar
EXPOSE 8089
RUN bash -c 'touch /taskmanager-service.jar'
ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://localhost:27017/test","-jar","task.manager.service-0.0.1-SNAPSHOT.jar"]