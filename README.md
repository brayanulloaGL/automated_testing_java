# Web Automation Testing Framework

The following tecnologies were implemented in this project: 

- Selenium WebDriver
- Java
- TestNG
- Maven
- Page Object model as design pattern
- Jenkins integration

## Objective of this project

This project is a work automation plan that consists in attempting to create an automation testing framework including above tecnologies.
The following web site is the one used for this plan: (which is a common web site for learning and assesment purposes.)

- https://www.saucedemo.com/

## Project Structure

The following is the basic structure of this project:
- resources > TestNG files
- test > base > pages > tests
- target
- pom.xml

## TestNG files

- **GroupRun.xml:** this TestNG file will allow the tester to execute the test cases based on their groups, for example, some of the groups implemented are:

```sh
(groups = {"Regression", "Positive"})
(groups = {"Regression", "Negative"})
(groups = {"UI", "Positive"})
(groups = {"Smoke", "Positive"})
```
- **ParallelRun:** this TestNG file will allow the tester to execute the test cases in parallel way, which will improve the execution time of the test cases.
- **RegularRun:** this TestNG file will allow the tester to execute the test cases one by one.

All the TestNG files have the following parameters, which allows the tester to choose the desired browser for the execution, URL (same for everything) & implicit wait:

```sh
<parameter name="browser" value="<browser>"/> **Chrome, Firefox or Headless**
<parameter name="url" value="https://www.saucedemo.com/"/>
<parameter name="implicitWait" value= "<time>"/>
```

## How to execute a test case(s)

1. **Via IDE running configuration (Edit Configuration option)**
- In order to use this way, the tester should set the following parameters previously:
```sh
VM Options: -Dbrowser=chrome -Durl=https://www.saucedemo.com/ -DimplicitWait=120
Environment Variables: SAUCE_USERNAME=standard_user;SAUCE_PASSWORD=secret_sauce, SAUCE_USERNAME_LOCKED="locked_out_user", SAUCE_PASSWORD_LOCKED="secret_sauce"
```
2. **Via Maven command**
- In order to use this way, the tester should go to a terminal and export the following environment variables (if using MacOS):

```sh
export SAUCE_USERNAME=standard_user
export SAUCE_PASSWORD=secret_sauce
export SAUCE_USERNAME_LOCKED="locked_out_user"
export SAUCE_PASSWORD_LOCKED="secret_sauce"
```
- In the same terminal, in order to  start executing the test cases, the tester should run the following command:
```sh
mvn clean install -D TestNGFile=<TestNG file name>.xml
```

> Note: if using Windows, please refer to this documentation: https://www.architectryan.com/2018/08/31/how-to-change-environment-variables-on-windows-10/

## Where can this project be found?

This project can be found in the following link:
- https://github.com/brayanulloaGL/automated_testing_java

**Happy testing!**
