@web @android

Feature: Verify Adding and Removing a Product from the Bag

  Scenario: Verify adding and removing a product from the bag
    Given user opens application
    Then verify user is on homepage
    When user search for product "search.product.name"
    Then verify product listing page is displayed
    When user adds the first product to bag
    And verify the product is successfully added to the bag
    When user navigates to the Bag
    And  user deletes the product from the bag
    Then verify that the product has been successfully removed from the bag