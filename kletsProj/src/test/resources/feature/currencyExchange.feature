@CurrencyExchangeFeature @Regression
Feature: Currency Exchange

  Scenario Outline: R005 Compare Exchange Rates for <currency> from API and UI

    Given I remember the exchange rate for buy and sell for "<currency>" from the API response
    When I open the PrivateBank website
    And I retrieve the exchange rate for buy and sell for "<currency>" from the website
    Then I compare the exchange rate from the API with the website for "<currency>"

    Examples:
      | currency |
      | EUR      |
      | USD      |