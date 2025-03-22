Feature: Home Page Validation

  Scenario: Verify major sections on the Home Page
    Given I open the browser and navigate to "http://demowebshop.tricentis.com"
    And I should see the Featured Products section
    And I should see the search bar
    Then I should see the Top Offers section
    