@LoginFeature @Regression
Feature: Login feature

  @R001 @Smoke
  Scenario: R001 Valid login
    Given I open Login page
    When I login with valid cred
    Then I see avatar on Home page

  @R002
  Scenario Outline: R002 Login with invalid cred
    Given I open Login page
    When I enter '<login>' into input Login in Login form
    And I enter '<password>' into input Password in Login form
    And I click on button SignIn in Login form
    Then I see alert message with text 'Invalid username / pasword'

    Examples:
      | login     | password     |
      | qaauto    | not_valid    |
      | not_valid | 123456qwerty |

