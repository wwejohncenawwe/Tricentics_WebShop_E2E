@loginpage
Feature: Validating Login functionality

@valid_login
Scenario Outline: Login with valid data
Given User click on login link
Then User navigate to demowebshop login page
When User enters the valid  "<email>","<password>"
And User click on login button
Then User should verify login status "<status2>" 
Examples:
|email          |password|status2|
|abinaya200@gmail.com|abinaya   |abinaya200@gmail.com|

@login_with_pword
Scenario Outline: Login with pword data
Given User click on login link
Then User navigate to demowebshop login page
When User enters pword "<password>"
And User click on login button
Then User should verify the without email error message status "<status>" 
Examples:
|password|status|
|nehru0   |Login was unsuccessful. Please correct the errors and try again.|

@login_with_email
Scenario Outline: Login with email data
Given User click on login link
Then User navigate to demowebshop login page
When User enters email "<email>"
And User click on login button
Then User should verify without pword error message status "<status>" 
Examples:
|email          |status|
|nehru@yahoo.com|Login was unsuccessful. Please correct the errors and try again.|

@invalid_pword_login
Scenario Outline: Login with invalid password data
Given User click on login link
Then User navigate to demowebshop login page
When User enters the invalid pword  "<email>","<password>"
And User click on login button
Then User should verify invalid pword error message status "<status>" 
Examples:
|email          |password|status|
|nehru@yahoo.com|nehrrr   |The credentials provided are incorrect|

@invalid_email_login
Scenario Outline: Login with invalid email data
Given User click on login link
Then User navigate to demowebshop login page
When User enters the invalid email  "<email>","<password>"
And User click on login button
Then User should verify the invalid email error message status "<status>" 
Examples:
|email          |password|status|
|kala@yahoo.com|nehru0   |No customer account found|

@invalid_email_format
Scenario Outline: Login with invalid email format data
Given User click on login link
Then User navigate to demowebshop login page
When User enters the invalid email format "<email>","<password>"
And User click on login button
Then User should verify wrong email format error message status "<status>" 
Examples:
|email          |password|status|
|nehru0@yahoo|nehru0   |Please enter a valid email address.|
