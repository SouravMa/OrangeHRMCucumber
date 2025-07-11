
Feature: Recruitment section features

	Background: Below are the steps common to the scenarios present in here
		Given User launches chrome browser
    When Opens url: "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters email: "Admin" and password: "admin123"
    And Click on LOG IN
    Then We should see user dropdown
    When We click on Recruitment
    Then We should see the Recruitment header
	
	@CandidtaeRecruitment
  Scenario: Candidate application
  	When We click on Add button 
  	And User enters full name
  	And User enters email
  	And User clicks on Save
  	Then User should see the success message
  	And Close the browser

  @DDCandidtateRecruitment
  Scenario Outline: Candidate application
  	When We click on Add button 
  	And User enters "<firstName>", "<middleName>" and "<lastName>" 
  	And User enters "<email>"
  	And User clicks on Save
  	Then User should see the success message
  	And Close the browser

    Examples: 
      | firstName  | middleName | lastName  | email |
      | Baburao | Ganpatrao | Apte | babgandapt123@gmail.com |
      | Lionel | Anres | Messi | liadnme098@gmail.com |
      
  @ListAllVacancies
  Scenario: List all the existing vacancies
  	When User clicks on Vacancies section
  	Then User should see the Vacancies header
  	Then All the vacancies get listed down
  	And Close the browser