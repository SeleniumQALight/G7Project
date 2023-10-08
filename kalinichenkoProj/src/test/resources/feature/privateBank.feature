Feature: Private Bank get currency rates

  @R005
    Scenario Outline: Get currency rates
        Given I get '<currency>' rates via Private Bank API
        When I get '<currency>'  rates from Private Bank site
        Then I compare rates from Private Bank API and rates from Private Bank site fore "<currency>" currency

    Examples:
    | currency |
    | USD      |
    | EUR      |
