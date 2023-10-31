Feature: Check the functions of the product filter

  @SL_TC_013
  Scenario: As a user who selected the "Name (A to Z)" filter, I will be able to see the table sorted from A to Z
    When A registered user entered a valid "standard_user" and "secret_sauce"
    * Clicked Login
    Then Product name should be sorted from A to Z

  @SL_TC_014
  Scenario: As a user who selected the "Name (Z to A)" filter, I will be able to see the table sorted from Z to A
    When A registered user entered a valid "standard_user" and "secret_sauce"
    * Clicked Login
    * Sort dropdown is clicked
    * Select Name Z to A
    Then Product name should be sorted from Z to A

  @SL_TC_015
  Scenario: As a user who selected the "Price(low to high)" filter, I will be able to see the table sorted from highest to lowest price
    When A registered user entered a valid "standard_user" and "secret_sauce"
    * Clicked Login
    * Sort dropdown is clicked
    * Select Price Low to High
    Then Product should be sorted from Lowest to Highest price

  @SL_TC_016
  Scenario: As a user who selected the "Price(high to low)" filter, I will be able to see the table sorted from highest to lowest price
    When A registered user entered a valid "standard_user" and "secret_sauce"
    * Clicked Login
    * Sort dropdown is clicked
    * Select High to Low
    Then Product should be sorted from Highest to Lowest Price