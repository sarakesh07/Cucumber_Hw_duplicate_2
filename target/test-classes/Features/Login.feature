Feature: Insurance Application Login

#@sanity
#Scenario: Login with valid credentials
#Given user is on the insurance login page
#When user enters username "testuser"
#And user enters password "Test@123"
#And user clicks the Login button
#Then user should see the Dashboard

Scenario Outline: Login with different credentials 
Given user is on the insurance login page
When user enters username "<username>"
And user enters password "<password>"
And user clicks the Login button
Then login result should be displayed
Examples:
| username | password |
| sarakesh   | pass1    |
| santhosh   | pass2    |
| princee    | pass3    |
