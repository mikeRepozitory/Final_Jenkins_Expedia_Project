@CancelTrip
Feature: CancelTrip tab

  Found a bug in this case TripCancel and TrackRefund
  @TripCancel
  Scenario: User Successfully tests that all when clicking on cancelOrChangeTrip a pop up window should display
    Given user click is on main page  and clicks on CancelTripPage link "Chat with Virtual Agent"

  @UseACreditOrCoupon
  Scenario: User Successfully tests that all when clicking on use credit or coupon tab and a new login page should display
    Given user click is on main page  and clicks Use A Credit Or Coupon tab
    Then a new window should be load "https://www.expedia.com/user/signin?uurl=qscr%3Dreds%26rurl%3D%2Fuser%2Faccount%2Fcoupons"


  @TrackRefund
  Scenario: User Successfully click on track your refund tab and a pop up window should display
    Given user click is on main page  and clicks "Track your refund"


