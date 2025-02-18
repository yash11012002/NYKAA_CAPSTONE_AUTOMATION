@web @android
Feature: Verify Product Search Functionality

  Scenario Outline: Verify user can search for products successfully
    Given user opens application
    Then verify user is on homepage
    When user search for products "<product.name>"
    Then verify product listing page is displayed
    When user click on filter tab
    Then verify filter page is displayed
#    When user applies multiple filters
#    Then verify filters are applied correctly

    Examples:
      | product.name |
      | Serums       |
      | Face Wash    |
      | Shampoo      |
      | Sunscreen    |
