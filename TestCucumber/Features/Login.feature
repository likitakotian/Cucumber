

Feature: Login to the page
  

  
  
  Scenario: Successful Login with the valid credential
    Given User launch chrome browser
		When user opens URL “https://admin-demo.nopcommerce.com/login”
		And User enters emails as “admin@yourstore.com” and Password as “admin”
		And click on login
    Then Page Tile should be “Dashboard / nopCommerce administration”
 		When user click on log out link
		Then Page Title should be “Your store . Login”
		And close browser


    

      
