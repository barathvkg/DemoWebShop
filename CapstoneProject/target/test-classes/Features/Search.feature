Feature: Home page search
@Verifysearchfunctionality
  Scenario: Verify search bar functionality
    Given I open the browser and navigate to "http://demowebshop.tricentis.com"
   	When I navigated to search bar
    And I search for the product
    And I click on the search button
    Then I see the search results


