#Specificarea imaginii de baza utilizate
FROM maven:3.8.6-jdk-11

ENV DEBUG=true
RUN echo $SPRING_APPLICATION_JSON

RUN echo Testing

#Copierea folder-ului curent in imagine
WORKDIR /docker-compose
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run

#Expunerea portului catre sistem
EXPOSE 8080