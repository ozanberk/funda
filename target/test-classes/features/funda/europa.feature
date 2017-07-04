Feature: As a Customer, I should search house in order to rent or buy in Europa

  Scenario: Buy house in Europa
    Given I visit funda homepage
    Then I should click "Europa" tab
    When I should select house in country "TR"
    Then I click "koop" tab in europa page
    And I select "4" th price as first and "9" th as a last price
    Then I click submit button

  Scenario: Assert searching result from result page
    And I should see "Turkije" message in Europa page

  Scenario: Rent house in Europa
    Given I visit funda homepage
    Then I should click "Europa" tab
    When I should select house in country "DK"
    Then I click "huur" tab in europa page
    And I should set "8" th price as first and "3" th as a last price
    Then I click submit button

  Scenario: Assert searching result from result page
    And I should see "Denemarken" message in Europa page
    And I should see "Geen europese woningen" message in search result

  Scenario: Rent or buy house in Europa
    Given I visit funda homepage
    Then I should click "Europa" tab
    When I should select house in country "PL"
    Then I click "beide" tab in europa page
    And I should check first price box is not enable
    Then I click submit button

  Scenario: Assert searching result from result page
    And I should see "Polen" message in Europa page