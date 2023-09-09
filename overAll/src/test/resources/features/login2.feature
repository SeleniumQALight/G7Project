Feature: Login feature added


  @smoke
  Scenario Outline: : Login with valid credentials2
    Given I am on the login page
    When I enter valid credentials
    Then I should be 2time Avatar

    Examples:
      | loginTaras | passwordTaras |
      | taras      | 123456        |
