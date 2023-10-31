Feature: Check product table

  @SL_TC_11 @PositiveScenario
  Scenario: As a registered user, I will be able to see the product listing of Swag Lab
    When A registered user entered a valid "standard_user" and "secret_sauce"
    * Clicked Login
    Then A product table should be displayed
