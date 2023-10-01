Feature: Currency Exchange Rate Comparison

  Scenario Outline: Compare currency exchange rate from API with website
    Given I send a GET request to the PrivatBank API for currency exchange rates "<currency>"
    When I remember the exchange rate for "<currency>" from the Example table for "<transaction>"
    And I open the PrivatBank website
    Then I retrieve the exchange rate for "<currency>" from the website for "<transaction>"
    And I compare the "<transaction>" exchange rate from the API with the "<transaction>" exchange rate from the website
    And I compare sell "<currency>" exchange rate from the API with the sell exchange rate from the website


    Examples:
      | currency | transaction |
      | USD      | buy         |
      | EUR      | buy         |