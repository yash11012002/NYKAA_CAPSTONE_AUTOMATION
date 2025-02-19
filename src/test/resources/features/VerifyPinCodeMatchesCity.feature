@web @android

Feature: To check the pincode entered for delivery is matching the city name

  Scenario Outline: To check the pincode entered for delivery is matching the city name
    Given user opens application
    Then verify user is on homepage
    When user search for product "search.product.name"
    Then verify product listing page is displayed
    When user selects the first product
    Then verify item details page is displayed
    When navigates to deliver using pinCode and enters the "<pinCode>"
    Then verify that the location displayed corresponds to the "<city>"

    Examples:
      | pinCode | city         |
      | 110001  | New Delhi    |
      | 600001  | Chennai      |
      | 400001  | Mumbai       |
      | 500001  | Hyderabad    |
      | 110020  | Delhi        |


