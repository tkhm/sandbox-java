# graph-bff project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./gradlew quarkusDev
```

## Packaging and running the application

The application can be packaged using:
```shell script
./gradlew build
```
It produces the `graph-bff-1.0.0-SNAPSHOT-runner.jar` file in the `/build` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `build/lib` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./gradlew build -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar build/graph-bff-1.0.0-SNAPSHOT-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./gradlew build -Dquarkus.package.type=native
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./gradlew build -Dquarkus.package.type=native -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./build/graph-bff-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/gradle-tooling.

# RESTEasy JAX-RS

<p>A Hello World RESTEasy resource</p>

Guide: https://quarkus.io/guides/rest-json

# Sidenote

- You can access GraphQL UI on http://localhost:8080/q/graphql-ui/ (schema is available on http://localhost:8080/graphql/schema.graphql )
- At the moment, this example will require your local postgres. You can run it with the following:

    ```
    docker run --name mydb1 -e POSTGRES_PASSWORD=postgres -d -p 15432:5432 postgres:11
    docker run --name mydb2 -e POSTGRES_PASSWORD=postgres -d -p 25432:5432 postgres:11
    ```

- Also if you need to insert some data, you can do it with the following example command:

    ```
    psql postgres://localhost:15432 -U postgres

    postgres=# INSERT INTO dummy1 VALUES ('dummyid1');
    ```

