Feature: Login-Logout
	
	
  Scenario: Successful login with valid credentials
    Given User launches chrome browser
    When Opens url: "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters email: "Admin" and password: "admin123"
    And Click on LOG IN
    Then We should see user dropdown
    When we click on user dropdown
    And click on logout option
    Then We should see Login message
    And Close the browser