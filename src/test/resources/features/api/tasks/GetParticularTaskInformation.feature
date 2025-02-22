@api
Feature: Find a Particular Task

  Scenario: Successfully retrieve a user by ID
    Given user set the endpoint to "/tasks/"
    And search the details of the user "taskId"
    And set header "Content-Type" to "application/json"
    When user send a GET request
    Then verify status code 200
    And verify response body contains the user with ID "taskId"

  Scenario: User not found by invalid ID
    Given user set the endpoint to "/tasks/"
    And search the details of the user "invalidTaskId"
    And set header "Content-Type" to "application/json"
    When user send a GET request
    Then verify status code 404
    And verify error message contains "Not found"
