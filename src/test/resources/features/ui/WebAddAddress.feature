@web

Feature: Updating Profile Details

  Scenario: To verify the profile details are updated
    Given user opens application
    Then verify user is on sign-in page
    When user enters mobile number as "mobile.number"
    Then verify user is successfully logged in
    And verify user is on homepage
    When user navigates to the profile section
    Then verify that the user is on the profile page
    When user changes the personal details
    And user clicks on save details
    Then verify that the personal details are updated
