
Feature: Leave section features

	Background: Below are the steps common to the scenarios present in here
		Given User launches chrome browser
    When Opens url: "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters email: "Admin" and password: "admin123"
    And Click on LOG IN
    Then We should see user dropdown
    When We click on Leave
    Then We should see the Leave header

  Scenario: Apply for leave
  	When User clicks on Apply section
    And User selects leave type
    And Selects from date
    And Selects to date
    And Click on Apply
    Then User should see the success message
    And Close the browser
    

  #@tag2
  #Scenario Outline: Title of your scenario outline
    #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
#
    #Examples: 
      #| name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
