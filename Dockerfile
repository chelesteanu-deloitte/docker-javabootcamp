#Specificarea imaginii de baza utilizate
FROM openjdk:11-jdk-bullseye

#Copierea folder-ului curent in imagine
ARG JAVA_FILE=/target/*.jar

ARG MY_NAME=YourNameHere

ENV BOOTCAMP_USER=$MY_NAME

#Rularea unei comenzi pentru compilarea proiectului in interiorul imaginii
COPY $JAVA_FILE app.jar


#Specificarea procesului de intrare al imaginii
ENTRYPOINT ["java", "-jar", "app.jar"]

#Expunerea portului catre sistem
EXPOSE 8080