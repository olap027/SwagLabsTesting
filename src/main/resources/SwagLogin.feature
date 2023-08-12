Feature: Login

  @SC_TC_001
  Scenario: Login registered user account
    When Enter credentials
    * Click Login
    Then User will navigate to products page "https://www.saucedemo.com/inventory.html"

  @SC_TC_002
  Scenario: Login unregistered user account
    When I enter non credentials account
    * Click Login
    Then Unable to login "Epic sadface: Username and password do not match any user in this service"

  @SC_TC_003
  Scenario: Login locked out user account
    When I enter locked credentials account
    * Click Login
    Then The account enable to login "Epic sadface: Sorry, this user has been locked out."

  @SC_TC_004
  Scenario: User did not fill in username field, I won't be able to login
    When I input only password field
    * Click Login
    Then Show error message for required username field "Epic sadface: Username is required"

  @SC_TC_005
  Scenario: User did not fill in password field, I won't be able to login
    When I input only username field
    * Click Login
    Then Show error message for required password field "Epic sadface: Password is required"

  @SC_TC_006
  Scenario: Login with unfilled required fields
    * Click Login
    Then Show error message for required field "Epic sadface: Username is required"


