@LoginFeature @Regression
Feature: Login feature

    @R001 @Smoke
    Scenario: R001 Valid login
        Given I open login page
        When I login with valid cred
        Then I see avatar on Home page