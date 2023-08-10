Feature: Login

  @SL_TC_001
  Scenario: Login registered user
    When A registered user who entered a valid username and password
    Then The user will navigate to the products page "https://www.saucedemo.com/inventory.html"