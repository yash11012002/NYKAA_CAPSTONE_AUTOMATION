@api
Feature: Get All Task Information

  Scenario: Successfully retrieve all users
    Given user set the endpoint to "/tasks"
    And set header "Content-Type" to "application/json"
    When user send a GET request
    Then verify status code 200
    And verify response body contains a list of users

  Scenario: Invalid endpoint for getting users
    Given user set the endpoint to "/invalid-tasks"
    And set header "Content-Type" to "application/json"
    When user send a GET request
    Then verify status code 404
    And verify error message contains "Not found"