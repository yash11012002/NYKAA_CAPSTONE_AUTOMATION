@api
Feature: Find a Particular User

  Scenario: Successfully retrieve a user by ID
    Given user set the endpoint to "/users/"
    And search the details of the user "userId"
    And set header "Content-Type" to "application/json"
    When user send a GET request
    Then verify status code 200
    And verify response body contains the user with ID "userId"

  Scenario: User not found by invalid ID
    Given user set the endpoint to "/users/"
    And search the details of the user "invalidUserId"
    And set header "Content-Type" to "application/json"
    When user send a GET request
    Then verify status code 404
    And verify error message contains "Not found"
