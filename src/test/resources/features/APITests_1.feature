Feature: Social network site API testing
  Description: Here we test the High level API health for the site

  @api_test
  Scenario: Smoke test - POSTs api health status
    Given I use "Posts" API end point
    When I make a GET request
    Then I get success response 200 code
    And response contains correct structure

  @api_test
  Scenario: Smoke test - Comments api health status
    Given I use "Comments" API end point
    When I make a GET request
    Then I get success response 200 code

  @api_test
  Scenario: Smoke test - Users List api health status
    Given I use "Users" API end point
    When I make a GET request
    Then I get success response 200 code

