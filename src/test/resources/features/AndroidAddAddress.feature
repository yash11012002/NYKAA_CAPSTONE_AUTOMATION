@android
Feature: Updating Profile Details

  Scenario: To verify the profile details are updated
    Given user opens application
    Then verify user is on sign-in page
    When user enters mobile number as "mobile.number"
    Then verify user is successfully logged in
    And verify user is on homepage
    When user navigates to the address section
    Then verify that the user is on the addresses page
    When user adds new address
    Then verify address added successfully
