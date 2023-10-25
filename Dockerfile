# Image
FROM jelastic/maven:3.9.5-openjdk-21

WORKDIR /app

COPY . /app

RUN mvn clean install
