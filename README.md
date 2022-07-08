# AdminLoginBackend
___
1. Run postgres using docker-compose

 ```
 docker-compose -f docker/docker-compose.local.yml up -d
 ```

2. Build project with maven

```
   ./mvnw clean install
```

3. Run it using java

```
    java -jar ./target/admin-app-backend-0.0.1-SNAPSHOT.jar
```