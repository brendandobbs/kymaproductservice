# Telepresence

Build docker image

```
mvn compile jib:dockerBuild
```

Build & push image

```
mvn compile jib:build
```

Swap with telepresence

```
telepresence --swap-deployment productservice --docker-run --rm -v$(pwd -P):/build -v $HOME/.m2/repository:/m2 -p 8000:8000 -p 8080:8080 maven:3.6.1-jdk-11-slim mvn -Dmaven.repo.local=/m2 -Dspring-boot.run.jvmArguments="-Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8000 -Dspring.devtools.restart.enabled=false"   -f /build spring-boot:run
```

Use without symlinks
 
Reeference https://www.telepresence.io/tutorials/java