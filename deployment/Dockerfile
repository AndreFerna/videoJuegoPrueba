FROM openjdk:17-alpine@sha256:4b6abae565492dbe9e7a894137c966a7485154238902f2f25e9dbd9784383d81

EXPOSE 8081

VOLUME /tmp

COPY applications/app-service/build/libs/app-service.jar tournament.jar

# Replace with a non-root user to avoid running the container with excessive privileges
#RUN adduser -D -g '' appuser
#USER appuser

ENTRYPOINT ["java", "-jar","/tournament.jar"]
