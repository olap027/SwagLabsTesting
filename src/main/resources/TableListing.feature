Feature: Check the table listing

  @SC_TC_0012
  Scenario: The user will be able to see the product listing of Swag Lab
    When Enter credentials
    * Click Login
    Then Products table is displaying