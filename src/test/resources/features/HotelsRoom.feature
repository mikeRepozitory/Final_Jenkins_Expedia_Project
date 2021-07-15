@GetAHotelRoomSmokeTest
Feature: Stays

  1st user selects where he want to stay then he select the checkInDate and CheckOutDate for 2 travelers

  @HotelForTwo
  Scenario: Successfully rent a hotel room for two in Madison WI
    Given user clicks on "Stays" tab
    Then user selects GoingTo location "Madison WI"
    Then user selects checkInDate date "Aug 31, 2021"
    Then user selects checkOutDate date "Sep 3, 2021"





