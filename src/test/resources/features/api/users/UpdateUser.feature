@api
Feature: User Update API

  Scenario: Successfully update a user's name
    Given user set the endpoint to "/users/"
    And search the details of the user "updateUserId"
    When set header "Content-Type" to "application/json"
    And user set request body from file "UpdateUser.json"
    When user send a PUT request
    Then verify status code 200
    And verify response body contains "id" with value "updateUserId"
    And verify response body contains "name" with value "name"


  Scenario: Attempt to update user with invalid user ID
    Given user set the endpoint to "/users/"
    And search the details of the user "updateInvalidUserId"
    When set header "Content-Type" to "application/json"
    And user set request body from file "UpdateUser.json"
    When user send a PUT request
    Then verify status code 404
    And verify error message contains "Not found"
