Feature: As a customer, I want to recreate a house in Netherlands

  Scenario: Search location for building in exact location
    Given I visit funda homepage
    Then I should click "Recreatie" tab
    When I should search home in "Utrecht"
    And I click submit button

  Scenario: Assert searching result from result page
    And I should see "resultaten" message

  Scenario: Assert last search in recreation
    Given I visit funda homepage
    When I should click "Recreatie" tab
    Then I should see previous search "Utrecht"

  Scenario: Search location for recreating in Nederland
    Given I visit funda homepage
    Then I should click "Recreatie" tab
    When I select range max "10" km
    And I click submit button

  Scenario: Assert searching result from result page
    And I should see "Nederland" in the search box
    And I should see "resultaten" message

  Scenario: Assert last search in recreation
    Given I visit funda homepage
    When I should click "Recreatie" tab
    Then I should see previous search "Nederland"

  Scenario: Search location for building in Nederland
    Given I visit funda homepage
    Then I should click "Recreatie" tab
    And I should search my last search

  Scenario: Assert searching result from result page
    And I should see "Nederland" in the search box
    And I should see "resultaten" message