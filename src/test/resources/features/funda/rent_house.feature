Feature: As a customer,

  Scenario: Rent house in Zwolle
    Given I visit funda homepage
    Then I click "Huur" tab
    When I should select house in "Zwolle"

  Scenario: Assert searching result from result page
    And I should see "resultaten" message
    And I should see "Zwolle" in the search box

  Scenario: Assert last search in home
    Given I visit funda homepage
    Then I click "Huur" tab
    And I should see previous search "Zwolle"

  Scenario: Rent house in Landhorst
    Given I visit funda homepage
    Then I click "Huur" tab
    When I should search home in "Landhorst"
    Then I select range "0" km
    And I select first price for rent "1000"
    And I select last price for rent "5000"
    Then I should click submit

  Scenario: Assert searching result from result page
    And I should see "resultaten" message
    And I should see "Landhorst" in the search box
    Then I should see "€ 1.000 - € 5.000" filter
    And I should see selected range as "0" km

  Scenario: Assert last search in home
    Given I visit funda homepage
    Then I click "Huur" tab
    Then I should see previous search "Landhorst"

  Scenario: Rent house in Groningen for 5 km range
    Given I visit funda homepage
    Then I click "Huur" tab
    When I should search home in "Groningen"
    Then I select range max "5" km
    And I select first price for rent "300"
    And I select last price for rent "4000"
    Then I should click submit

  Scenario: Assert searching result from result page
    And I should see "resultaten" message
    And I should see "Groningen" in the search box
    Then I should see "€ 300 - € 4.000" filter
    And I should see selected range as "5" km

  Scenario: Assert last search in home
    Given I visit funda homepage
    Then I click "Huur" tab
    Then I should see previous search "Groningen"