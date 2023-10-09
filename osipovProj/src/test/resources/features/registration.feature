@RegistrationFeature @Regression
Feature: Registration feature

  @R003
  Scenario Outline: R002 Login with invalid cred
    Given I open Login page
    When I enter '<invalid_login>' into input Login in Registration form
    And I enter '<invalid_email>' into input Email in Registration form
    And I enter '<invalid_password>' into input Password in Registration form
    Then Check that '<error_messages>' are displayed


    Examples:
      | invalid_login                   | invalid_email | invalid_password                                    | error_messages                                                                                                           |  |  |
      | q                               | q             | q                                                   | Username must be at least 3 characters.;You must provide a valid email address.;Password must be at least 12 characters. |  |  |
      | !@#$%^&*()                      | 123@gmail.com | 123456789012345678901234567890123456789012345678901 | Username can only contain letters and numbers.;That email is already being used.;Password cannot exceed 50 characters.   |  |  |
      | qaauto                          | q             | q                                                   | That username is already taken.;You must provide a valid email address.;Password must be at least 12 characters.         |  |  |
      | 1234567890123456789012345678901 | q             | q                                                   | Username cannot exceed 30 characters.;You must provide a valid email address.;Password must be at least 12 characters.   |  |  |