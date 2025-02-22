@web
Feature: Verify product search, filtering, and out-of-stock notification functionality

  Scenario: User applies filters and subscribes for out-of-stock notifications
    Given user opens application
    And verify user is on homepage
    When user search for product "product.name"
    Then verify product listing page is displayed
    When user click on filter tab
    Then verify filter page is displayed
    When user applies selected filters
    Then verify filters are applied correctly
    When user checks for out-of-stock products
    And user clicks on the notify button
    When user enters the email address and clicks on the proceed button
    Then verify alert message is displayed

