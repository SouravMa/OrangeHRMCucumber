
Feature: Check all admins

	Background: Below are the steps common to the scenarios present in here
		Given User launches chrome browser
    When Opens url: "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters email: "Admin" and password: "admin123"
    And Click on LOG IN
    Then We should see user dropdown
    When We click on Admin
    Then We should see the Admin header

	
  Scenario: List all admins
    Then We should list down all the admins with their statuses
    And Close the browser
  
  @Sanity  
  Scenario: Count the number of enabled and disabled admins
  	Then We count the number of enabled and disabled admins
  	And Close the browser

