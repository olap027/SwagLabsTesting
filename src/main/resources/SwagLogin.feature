Feature: Login

  @SC_TC_001
  Scenario: Login registered user
#    Given I will go to SwagLab
    When Enter credentials
    Then User will navigate to products page "https://www.saucedemo.com/inventory.html"

