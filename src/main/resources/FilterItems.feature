Feature: Checking the Item Filters

  @SC_TC_0013
  Scenario: As a user who selected the "Name (A to Z)" filter, I will be able to see the table sorted from A to Z
    Given The user is logged in
    * Click Login
    Then Table is sorted from "A to Z"

  @SC_TC_0014
  Scenario: As a user who selected the "Name (Z to A)" filter, I will be able to see the table sorted from A to Z
    Given The user is logged in
    * Click Login
    When Choose the dropdown sorted from Z to A
    Then Table is sorted from "Z to A"

  @SC_TC_0015
  Scenario: As a user who selected the "Price(low to high)" filter, I will be able to see the table sorted from lowest to highest price
    Given The user is logged in
    * Click Login
    When Choose the dropdown sorted from low to high
    Then Table Price is sorted from Low to High

  @SC_TC_0016
  Scenario: As a user who selected the "Price(high to low)" filter, I will be able to see the table sorted from lowest to highest price
    Given The user is logged in
    * Click Login
    When Choose the dropdown sorted from high to low
    Then Table Price is sorted from High to Low











