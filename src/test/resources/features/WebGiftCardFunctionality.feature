@web

Feature: Verify gift card functionality

  Scenario: User verifies gift card functionality
    When user opens application
    Then verify user is on homepage
    When user clicks on gift card tab
    Then verify user is on gift card page
    When user selects a particular gift card
    And user enters the details
    Then verify user is on payment page
