@api
Feature: User Management API

  Scenario: Create, Update, and Delete a user successfully

    Given user set the endpoint to "/users"
    And set header "Content-Type" to "application/json"
    And user set request body from file "ValidUser.json"
    When user send a POST request
    Then verify status code 201
    And verify response body contains "id"
    And store the "id" in a variable "userManagementUserId"

    Given user set the endpoint to "/users/"
    And search the details of the user "userManagementUserId"
    And set header "Content-Type" to "application/json"
    When user send a GET request
    Then verify status code 200
    And verify response body contains the user with ID "userManagementUserId"

    Given user set the endpoint to "/users/"
    And search the details of the user "userManagementUserId"
    When set header "Content-Type" to "application/json"
    And user set request body from file "UpdateUser.json"
    When user send a PUT request
    Then verify status code 200

    Given user set the endpoint to "/users/"
    And search the details of the user "userManagementUserId"
    And set header "Content-Type" to "application/json"
    When user send a GET request
    Then verify status code 200
    And verify response body contains the user with ID "userManagementUserId"

    Given user set the endpoint to "/users/"
    And search the details of the user "userManagementUserId"
    And set header "Content-Type" to "application/json"
    When user send a DELETE request
    Then verify status code 200

    Given user set the endpoint to "/users/"
    And search the details of the user "userManagementUserId"
    And set header "Content-Type" to "application/json"
    When user send a GET request
    Then verify status code 404
    And verify error message contains "Not found"