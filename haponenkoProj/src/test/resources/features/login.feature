@LoginFeature @Regression
Feature: Login feature

  @R001 @Smoke
  Scenario: R001 Valid login
    Given I open Login page
    When I login with valid credentials
    Then I see avatar on Home page

  @R002
  Scenario Outline: R002 Login with invalid credentials
    Given I open Login page
    When I enter '<login>' into Login input in Login form
    And I enter '<password>' into Password input in Login form
    And I click the SignIn button in Login form
    Then I see error message 'Invalid username / pasword'

    Examples:
      | login     | password     |
      | qaauto    | not_valid    |
      | not_valid | 123456qwerty |
