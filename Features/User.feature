
Feature: Create and search user

	Background: Below are the steps common to the scenarios present in here
		Given User launches chrome browser
    When Opens url: "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters email: "Admin" and password: "admin123"
    And Click on LOG IN
    Then We should see user dropdown
    When We click on PIM
    Then We should see the PIM header

  Scenario: Create and Search User
    Then We should see the PIM header
    When we click on Add button
    And Enter the required details
    And Save it
    Then Employee gets added and we should see the employee header name
    When We click on PIM module again
    And We enter employee name
    And We click on Search button
    Then Employee name is fetched and should be equal to the searched employee name
    And Close the browser
    
  
  	  
    
	

