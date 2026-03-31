@cartpage
Feature: Validating Shopping cart functionality

Background:
Given Users click on login link
Then Users navigate to demowebshop login page
When Users enters the valid  "abinaya200@gmail.com","abinaya"
And Users click on login button
Then Users should verify login status "abinaya200@gmail.com"

@adding_cart
Scenario: Adding product to shopping cart
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

