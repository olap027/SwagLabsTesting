Feature: Checking the Add To Cart

  Background: User Login
    Given The user is logged in
    * Click Login

  @SC_TC_0017
  Scenario: As a user who add products to my cart, I should be able to see it in Your Cart page
    Given Select only 1 random item on product page
    And Verify the button form add to cart change into remove
    When I click the add to cart button
    Then Go to Add to Cart Page to verify same item selected on the product page

  @SC_TC_0017
  Scenario: As a user who add more products to my cart, I should be able to see it in Your Cart page
    Given Select multiple random item on product page
    And Verify the button form add to cart change into remove
    When I click the add to cart button
    Then Go to Add to Cart Page to verify same item selected on the product page

  @SC_TC_0018
  Scenario: As a user who wants to remove products in my cart, I should be able to remove them from the Your Cart page
    Given Select multiple random item on product page
    When I remove an items in the cart
    Then Show the updated cart list
