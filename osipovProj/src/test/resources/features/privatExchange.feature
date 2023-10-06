@PrivatExchangeFeature @Regression
  Feature: Privat Exchange

    Scenario: Check API exchange rates for USD and EUR and compare them to UI
      When I find out exchange rates from API
      And I find out exchange rates from UI
      Then I compare results from API and UI
