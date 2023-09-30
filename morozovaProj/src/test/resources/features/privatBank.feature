@PrivatBankFeature @Regression
Feature: PrivatBank feature

  @R005 @Smoke
  Scenario: R005 UI get currency with PB
    Given I open PrivatBank page
    When I save currency rates
    Then I close browser

#  @R006
#  API send a request to  to receive the exchange rate
#  Scenario: R006 API get currency with PB
#    Given I get currency with API PB
#    When I login with valid cred
#    Then I see avatar on Home Page
#
#    @R007
#  Scenario Outline: R007 Compare the currency API and UI
#    Given I open Login page
#    When I login with valid cred
#    Then I see avatar on Home Page
#
#      Examples:
#        | EUR       | USD          |
#        | qaauto    | not_valid    |
#        | not_valid | 123456qwerty |