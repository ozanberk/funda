Feature: As a customer, I wanna re-build my house

  Scenario: Re-build house in Amsterdam
    Given I visit funda homepage
    Then I should click "Nieuwbouw" tab
    When I should select house in "Amsterdam"

  Scenario: Assert searching result from result page
    And I should see "resultaten" message
    And I should see "Amsterdam" in the search box

  Scenario: Assert last search in home
    Given I visit funda homepage
    Then I should click "Nieuwbouw" tab
    And I should see previous search "Amsterdam"

  Scenario: Re-build house for
    Given I visit funda homepage
    Then I should click "Nieuwbouw" tab
    When I should search home in "Rotterdam"
    Then I select range "15" km
    And I click submit button
    
  Scenario: Assert searching result from result page
    And I should see "resultaten" message
    And I should see "Rotterdam" in the search box

  Scenario: Assert last search in home
    Given I visit funda homepage
    Then I should click "Nieuwbouw" tab
    And I should see previous search "Rotterdam"