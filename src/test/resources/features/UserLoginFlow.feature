Feature: End-to-End User Login Flow

  Scenario: User successfully logs in to the application
    Given user opens application
    Then verify user is on sign-in page
    When user enters mobile number as "mobile.number"
    Then verify user is successfully logged in
    And verify user is on homepage