
Feature: Search from menu

 
  Scenario: Search from menu and open it
    Given User launches chrome browser
    When Opens url: "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters email: "Admin" and password: "admin123"
    And Click on LOG IN
    Then We should see user dropdown
    When We click on search bar
    And Enter "recruitment"
    And Click on it
    Then Recruitment module opens and we should see Recruitment header
    And Close the browser
    

