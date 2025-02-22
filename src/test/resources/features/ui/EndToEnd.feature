Feature: Verify End To End Feature

  Scenario: Verify product purchase process
    Given user opens application
    Then verify user is on sign-in page
    When user skips sign in
    And verify user is on homepage
    When user search for product "product.name"
    When user selects the first product
    Then verify item details page is displayed
    When the user selects the size of a product
    And the user adds 1 the item to the cart
    Then the system verifies that the item was successfully added to the cart
    When the user clicks on the cart icon
    Then verify same product added in cart
    And the user sets the quantity
    Then the system verifies that the correct quantity is displayed
    When the user checks for available coupons and bank offers
    Then the system verifies that the offer page is displayed
    And the system collects valid offers for the user
    When the user clicks on view bag
    And the user clicks on the price details icon
    Then the system verifies the applied offer discount
    And the user proceeds to the payment section



