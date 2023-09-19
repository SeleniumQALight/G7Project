@LoginFeature @Regression
Feature: Login feature

  @R001 @Smoke
  Scenario: R001 Valid login
    Given I open the login page
    When I login with valid credentials
    Then I see avatar on Home page