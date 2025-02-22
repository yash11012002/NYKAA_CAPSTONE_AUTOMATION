@web @android

Feature: Verify User Login, Product Search, and Cart Persistency

  Background:
    Given user opens application
    Then verify user is on sign-in page
    When user enters mobile number as "mobile.number"
    Then verify user is successfully logged in
    And verify user is on homepage

  Scenario: Verify User Login and Shopping Flow with Cart Persistency
    When user search for product "cartPersistency.product.name"
    Then verify product listing page is displayed
    When user selects the first product
    Then verify item details page is displayed
    And the user adds 1 the item to the cart
    When the user clicks on the cart icon
    Then verify cart page is displayed
    And verify same product added in cart
    When user navigates back
    And user logout
    Then verify user successfully logged out
    When user enters mobile number as "mobile.number"
    Then verify user is successfully logged in
    And verify user is on homepage
    Then verify cart persistency
