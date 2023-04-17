@Tag
Feature: Login to Facebook

Background: 
#List of steps run before each of the scenarios

   Given User is on Facebook homepage "https://www.facebook.com/"
  
   @ValidCredentials
   Scenario: Login with valid credentials
      
    When User enters username as "test@gmail.com" and password as "test@1234"
    And  User clicks on Login button
    Then User should be able to login sucessfully and new page open
     
   @InvalidCredentials
   Scenario Outline: Login with invalid credentials
      
    When User enters username as "<email>" and password as "<password>"
    And  User clicks on Login button
    Then User should be able to see error message "<errorMessage>"
     
  Examples:
  | email   			    | password   | errorMessage                      														|
  | Admin@gmail.com   | admin12$$  | The password you’ve entered is incorrect. Forgot Password?   |
  | abcd2@gmail.com 	| test@1234  | The password you’ve entered is incorrect. Forgot Password?   |