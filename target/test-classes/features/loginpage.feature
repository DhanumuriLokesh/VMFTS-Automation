Feature: Login functionality
	
	@validlogin
	Scenario: Valid login
	   When User navigates to url and enters username "superadmin" and password "123456"
	    
	@Forgotpasswordlink    
	Scenario: To Check Forgot password link
	   When User clicks forgot password
	
	@InvalidLogin
	Scenario: Invalid Login    
		When User enter invalidusername "qwerty" and invalidpassword "222222"
		
		
	    
	    
