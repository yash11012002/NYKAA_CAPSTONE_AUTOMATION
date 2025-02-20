@web @android
Feature: Verify Adding a product to the wishlist and removing it

  Scenario: Verify adding and removing a product from the wishlist
    Given user opens application
    Then verify user is on sign-in page
    When user enters mobile number as "mobile.number"
    Then verify user is successfully logged in
    And verify user is on homepage

    When user search for product "search.product.name"
    Then user adds the first product to the wishlist
    And verify that the product is successfully added to the wishlist

    When user navigates to the wishlist
    And  user deletes the product from the wishlist
    Then verify that the product has been successfully removed from the wishlist
