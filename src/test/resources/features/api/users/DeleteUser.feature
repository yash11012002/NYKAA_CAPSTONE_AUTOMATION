@api
Feature: User Deletion API

  Scenario: Successfully delete a user with valid ID
    Given user set the endpoint to "/users/"
    And search the details of the user "deleteUserId"
    And set header "Content-Type" to "application/json"
    When user send a DELETE request
    Then verify status code 200

  Scenario: Attempt to delete a user with invalid ID
    Given user set the endpoint to "/users/"
    And search the details of the user "deleteInvalidUserId"
    And set header "Content-Type" to "application/json"
    When user send a DELETE request
    Then verify status code 404
    And verify error message contains "Not found"
