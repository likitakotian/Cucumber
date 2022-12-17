

Feature: Customer
  
  
Background: below are the common feature
Given User launch chrome browser
When user opens URL “https://admin-demo.nopcommerce.com/login”
And User enters emails as “admin@yourstore.com” and Password as “admin”
And click on login
Then User can view Dashboard

@SmokeTest
Scenario: Add new customer
When User click on customer Menu
And click on add new button
Then User can view Add new customer page
When User enter customer info
And click on save button
Then user can view confirmation message “ the new customer has been added successfully. ”
And close browser
 @RegressionTest  
Scenario: search customer by emailID
When User click on customer Menu
And enter customer email
When click on search button
Then User should found email in the search table
And close browser
@RegressionTest
Scenario: serach customer by finame and last name 
When User click on customer Menu
And enter the firstname and lastname
When click on search button
Then User should names in the search table
And close browser