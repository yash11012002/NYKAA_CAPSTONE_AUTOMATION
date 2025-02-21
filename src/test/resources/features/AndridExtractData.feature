Feature: Verify

  Scenario: Verify
    Given user opens application
    Then verify user is on sign-in page
    When user skips sign in
    And verify user is on homepage
    When user clicks on categories tab
    And user clicks on bestseller tab
    And extract all store information in text file
