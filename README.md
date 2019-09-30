# A Java/Maven/JUnit Shopping Cart example

A shopping cart sample written in Java using Maven for the build, that showcases tests for all possible scenarios.

This example demonstrates:

* A simple Java 8 application with tests
* Unit tests written with [JUnit 4](https://junit.org/junit4/)
* Code coverage reports via [JaCoCo](https://www.jacoco.org/jacoco/)
* A Maven build that puts it all together

## Running the tests

* To run the unit tests, call `mvn test`, it will download all dependencies and run all test cases.
* Code coverage reports are generated when we call `mvn clean install`.

  Point a browser at the output in `target/site/jacoco-both/index.html` to see the report.

## Project Structure

This example follows the following basic maven project structure:

* All java development resides in `src/main/java/*`
* All java tests reside in `src/test/java/*`

## Running shopping application

* Each step of development is converted to zip file. (Multiple zip files available for multiple development steps)
* Need any IDE, Eclipse or Intellij to import the code as maven project.
* After importing maven project, run `mvn clean install`, it will download all the required dependencies and `mvn test` to run all test cases.
* We can either run only `mvn test` for both, to download dependencies as well as to run test cases.
* Each requirement is fulfilled in mentioned test cases with 100% code coverage of service(business logic) layer.
* To see test coverage, check index.html file present in `target/site/jacoco-both/index.html` path, which can be opened using any broswer.

