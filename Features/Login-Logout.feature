Feature: Login-Logout

  Scenario: Successful login with valid credentials
    Given User launches chrome browser
    When Opens url: "https://tutorialsninja.com/demo/index.php?route=account/login"
    And User enters email: "elricalp1997@gmail.com" and password: "#Mytutorialsninja97"
    And Click on LOG IN
    Then We should be able to see Logout link
    When User clicks on Logout link
    Then The page header should be "Account Logout"
    And Close the browser
    
  Scenario Outline: Datat driven login with valid credentials
    Given User launches chrome browser
    When Opens url: "https://tutorialsninja.com/demo/index.php?route=account/login"
    And User enters email: "<email>" and password: "<password>"
    And Click on LOG IN
    Then We should be able to see Logout link
    When User clicks on Logout link
    Then The page header should be "Account Logout"
    And Close the browser  

    Examples:
    |email|password|
    |sm9063519@gmail.com|#Mytutorialsninja97|
    |sc4234751@gmail.com|Lithium2!|
    