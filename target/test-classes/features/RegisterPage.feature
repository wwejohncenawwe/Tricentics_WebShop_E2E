@registerpage
Feature: Validating Register functionality

@positive
Scenario Outline: Register with valid data
Given User click on register link
Then User navigate to demowebshop register page
When User enters valid data "<firstname>","<lastname>","<email>","<password>","<confirmpassword>" for registration details
And User click on register button 
Then User should verify success register status "<status1>"
And User click logout link
Examples:
|firstname|lastname|email|password|confirmpassword|status1|
|abinaya|abinaya|abinaya200@gmail.com|abinaya|abinaya|Your registration completed|


@negative_invalid_email
Scenario Outline: Register with invalid email data
Given User click on register link
Then User navigate to demowebshop register page
When User enters invalid email "<firstname>","<lastname>","<email>","<password>","<confirmpassword>" for registration details
And User click on register button 
Then User should verify invalid email error message status "<status>"
Examples:
|firstname|lastname|email|password|confirmpassword|status|
|jawa|nehruu|nehr@mail|nehru0|nehru0|Wrong email|


@negative_exists_email
Scenario Outline: Register with exists email data
Given User click on register link
Then User navigate to demowebshop register page
When User enters exists email "<firstname>","<lastname>","<email>","<password>","<confirmpassword>" for registration details
And User click on register button 
Then User should verify exists email error message status "<status>"
Examples:
|firstname|lastname|email|password|confirmpassword|status|
|jawar|nehru|nehru@yahoo.com|nehru0|nehru0|The specified email already exists|


@negative_without_email
Scenario Outline: Register without email data
Given User click on register link
Then User navigate to demowebshop register page
When User enters without email "<firstname>","<lastname>","<password>","<confirmpassword>" for registration details
And User click on register button 
Then User should verify without email error message status "<status>"
Examples:
|firstname|lastname|password|confirmpassword|status|
|jawar|nehru|nehru0|nehru0|Email is required.|


@negative_without_fname
Scenario Outline: Register without firstname data
Given User click on register link
Then User navigate to demowebshop register page
When User enters without fname data "<lastname>","<email>","<password>","<confirmpassword>" for registration details
And User click on register button 
Then User should verify without fname error message status "<status>"
Examples:
|lastname|email|password|confirmpassword|status|
|nehr|nehru@gmail.com|nehru0|nehru0|First name is required.|

@negative_without_lname
Scenario Outline: Register without lastname data
Given User click on register link
Then User navigate to demowebshop register page
When User enters without lname data "<firstname>","<email>","<password>","<confirmpassword>" for registration details
And User click on register button 
Then User should verify without lname error message status "<status>"
Examples:
|firstname|email|password|confirmpassword|status|
|neh|nehru@bing.com|nehru0|nehru0|Last name is required.|


@negative_without_pword_cpword
Scenario Outline: Register without password and confirm password data
Given User click on register link
Then User navigate to demowebshop register page
When User enters without pword and cpword data "<firstname>","<lastname>","<email>" for registration details
And User click on register button 
Then User should verify without pword and cpword error message status "<status>"
Examples:
|firstname|lastname|email|status|
|jaw|nehrur|neh@gmail.com|Password is required.|

@negative_without_pword
Scenario Outline: Register without password data
Given User click on register link
Then User navigate to demowebshop register page
When User enters without pword data "<firstname>","<lastname>","<email>","<confirmpassword>" for registration details
And User click on register button 
Then User should verify without cpword error message status "<status>"
Examples:
|firstname|lastname|email|confirmpassword|status|
|jaw|nehrur|nehh@gmail.com|nehr00|The password and confirmation password do not match.|


@negative_invalid_pword_length
Scenario Outline: Register with invalid password length data
Given User click on register link
Then User navigate to demowebshop register page
When User enters with invalid pword length data "<firstname>","<lastname>","<email>","<password>","<confirmpassword>" for registration details
Then User should verify invalid pword length error message status "<status>"
Examples:
|firstname|lastname|email|password|confirmpassword|status|
|jaw|nehrur|nehhut@gmail.com|ne|ne|The password should have at least 6 characters.|
