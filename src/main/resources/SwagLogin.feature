Feature: Login

  Scenario: Login registered user
    Given I will go to SwagLab
    When Enter credentials
    Then User will navigate to products page

