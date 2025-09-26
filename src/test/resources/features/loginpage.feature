Feature: Login functionality

Background: 	
	Given user navigates to application 

@validLogin
#Scenario for successful login
	Scenario: Valid login
    	When User enters valid username "superadmin" and password "123456"

#Scenario for forgot password Link
	Scenario: To check whether forgot password link is working or not 
		When User clicks on forgot Password link