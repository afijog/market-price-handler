# My contributions

A few words, on how the project is structured, how to improve it (TODO actions) and finally how to test, build and execute it.

## Design
The main project delegates functionality to several services. Mainly:

- *fx.controller*: Classes to expose functionality as a REST service.
- *fx.model*: The POJO and standard model classes
- *fx.service.broker*: The broker to get data from feed, adjust prices and expose them to other modules
- *fx.service.feed*: Interface for subscribers and base 'hardcoded' FX price feed
- *fx.service.parser*: Parses a message line and converts to a POJO object model

## Improvements
- Use effects library (ZIO, Cats) to decouple the logic of the program from the execution. This is more Scala oriented
- If using files for price information, use streaming of big files instead of reading the whole file at once
- Read format of timestamp from properties file
- Add more JUnit tests
- Add integration tests
- Improve error handling (again using effects, Optional, Either)
- Externalise price information for feed object
- Use log functionality (logger.info, logger.error...)
- Use immutable data objects (useful for concurrency, threads)
- Decouple the caller/callee using queues and Producer/Consumer strategies
- Follow Reactive Manifesto (https://www.reactivemanifesto.org) and Twelve-Factor (https://12factor.net) principles

## Build the project
Before building the project it is a good idea to run the tests to check if everything is ok.
Some unit test are provided. To run them, execute the following command:

`mvn clean test`

Note: You can use also `mvnw` as the basic command to invoke Maven actions.

If everything is ok, you can proceed with the build process.

Execute the following command:

`mvn clean package`

You got a fat jar that is easy to execute and deploy. Manually or using CI/CD techniques (docker images for instance)

## Run the project
Execute the following command:

`java -jar target/fx-1.0.0.jar`

Open your favourite browser and go to

[http://localhost:8080/price/EUR-USD](http://localhost:8080/price/EUR-USD)

Note: The currency pair is using '-' instead of '/' to be treated as a unique parameter. 
The application will take care of that.

## How to proceed from this point
Review the code and tell us if you have any doubt.
I will be more than happy to discuss this implementation and talk about changes and improvements.

# Documentation

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.5.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.5.6/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.6/reference/htmlsingle/#boot-features-developing-web-applications)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/2.5.6/reference/htmlsingle/#boot-features-spring-mvc-template-engines)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)

