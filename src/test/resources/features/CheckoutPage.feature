@checkoutpage
Feature: Validating checkout functionality

Background:
Given User click login link
Then User navigate demowebshop login page
When User enters valid  "abinaya200@gmail.com","abinaya"
And User click login button
Then User should verify the login status "abinaya200@gmail.com"
And User navigate to checkout url "https://demowebshop.tricentis.com/onepagecheckout"

@orderby_cash
Scenario: Adding checkout details
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

@orderby_check
Scenario: Adding checkout details
Given User navigate to checkout page
When User enters billing address
Then User click on billing address continue button
And User select shipping address
And User click shipping address continue button
And User select shipping method
And User click  shipping method continue button
And User click check method
And User click payment method continue button
Then User verify payment information for check order
And User click payment information continue button
Then User verify the billing and shipping address from confirm order
Then User verify product total and total price
And User click confirm order continue button
Then User should verify the order success message
And User click order success continue button

@orderby_creditcard
Scenario: Adding checkout details
Given User navigate to checkout page
When User enters billing address
Then User click on billing address continue button
And User select shipping address
And User click shipping address continue button
And User select shipping method
And User click  shipping method continue button
And User click credit card method
And User click payment method continue button
Then User enters credit card payment details
And User click payment information continue button
Then User verify the billing and shipping address from confirm order
Then User verify product total and total price
And User click confirm order continue button
Then User should verify the order success message
And User click order success continue button

@orderby_purchaseorder
Scenario: Adding checkout details
Given User navigate to checkout page
When User enters billing address
Then User click on billing address continue button
And User select shipping address
And User click shipping address continue button
And User select shipping method
And User click  shipping method continue button
And User click purchase order method
And User click payment method continue button
Then User enters purchase number payment details
And User click payment information continue button
Then User verify the billing and shipping address from confirm order
Then User verify product total and total price
And User click confirm order continue button
Then User should verify the order success message
And User click order success continue button


