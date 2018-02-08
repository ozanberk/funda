Feature: As a Customer, I should search house in order to rent or buy in Europa

  Scenario: Buy house in Europa
    Given I visit ss homepage
    Then I change language to the russian
    When I click an electronics button
    Then I click a search button
    And I search to "Computer"
    And I want to sort according to price "Продажа"
    Then I want to specify range between "160" to "300"
    And I want to select 3 item randomly
    Then I add to basket
    And I assert the basket in case of any error