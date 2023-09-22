@RegistrationFeature @Regression
Feature: Registration feature

  @R004 @Smoke
  Scenario Outline: R004 Registration with invalid credentials
    Given I open Login page
    When I enter '<username>' into username input in Registration form
    And I enter '<email>' into Email input in Registration form
    And I enter '<password>' into Password input in Registration form
    Then I see the following error messages: '<errorMessages>'

    Examples:
      | username | email          | password                                            | errorMessages                                                                                                          |
      | Ірина    | iryna@qa.auto  | qwerty123456111111111111111111111111111111111111111 | Username can only contain letters and numbers.;That email is already being used.;Password cannot exceed 50 characters. |
      | Ir       | iryna          | 123456qwerty                                        | Username must be at least 3 characters.;You must provide a valid email address.                                        |
      | irynag7  | iryna@mail.com | 123                                                 | That username is already taken.;Password must be at least 12 characters.                                                        |