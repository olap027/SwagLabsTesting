Feature: Access pages - not login

  @SL_TC_007 @NegativeScenario
  Scenario: As a user who did not log in, I won't be able to access Products page
    When User entered "http://www.saucedemo.com/inventory.html"
    Then An error message should be displayed - "Epic sadface: You can only access '/inventory.html' when you are logged in."

  @SL_TC_008 @NegativeScenario
  Scenario: As a user who did not log in, I won't be able to access Your Cart page
    When User entered "http://www.saucedemo.com/cart.html"
    Then An error message should be displayed - "Epic sadface: You can only access '/cart.html' when you are logged in."

  @SL_TC_009 @NegativeScenario
  Scenario: As a user who did not log in, I won't be able to access Checkout: Your Information page
    When User entered "http://www.saucedemo.com/checkout-step-one.html"
    Then An error message should be displayed - "Epic sadface: You can only access '/checkout-step-one.html' when you are logged in."

  @SL_TC_010 @NegativeScenario
  Scenario: As a user who did not log in, I won't be able to access Checkout: Overview page
    When User entered "http://www.saucedemo.com/checkout-step-two.html"
    Then An error message should be displayed - "Epic sadface: You can only access '/checkout-step-two.html' when you are logged in."

  @SL_TC_011 @NegativeScenario
  Scenario: As a user who did not log in, I won't be able to access Checkout: Complete page
    When User entered "http://www.saucedemo.com/checkout-complete.html"
    Then An error message should be displayed - "Epic sadface: You can only access '/checkout-complete.html' when you are logged in."
