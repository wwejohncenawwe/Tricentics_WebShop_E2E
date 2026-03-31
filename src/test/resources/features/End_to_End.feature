@DemoWebShop_End_to_End_TestCase
Feature: Validating DemoWebShop Functionality

Scenario Outline: Register, Login, Addcart, Checkout into DemoWebShop
Given User navigate to demowebshop
Then User should verify the demowebshop logo in the homepage
Given User click on register link
Then User navigate to demowebshop register page
When User enters valid data "<firstname>","<lastname>","<email>","<password>","<confirmpassword>" for registration details
And User click on register button 
Then User should verify success register status "<status1>"
And User click logout link
Given User click on login link
Then User navigate to demowebshop login page
When User enters the valid  "<email>","<password>"
And User click on login button
Then User should verify login status "<status2>" 

Given User click cell phones form electronics link
Then User navigate to demowebshop cell phones page
|Cell phones|
When User click add to cart button
Then User should verify the popup message added for shopping cart
|The product has been added to your shopping cart|
When User click on shopping cart link
Then User should verify the product name,quantity and total
And User modifying quantity and click update shopping cart
Then User select country,state and zipcode
|country|state|zipcode|
|United States|Hawaii|6050400|
And User click estimate shipping
Then User should verify the product total price
Then User accept terms of service
And User click checkout button

Given User navigate to checkout page
When User enters billing address
Then User click on billing address continue button
And User select shipping address
And User click shipping address continue button
And User select shipping method
And User click  shipping method continue button
And User click cash on delivery method
And User click payment method continue button
Then User verify payment information for cash on delivery
And User click payment information continue button
Then User verify the billing and shipping address from confirm order
Then User verify product total and total price
And User click confirm order continue button
Then User should verify the order success message
And User click order success continue button

Examples:
|firstname|lastname|email|password|confirmpassword|status1|status2|
|abinaya|abinaya|abinaya600@gmail.com|abinaya|abinaya|Your registration completed|abinaya600@gmail.com|


