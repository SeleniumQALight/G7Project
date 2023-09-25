@RegistrationFeature @Regression
Feature: Registration feature

  @R003
  Scenario Outline: R003 Registration form error message
    Given I open Login page
    When I enter '<login>' into input in Login formin Registration form
    And I enter '<email>' into input Email in Registration form
    And I enter '<password>' into input Password in Registration form
    Then I see '<error message>' in Registration form

    Examples:
      | login    | email           | password     | error message                                                                                                    |
      | qu       | tr@trt1.com     | 123456qwerty | Username must be at least 3 characters.                                                                          |
      | valid456 | not_valid_email | 123456qwerty | You must provide a valid email address.                                                                          |
      | valid456 | tr@trt1.com     | 12345        | Password must be at least 12 characters.                                                                         |
      | inna_123 | tr@trt1.com     | 123456qwe    | Username can only contain letters and numbers.;Password must be at least 12 characters.                          |
      | inna     | tr_trt1.com     | 123456qwe    | That username is already taken.;You must provide a valid email address.;Password must be at least 12 characters. |