Feature: Verify Filters and Product Selection

  Scenario: Verify user applies filters and views filtered products
    Given user opens application
    Then verify user is on sign-in page
    When user enters mobile number as "mobile.number"
    Then verify user is successfully logged in
    And verify user is on homepage
    When user search for product "product.name"
    Then verify product listing page is displayed
    When user click on filter tab
    Then verify filter page is displayed
    When user applies selected filters
    Then verify filters are applied correctly
#    When user selects the first product
#    Then verify item page is displayed
#    When user add item add to cart
#    And click on continue button