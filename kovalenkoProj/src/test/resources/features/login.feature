@LoginFeature
Feature: Login feature

  @R001 @smoke
  Scenario: R001 Valid Login
    Given I open the login page
    When I login with valid cred
    Then I see avatar on Home page


    @R002 @smoke
      Scenario Outline: R002 Login with invalid cred
      Given I open the login page
      When I enter '<login>' in to input Login in Login form
      And I enter '<password>' in to input Password in Login form
      And I click on the button SignIn in Login form
      Then I see alert message with text 'Invalid username / pasword'

      Examples:
        | login     | password     |
        | qaauto    | not_valid    |
        | not_valid | 123456qwerty |