Feature: API Test Feature

  @M001
  Scenario Outline: Check Currency Rates
    Given I open page with currency rates on PrivatBank site
    And I call API for currency rates with query parameters '<queryParams>'
    When I check currency rates for '<courseTypeName>' on the site
    And I check currency rates for '<courseTypeName>' on API
    Then Currency rates on the site match with API with accuracy <accuracy>

  Examples:
    | courseTypeName | accuracy | queryParams    |
    | branch         | 0.01     | json, exchange |
    | card           | 0.01     | json, exchange |
