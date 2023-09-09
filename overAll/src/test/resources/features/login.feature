Feature: Login feature added


  @smoke
  Scenario Outline: Login with valid credentials1
    Given I am on the login page
    When I enter valid credentials
    Then I should be 2time Avatar

    Examples:
      | loginTaras | passwordTaras |
      | taras      | 123456        |

  @smoke
  Scenario: Login with valid credentials3
    Given I am on the login page
    When I enter valid credentials
    Then I should see error message