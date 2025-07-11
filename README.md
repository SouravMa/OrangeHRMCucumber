**OrangeHRM Automation Testing with Selenium & Cucumber**:
Automated end-to-end UI tests for https://opensource-demo.orangehrmlive.com/ using Selenium WebDriver, Cucumber, and JUnit.
This project follows the Page Object Model (POM) design pattern and uses Gherkin feature files for writing test scenarios.

**About the Project**:
This project aims to:
. Automate some of OrangeHRM's core functionalities: login-logout, PIM, Admin, Leave, Recruitment section functionalities etc
. Demonstrate behavior-driven development (BDD) using Cucumber  
. Provide a reusable Page Object Model for maintainable tests

**Tech stack used**:
- Java 20
- Selenium WebDriver
- Cucumber
- JUnit
- Maven

**Project Structure**:

<img width="386" alt="Screenshot 2025-07-07 at 8 03 03 PM" src="https://github.com/user-attachments/assets/9dfba67c-2d66-4cb6-a834-9a87915b8a71" />

- myRunner- contains test runner
- pageObjects- contains page objects referring to different pages
- stepDefinitions- contains baseclass inherited by the class for step definition
- Features- contains different feature files
- log- contains generated logs
- test-report- contains generated report
- config.properties- contains browser name and driver paths
- log4j.properties- contains details related to root loggers, appender, log file location, layout and pattern
- pom.xml- for dependency management 

**Prerequisites**:
- JDK 11 or later
- Maven 3.6+
- ChromeDriver (or other WebDriver binaries) in system PATH
- IDE: IntelliJ IDEA / Eclipse / VS Code

**Clone this repository**:
git clone https://github.com/SouravMa/OrangeHRMCucumber.git

**Reporting**:
By default, HTML reports generated under test-report.
