
Feature: Add to cart

 
  Scenario: Add the desired monitor to cart
    Given User launches chrome browser
    When Opens url: "https://tutorialsninja.com/demo/index.php?route=account/login"
    And User enters email: "elricalp1997@gmail.com" and password: "#Mytutorialsninja97"
    And Click on LOG IN
    Then We should see Logout link
    When We click on Components dropdown
    And Click on Monitors
    Then We should see the Monitors header
    When We click on the desired monitor
    Then We should see the desired monitor name
    When Update the quantity
    And Click on Add to Cart button
    Then We should see the success message
    And Close the browser
    

