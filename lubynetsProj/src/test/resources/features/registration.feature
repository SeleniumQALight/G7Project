@RegistrationFeature @Regression
Feature: Registration feature

  @R003
  Scenario Outline: R003 Registration form error message
    Given I open Login page
    When I enter '<login>' into input in Login form in Registration form
    And I enter '<email>' into input Email in Registration form
    And I enter '<password>' into input Password in Registration form
    Then I see '<error message>' in Registration form

    Examples:
      | login        | email                 | password     | error message                                                                                                    |
      | qa           | vladqaauto@gmail1.com | 123456qwerty | Username must be at least 3 characters.                                                                          |
      | validlogin11 | non_valid_gmail       | 123456qwerty | You must provide a valid email address.                                                                          |
      | validlogin11 | vladqaauto@gmail1.com | 123          | Password must be at least 12 characters.                                                                         |
      | Vlad_123     | vladqaauto@gmail2.com | qwerty1      | Username can only contain letters and numbers.;Password must be at least 12 characters.                          |
      | vladqaauto   | vlad                  | vladqaauto   | That username is already taken.;You must provide a valid email address.;Password must be at least 12 characters. |