Feature: API Test Feature

  @M001
  Scenario Outline: Check Currency Rates
    Given I open page with currency rates on PrivatBank site
    When I check currency rates for '<courseTypeName>' on the site
    And I check currency rates for '<courseTypeName>' on API
    Then Currency rates on the site match with API with accuracy <accuracy>

  Examples:
    | courseTypeName | accuracy |
    | branch         | 0.01     |
    | card           | 0.01     |
