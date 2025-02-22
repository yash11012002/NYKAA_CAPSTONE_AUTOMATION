@api
Feature: Task Update API

  Scenario: Successfully update a user's name
    Given user set the endpoint to "/tasks/"
    And search the details of the user "updateTaskId"
    When set header "Content-Type" to "application/json"
    And user set request body from file "UpdateTask.json"
    When user send a PUT request
    Then verify status code 200
    And verify response body contains "task" with value "Updated task"
    And verify response body contains "name" with value "Updated name"


  Scenario: Attempt to update user with invalid user ID
    Given user set the endpoint to "/tasks/"
    And search the details of the user "updateInvalidTaskId"
    When set header "Content-Type" to "application/json"
    And user set request body from file "UpdateTask.json"
    When user send a PUT request
    Then verify status code 404
    And verify error message contains "Not found"
