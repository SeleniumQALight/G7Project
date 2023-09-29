@LoginFeature @Regression
Feature: Login feature

  @R004
  Scenario Outline: R004 Login with invalid cred
    Given I open Login page
    When I enter '<login>' into input Login in Registration form
    And I enter '<email>' into input Email in Registration form
    And I enter '<password>' into input Password in Registration form
    Then I see '<errorMessage>' in Registration form

    Examples:
      | login                           | email           | password                                            | errorMessage                                                                |
      | q                               | aa@aa.com       | 123456qwerty                                        | Username must be at least 3 characters.                                     |
      | logvalid                        | not_valid_email | 123456qwerty                                        | You must provide a valid email address.                                     |
      | logvalid                        | aa@aa.com       | 12345                                               | Password must be at least 12 characters.                                    |
      | marisun                         | aa@aa.com       | not_valid                                           | That username is already taken.;Password must be at least 12 characters.    |
      | notvalid11111111111111111111111 | aa@aa.com       | 111111111111111111111111111111111111111111111111111 | Username cannot exceed 30 characters.;Password cannot exceed 50 characters. |
