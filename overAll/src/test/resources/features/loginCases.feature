Feature: Login feature cases


  @smoke
  @R001  @secondAfter
  Scenario Outline: R0001 Valid login
    Given I open Login page
    When I enter '<login>' and '<password>' into inputs
    And I click Login button
    Then I see Home page

    Examples:
      | login       | password            |
      | qaauto      | 123456qwerty        |
