@android
Feature: Android Zoom And Swipe Functionality on Product Image

  Background:
    Given user opens application
    Then verify user is on sign-in page


  Scenario: Verify user can zoom product image on the item details page
    Given user opens application
    Then verify user is on sign-in page
    When user enters mobile number as "mobile.number"
    Then verify user is successfully logged in
    And verify user is on homepage
    When user search for product "product.name"
    When user selects the first product
    Then verify item details page is displayed
    And user clicks on the product image
    And user performs zoom functionality

  Scenario: Verify user can swipe product image on the item details page

    Given user opens application
    Then verify user is on sign-in page
    When user skips sign in
    And verify user is on homepage
    When user search for product "product.name"
    When user selects the first product
    Then verify item details page is displayed
    When user swipes left on the product image
#    When user clicks on the Change Delivery Address option
#    And set new pincode "pincode"
#    Then verify the delivery address is successfully updated and saved

