@Flights
Feature: Flight

  @OneWayFlight
  Scenario: Successfully book a flight from Florida to Washington DC
    Given user selects "Flights" tab
    Then user selects "One-way" trip
    Then user selects from "Fort Lauderdale (FLL - Fort Lauderdale-Hollywood Intl.)"
    Then user selects to "Chisinau (KIV - Chisinau Intl.)"
    Then user selects departure date "Aug 31, 2021"
    Then user selects Cabin Class & Travelers "Economy"
    Then user selects number of Travelers "1"



