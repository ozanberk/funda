  Feature: As a customer, I am looking a house in order to buy

    Scenario: Delete Cookie
      Given I delete all the cookies

    Scenario: Buy house for 0 km
      Given I visit funda homepage
      When I should search home in "Utrecht"
      Then I select range max "0" km
      And I select first price as "125000"
      And I select last price as "250000"
      Then I should click submit

    Scenario: Assert searching result from result page
      And I should see "resultaten" message
      And I should see "Utrecht" in the search box
      Then I should see "€ 125.000 - € 250.000" filter
      And I should see selected range as "0" km

    Scenario: Assert last search in home
      Given I visit funda homepage
      Then I should see previous search "Utrecht"

    Scenario: Buy house range 5 km
      Given I visit funda homepage
      When I should search home in "Prinsejagt"
      Then I select range max "5" km
      And I select first price as "0"
      Then I should click submit

    Scenario: Assert searching result from result page
      And I should see "resultaten" message
      And I should see "Prinsejagt" in the search box
      And I should see selected range as "5" km

    Scenario: Assert last search in home
      Given I visit funda homepage
      Then I should see previous search "Prinsejagt"

    Scenario: Buy house more than 15 km
      Given I visit funda homepage
      When I should search home in "Xenonstraat"
      Then I select range max "15" km
      And I select first price as "1000000"
      And I select last price as "2000000"
      Then I should click submit

    Scenario: Assert searching result from result page
      And I should see "resultaten" message
      And I should see "Xenonstraat" in the search box
      Then I should see "€ 1.000.000 - € 2.000.000" filter
      And I should see selected range as "15" km

    Scenario: Assert last search in home
      Given I visit funda homepage
      Then I should see previous search "Xenonstraat"

    Scenario: Buy house for 0 km
      Given I visit funda homepage
      When I should search home in "Utrecht"
      Then I select range max "2" km
      And I select first price as "900000"
      And I select last price as "375000"
      Then I should click submit

    Scenario: Assert searching result from result page
      And I should see "resultaten" message
      And I should see "Utrecht" in the search box
      And I should see selected range as "2" km

    Scenario: Assert last search in home
      Given I visit funda homepage
      Then I should see previous search "Utrecht"

    Scenario: Buy house for 0 km
      Given I visit funda homepage
      When I should search home in "Reusel"
      Then I select range max "10" km
      And I select first price as "550000"
      Then I should click submit

    Scenario: Assert searching result from result page
      And I should see "resultaten" message
      And I should see "Reusel" in the search box
      Then I should see "€ 550.000" filter
      And I should see selected range as "10" km

    Scenario: Assert last search in home
      Given I visit funda homepage
      Then I should see previous search "Reusel"