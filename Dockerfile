# Image
FROM jelastic/maven:3.9.5-openjdk-21

WORKDIR /app

COPY . /app/code
RUN mv code/files /app

RUN cd code \
    && mvn package -DskipTests

RUN cd .. \
    && mv /app/code/target/* /app \
    && rm -rf /app/code
