@PackagesSmokeTest
Feature: Packages

  @Car
  Scenario: Successfully rent a car in Madison WI
    Given user selects "Cars" rental tab
    Then user selects pickUp location "Washington (DCA - Ronald Reagan Washington National)"
    Then user selects dropOff location "Washington (DCA - Ronald Reagan Washington National)"
    Then user selects pickUp date "Aug 31, 2021"
    Then user selects dropOff date "Sep 3, 2021"
    Then user selects pickUp time "9:30 am"
    Then user selects dropOff time "12:00 am"




