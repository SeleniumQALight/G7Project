@RegistrationFeature @Regression
Feature: Registration feature

  @R004 @Smoke
  Scenario Outline: R004 Registration with invalid data
    Given I open Login page
    When I enter '<username>' into username field in Registration form
    And I enter '<email>' into Email field in Registration form
    And I enter '<password>' into password field in Registration form
    Then I see the following error message '<errorMessage>'

    Examples:
      | username                                                  | email          | password                                            | errorMessage                                                                                                             |
      | qa                                                        | tr             | 123                                                 | Username must be at least 3 characters.;You must provide a valid email address.;Password must be at least 12 characters. |
      | qaauto                                                    | tr@tr.com      | 123456qwerty                                        | That username is already taken.;That email is already being used.                                                        |
      | qaautotesttesttetesttesttetesttesttetesttesttetesttesttet | trtr@gmail.com | testtesttetesttesttetesttesttetesttesttetesttesttet | Username cannot exceed 30 characters.;Password cannot exceed 50 characters.                                                                                   |
