# Dockerfile pour l'application Timesheet
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copie du jar compilé
COPY target/timesheet-devops-1.0.jar app.jar

# Port exposé (vérifie application.properties)
EXPOSE 8081

# Commande pour lancer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
