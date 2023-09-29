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
  Scenario: As a user who wants to remove products in my home, I should be able to remove them from the Your Cart page
    Given Select multiple random item on product page
    When I remove an items in the home
    Then Will show a remove item in home

  @SC_TC_0019
  Scenario: As a user who wants to remove products in Your Cart page, I should be able to remove them from my cart
    Given Select multiple random item on product page
    When I remove an items in the home
    Then The removed products should not be displayed in Your Cart page

  @SC_TC_0020
  Scenario: As a user who wants to continue my shopping, I should be able to go back to products page
    Given Select multiple random item on product page
    When I click the add to cart button
    And I click the continue shopping button
    Then User should be redirected to Products page "https://www.saucedemo.com/inventory.html"

  @SC_TC_0021
  Scenario: As a user who has added products to my cart, I should be able to proceed to checkout page
    Given Select multiple random item on product page
    When I click the add to cart button
    And I click the checkout button
    Then User will be redirected to Checkout: Your Information page

  @SC_TC_0022
  Scenario: As a user who hasn't added products to my cart, I shouldn't be able to proceed to the checkout page
    When I click the add to cart button
    Then User will not be able to proceed to checkout and a prompt message will be displayed