@GetAHotelRoomAndCarSmokeTest
Feature: Stays

  1st user selects where he wants to stay then he selects the checkInDate and CheckOutDate

  @HotelRoom
  Scenario: Successfully rent a hotel room for two in Madison WI
    Given user clicks on "Stays" tab
    Then user selects GoingTo location "Madison (MSN - Dane County Regional)"
    Then user selects checkInDate date "Aug 31, 2021"
    Then user selects checkOutDate date "Sep 3, 2021"
    And after everything is done user should be able to click on "Search" main button

  @HotelRoomAndACar
  Scenario: Successfully rent a hotel room for and a car  in Madison WI
    Given user clicks on "Stays" tab
    Then user selects GoingTo location "Madison (MSN - Dane County Regional)"
    Then user selects checkInDate date "Aug 31, 2021"
    Then user selects checkOutDate date "Sep 3, 2021"
    Then user selects "Add a car" as well
    And after everything is done user should be able to click on "Search" main button

  @HotelRoomACarThenRemovesTheCar
  Scenario: Successfully rent a hotel room for and a car and removes the car
    Given user clicks on "Stays" tab
    Then user selects GoingTo location "Madison (MSN - Dane County Regional)"
    Then user selects checkInDate date "Aug 31, 2021"
    Then user selects checkOutDate date "Sep 3, 2021"
    Then user selects "Add a car" as well
    Then user removes the car "Add a car"
    And after everything is done user should be able to click on "Search" main button




