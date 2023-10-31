Feature: Check functions of the button Your Cart Page

  @SL_TC_020
  Scenario: As a user who wants to continue my shopping, I should be able to go back to products page
    When A registered user entered a valid "standard_user" and "secret_sauce"
    * Clicked Login
    * Click the cart icon
    * Click continue shopping button
    Then User should be redirected to products page and has a title "Products"

  @SL_TC_021
  Scenario: As a user who has added products to my cart, I should be able to proceed to checkout page
    When A registered user entered a valid "standard_user" and "secret_sauce"
    * Clicked Login
    * Add products to cart
    * Click the cart icon
    * Click checkout button
    Then User should be redirected to Check Out page and has a title "Checkout: Your Information"
