@PostsFeature @Regression
Feature: Posts feature

  Background:
    Given I open Home page as "default" user with "default" password

  @deleteAllPostsForDefaultApiUser
  Scenario Outline: R003 Check number of posts on UI
    Given i create <postNumber> new posts via API for "default" user and "default" password
      | title  | Post by API |
      | body   | body post   |
      | select | One Person  |
    When I click on MyProfile button
    Then I redirect to MyProfile page
    And I see <postNumber> posts in Posts list on MyProfile page

    Examples:
      | postNumber |
      | 2          |