Feature: Log in form
  Background:
    Given I access the login form

  Scenario: A user Logs in
    When I attempt to login
      |Username|Password            |
      |tomsmith|SuperSecretPassword!|
    Then I should see the Secure Area screen


  Scenario: A user Logs out
    Given I attempt to login
      |Username|Password            |
      |tomsmith|SuperSecretPassword!|
    When I attempt to logout
    Then I should be redirected to the loginPage

