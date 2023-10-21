@PrivatExchangeFeature @Regression
Feature: Privat Exchange

  Scenario Outline: Check API exchange rates for USD and EUR and compare them to UI
    When I find out exchange rates for <currency> from API
    And I find out exchange rates for <currency> from UI
    Then I compare results for <currency> from API and UI

    Examples:
      | currency |
      | USD      |
      | EUR      |