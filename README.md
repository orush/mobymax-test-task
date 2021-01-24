# Mobymax Test Automation Project

This is the Mobymax test automation project. It supports Web UI testing.

## Table of Contents

1. Environment requirements
2. Test project configuration
3. Running tests
4. Allure report
5. Project dependencies

## 1. Environment requirements

**Required:** Chrome browser, Java Development Kit 11 (JDK11) and maven 3 should be present on environment in order to develop and/or run the tests.

Also, https://projectlombok.org/ is used to simplify creating/editing Java POJOs (data models). So in order to work with Project from IDE Lombok plugin should be installed.

## 2. Test project configuration

Run this command from the start to ensure that all project dependencies installed

```
$ mvn clean install -U -DskipTests=true
```

## 3. Running tests

In most simple way this command could be used to start tests execution:

```
$ mvn clean test -Dsuite=<suite> -Denv=<environment> -Ddriver.type=<browser>
```

Possible values for some command line properties:

* `suite` is `regression`
* `env` is `dev`
* `driver.type` is `chrome`

By default, test cases is executed in the headless mode. If you want to start them up in the display mode you have to define the following property `-Ddriver.headless=false`.

## 4. Allure report

Use `mvn allure:serve` to open up allure report.

Also, during test execution the appropriate log message will output in the console.

## 5. Project dependencies

* `selenide` - wrapper on top of webDriver API client for browser manipulations.
* `webdrivermanager` - browsers driver resolver for managing webDriver binaries.
* `testng` - unit test framework for tests execution.
* `assertj-core` - matchers library for providing test assertions (when selenide assertions cannot be used).
* `allure-testng` - allure adapter for testng that enables logging feature.
* `aspectjweaver` - aspects weaver for AOP.
* `lombok` - helper library that simplifies creating/editing Java POJOs.
* `javafaker` - fake data creator that helps to generate test data.