Feature: Check remove product function
  @SL_TC_018
  Scenario: As a user who wants to remove products in my cart, I should be able to remove them from the Your Cart page
    When A registered user entered a valid "standard_user" and "secret_sauce"
    * Clicked Login
    * Add products to cart
    * Remove Products in Products Page
    * Click the cart icon
    Then Products removed in Your Cart page should not be displayed in Your Cart Page

    @SL_TC_019
    Scenario: As a user who wants to remove products in Your Cart page, I should be able to remove them from my cart
      When A registered user entered a valid "standard_user" and "secret_sauce"
      * Clicked Login
      * Add products to cart
      * Click the cart icon
      * Remove Products in Your Cart Page
      Then Removed products should not be displayed in my Cart

