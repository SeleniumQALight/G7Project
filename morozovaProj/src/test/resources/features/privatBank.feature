@PrivatBankFeature @Regression
Feature: PrivatBank feature

  @R005 @Smoke
  Scenario Outline: R005 UI and API get currencyPB and compare rates
    Given I save currency <currency> rates with UI
    When I get currency <currency> with API PB
    Then I compare <currency> UI and API

    Examples:
      | currency |
      | EUR      |
      | USD      |