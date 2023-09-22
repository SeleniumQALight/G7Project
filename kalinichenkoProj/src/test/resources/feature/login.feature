@LoginFeature @Regression
Feature: Login feature

  @R001 @Smoke
  Scenario: R001 Valid login
    Given I open login page
    When I login with valid cred
    Then I see avatar on Home page

  @R002
  Scenario Outline: R002 Invalid login
    Given I open login page
    When I enter "<login>" into login field in login form
    And I enter "<password>" into password field in login form
    And I click on SignIn button in login form
    Then I see alert message with text 'Invalid username / pasword'




    Examples:
      | login     | password     |
      | qaauto    | not_valid    |
      | not_valid | 123456qwerty |