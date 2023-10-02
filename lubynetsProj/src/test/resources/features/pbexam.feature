Feature: Currency Exchange Rate Comparison

  Scenario Outline: Compare currency exchange rate from API with website
    Given I send a GET request to the PrivatBank API for currency and remember exchange rates "<currency>"
    And I open the PrivatBank website
    And I retrieve the exchange rates for "<currency>" from the website
    Then I compare the exchange rates from the API with the exchange rates from the website

    Examples:
      | currency |
      | USD      |
      | EUR      |