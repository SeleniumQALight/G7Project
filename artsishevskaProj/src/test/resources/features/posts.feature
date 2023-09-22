@PostsFeature @Regression
Feature: Posts feature

  Background:
    Given I open Home page as 'default' user with 'default' password

    @deleteAllPostsForDefaultUser
    Scenario Outline: R003 Check number of posts on UI
    Given I create <numberOfPosts> new posts via API for 'default' user and 'default' password
      | title  | Post by API |
      | body   | body post   |
      | select | One Person  |
    When I click on MyProfile
    Then I redirect on MyProfile page
    And I see <numberOfPosts> posts in Posts list on MyProfile page

    Examples:
      | numberOfPosts |
      | 2             |






