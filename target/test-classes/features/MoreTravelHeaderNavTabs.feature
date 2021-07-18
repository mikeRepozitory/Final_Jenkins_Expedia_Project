@HeaderNavTabs
Feature: MainTabs

  @MoreTravelHeaderTabs
  Scenario: User Successfully tests that al header  nav tabs open the right page
    Given user clicks  "Stays" header "https://www.expedia.com/Hotels" tab
    Then user selects "Flights" headers tab and checks the link "https://www.expedia.com/Flights"
    Then user then "Cars" header tab and the links should match "https://www.expedia.com/Cars"
    Then user picks "Packages"  header"https://www.expedia.com/Vacation-Packages" tab
    Then user select  "Things to do" header "https://www.expedia.com/Activities" tab
    Then user selects "Cruises" header tab "https://www.expedia.com/Cruises"
    Then user clicks "Deals" header main tab "https://www.expedia.com/deals?pwaLob=wizard-hotel-pwa"



