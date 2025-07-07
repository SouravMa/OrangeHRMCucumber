**OrangeHRM Automation Testing with Selenium & Cucumber**:
Automated end-to-end UI tests for https://opensource-demo.orangehrmlive.com/ using Selenium WebDriver, Cucumber, and JUnit.
This project follows the Page Object Model (POM) design pattern and uses Gherkin feature files for writing test scenarios.

**About the Project**:
This project aims to:
. Automate some of OrangeHRM's core functionalities: login-logout, PIM, Admin section functionalities etc
. Demonstrate behavior-driven development (BDD) using Cucumber  
. Provide a reusable Page Object Model for maintainable tests

**Tech stack used**:
- Java 20
- Selenium WebDriver
- Cucumber
- JUnit
- Maven

**Project Structure**:
├── src/
│ └── test/java/
  | └── pageObjects/ 		# Page classes
│ | └── stepDefinitions/ 	# Cucumber steps
│ | └── myRunner/ 			# Test runners 
├── Features/ 				# .feature files
├── log/ 					# Generating logs
├── test-report 			# Generated reports
├── config.properties		# Configuration details like browser name, webdriver paths
├── log4j.properties 		# root loggers, appender, log file location, layout and pattern related info
├── pom.xml 				# Maven build file
└── README.md

**Prerequisites**:
- JDK 11 or later
- Maven 3.6+
- ChromeDriver (or other WebDriver binaries) in system PATH
- IDE: IntelliJ IDEA / Eclipse / VS Code

**Clone this repository**:
git clone https://github.com/SouravMa/OrangeHRMCucumber.git

**Reporting**:
By default, HTML reports generated under test-report.