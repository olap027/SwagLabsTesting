Feature: Check Add to Cart function

  @SL_TC_017
  Scenario: As a user who add products to my cart, I should be able to see it in Your Cart page
    When A registered user entered a valid "standard_user" and "secret_sauce"
    * Clicked Login
    * Add products to cart
    * Get the name of the product that buttons is labeled as "Remove"
    * Click the cart icon
    Then Products that have been added to my cart will be displayed on Your Cart page


