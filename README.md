# Comtrade360 Java Assignment

## Getting started

In order to start the app the following command can be used:

```
mvnw spring-boot:run
```

By default, there are 2 spring profiles active:
- db
- h2

This can be easily change with help of command line argument or environment variable (SPRING_PROFILES_ACTIVE).

There is one required command line argument or environment variable to be specified called __SYSTRAN_API_KEY__, which will be used when communicating with external Systran service.

## Docker compose

There is a convenient _docker-compose_ file in the root of the project which starts the following services:
- application with spring profiles __db__ and __postgres__ activated
- postgres database
- adminer for having a web client for postgres database
- another application instance with spring profile __external__ for communicating with external translation service _Systran_.
- nginx instance as reverse proxy

Only nginx and adminer services are exposed directly to the client.
