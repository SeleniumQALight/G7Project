Feature: Login feature added 3


  @smoke1
  Scenario Outline: Login with valid credentials 3
    Given I am on the login page
    When I enter valid credentials
    Then I should be <Number>time Avatar

    Examples:
      | Number | passwordTaras |
      | 2      | 123456        |
    | 3      | 123456        |
