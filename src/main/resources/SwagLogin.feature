Feature: Login

  @SL_TC_001 @PositiveScenario
  Scenario Outline: Login registered user
    When A registered user entered a valid '<username>' and '<password>'
    * Clicked Login
    Then The user will navigate to the products page "https://www.saucedemo.com/inventory.html"

    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
#      | problem_user            | secret_sauce |
#      | performance_glitch_user | secret_sauce |


  @SL_TC_002 @NegativeScenario
  Scenario: Login unregistered user
    When An unregistered user entered username and password
    * Clicked Login
    Then An error message for an unregistered account will be displayed "Epic sadface: Username and password do not match any user in this service"


  @SL_TC_003 @NegativeScenario
  Scenario Outline: Login locked out user
    When A locked-out user entered '<username>' and '<password>'
    * Clicked Login
    Then An error message for locked-out users will be displayed "Epic sadface: Sorry, this user has been locked out."

    Examples:
      | username        | password     |
      | locked_out_user | secret_sauce |

  @SL_TC_004 @NegativeScenario
  Scenario Outline: Login with without username
    When The user entered a '<password>'
    * Clicked Login
    Then An error message for an unfilled username will be displayed "Epic sadface: Username is required"

    Examples:
      | password     |
      | secret_sauce |


