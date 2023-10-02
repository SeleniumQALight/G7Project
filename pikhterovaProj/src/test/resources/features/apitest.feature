Feature: API Test Feature

  @M001
  Scenario Outline: Check Currency Rates
    Given I open page with currency rates on PrivatBank site
    When I check currency rates for '<courseTypeName>' on the site
    # And I check currency rates for '<courseTypeName>' on API
    # Then Currency rates on the site match with API

  Examples:
    | courseTypeName |
    | branch         |
    | card           |
