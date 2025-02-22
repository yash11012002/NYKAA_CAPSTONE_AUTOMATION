@api
Feature: User Creation API

  Scenario: Successfully create a user with valid details
    Given user set the endpoint to "/users"
    And set header "Content-Type" to "application/json"
    And user set request body from file "ValidUser.json"
    When user send a POST request
    Then verify status code 201
    And verify response body contains "id"