# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.1.2/gradle-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.1.2/gradle-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsingle/index.html#web)
* [Flyway Migration](https://docs.spring.io/spring-boot/docs/3.1.2/reference/htmlsingle/index.html#howto.data-initialization.migration-tool.flyway)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Docker DBs

#### Postgres
- To run: `docker run --name java-with-java-dbpersistence -e POSTGRES_PASSWORD=docker -p 5432:5432 -d postgres`
- To stop: `docker stop java-with-java-dbpersistence`
- To delete: `docker rm java-with-java-dbpersistence`

#### MySQL
- To run: `docker run -d -p 3306:3306 --name mysql-java-with-java -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=javawithjava -e MYSQL_USER=docker -e MYSQL_PASSWORD=password mysql/mysql-server:latest`
- To stop: `docker stop mysql-java-with-java`
- To delete: `docker rm mysql-java-with-java`

#### Pitfalls
- If you have MySQL or Postgres installed locally, and they are running; they may already be consuming the port necessary to connect (e.g. 5432 for postgres). There are two options to fix this:
  1. Change the docker forwarded port to something else (e.g. -p 5433:5432)
  2. Stop running the locally installed database service.

### Swagger
- Path: `http://localhost:8080/swagger-ui/index.html`
