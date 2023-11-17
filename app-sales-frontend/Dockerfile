FROM node:16.16.0-alpine3.15

RUN adduser -S appuser

WORKDIR /app

RUN npm install -g serve

ARG ATHENA_ENV

COPY . /app

RUN npm install

RUN npm run build

USER appuser

CMD ["serve", "-s", "dist", "-p", "8080"]