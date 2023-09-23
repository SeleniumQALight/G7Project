@PostsFeature @Regression
Feature: Posts feature

  Background:
    Given  I open Home page as 'default' user with 'default' password

@deleteAllPostsForDefaultUser
  Scenario Outline: R003 Check number of posts on UI
    Given I create <number of posts> new posts via API for 'default' user and 'default' password
      | title | Post by API |
      | body  | body post   |
|select |One Person   |
    When I click on MyProfile button
    Then I redirect on MyProfile page
    And I see <number of posts> posts in Posts list on MyProfile page



    Examples:
    |number of posts|
    |2|
