Feature: Login
	This feature tests all the functionalities related to login

	Scenario: Failed login with wrong password
		Given User is on the homepage
		When User enters a valid username and password is wrong
		And User clicks on Login button	
		Then he will see the message regarding password incorrect "The password you’ve entered is incorrect. Forgot Password?"
		
		
	Scenario: Failed login with empty email
		Given User is on the homepage
		When User enters an empty username and  password
		And User clicks on Login button		
		Then he will see the message regarding email invalid "The email or mobile number you entered isn’t connected to an account. Find your account and log in."
	 


	
	
