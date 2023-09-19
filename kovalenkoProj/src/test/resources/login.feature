@LoginFeature
Feature: Login feature

  @R001 @smoke
  Scenario: R001 Valid Login
    Given I open the login page
    When I login with valid cred
    Then I see avatar on Home page
