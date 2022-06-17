# About this app


## Running this app
Download the source and run it as spring boot app

```
mvn spring-boot:run
```

## API documentation

```
localhost:8081/swagger-ui/#
```

## Persistance: H2 Database
User browser to access H2 console: localhost:8081/h2-console<br>

- Connection details:
  - url=jdbc:h2:mem:testdb<br>
  - username=admin<br>
  - password=admin<br>

## Caching
Using Hibernate L2 cache for entity caching. Implemented by EHCache.
