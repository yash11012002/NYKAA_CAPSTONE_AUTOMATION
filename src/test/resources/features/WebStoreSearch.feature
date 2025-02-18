@web

Feature: Verify store locator feature and store results in text file

 Scenario Outline: Search multiple locations and store results in text file

    When user opens application
    Then verify user is on homepage
    When user clicks on store locator tab
    Then verify user is on store locator page
    When user searches city "<store.city.name>" and press search button
    Then verify search lists with city name and store in file

   Examples:
   |store.city.name|
   |Bengaluru      |
   |Pune           |
   |Trivandrum     |
   |Ahmedabad      |
   |Delhi          |
