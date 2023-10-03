@RegistrationFeature @Regression
Feature: Validate failed the registration

  Scenario Outline: Validate failed the registration
    Given I open login page
    When I fill the registration form with <username> userName, <email> email, <password> password
    Then I should see the error message <errorMessage>

    Examples:
      | username | email   | password     | errorMessage                                                                                                             |
      | te       | example | 123456       | Username must be at least 3 characters.;You must provide a valid email address.;Password must be at least 12 characters. |
      | test#    | example | 123456qwerty | Username can only contain letters and numbers.;You must provide a valid email address.                                   |
      | test123  | example | 123456qwerty | You must provide a valid email address.                                                                                  |