Feature: Accessing site for not loging it

  @SC_TC_007
  Scenario: The user accessing the Home page without logging it
    When I access the Home page without login "http://www.saucedemo.com/inventory.html"
    Then Show error message for accessing home site without login "Epic sadface: You can only access '/inventory.html' when you are logged in."

  @SC_TC_008
  Scenario: The user accessing the Add to cart page without logging it
    When I will access the
    Then Show error message for accessing

  @SC_TC_009
  Scenario: The user accessing the check out page step 1 without logging it
    When I will access the
    Then Show error message for accessing

  @SC_TC_010
  Scenario: The user accessing the check out page step 2  without logging it
    When I will access the check out page step 2 "http://www.saucedemo.com/checkout-step-two.html"
    Then Show error message for accessing add to cart page without login "Epic sadface: You can only access '/checkout-step-two.html' when you are logged in."

  @SC_TC_011
  Scenario: The user accessing the Complete page without logging it
    When I will access the
    Then Show error message for accessing