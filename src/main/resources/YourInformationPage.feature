Feature: Check functions in Checkout: Your Information page

  @SL_TC_023
  Scenario: As a user who did not fill in the first name field, I should not be able to proceed to Checkout: Overview page
    When A registered user entered a valid "standard_user" and "secret_sauce"
    * Clicked Login
    * Add products to cart
    * Click the cart icon
    * Click checkout button
    * Enter last name "Fabro"
    * Enter zipcode "1606"
    * Click continue
    Then There should be an error message "Error: First Name is required"

  @SL_TC_024
  Scenario: As a user who did not fill in the last name field, I should not be able to proceed to Checkout: Overview page
    When A registered user entered a valid "standard_user" and "secret_sauce"
    * Clicked Login
    * Add products to cart
    * Click the cart icon
    * Click checkout button
    * Enter first name "Angelica"
    * Enter zipcode "1606"
    * Click continue
    Then There should be an error message "Error: Last Name is required"

  @SL_TC_025
  Scenario: As a user who did not fill in the zip code field, I should not be able to proceed to Checkout: Overview page
    When A registered user entered a valid "standard_user" and "secret_sauce"
    * Clicked Login
    * Add products to cart
    * Click the cart icon
    * Click checkout button
    * Enter first name "Angelica"
    * Enter last name "Fabro"
    * Click continue
    Then There should be an error message "Error: Postal Code is required"
