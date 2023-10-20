@tagLogin
Feature: Login

  @SC_TC_001
  Scenario: Login registered user account
    When Enter credentials
    * Click Login+6
    Then User will navigate to products page "https://www.saucedemo.com/inventory.html"

  @SC_TC_002
  Scenario: Login locked out user account
    When I enter locked credentials account
    * Click Login
    Then The user is unable to log in and show an error message "Epic sadface: Sorry, this user has been locked out."

  @SC_TC_003
  Scenario: Login unregistered user account
   Given I clear the username and password field
    When I enter non credentials account
    * Click Login
    Then The user is unable to log in and show an error message "Epic sadface: Username and password do not match any user in this service"


#  @SC_TC_004
#  Scenario: User did not fill in username field, I won't be able to login
##    Given I clear the username and password field
#    When I input only password field
#    * Click Login
#    Then The user is unable to log in and show an error message "Epic sadface: Username is required"

#  @SC_TC_005
#  Scenario: User did not fill in password field, I won't be able to login
#    Given I clear the username and password field
#    When I input only username field
#    * Click Login
#    Then The user is unable to log in and show an error message "Epic sadface: Password is required"

  @SC_TC_006
  Scenario: Login with unfilled required fields
    Given I clear the username and password field
    * Click Login
    Then The user is unable to log in and show an error message "Epic sadface: Username is required"
