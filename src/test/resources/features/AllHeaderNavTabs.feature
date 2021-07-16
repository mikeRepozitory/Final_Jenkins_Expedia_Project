@AllHeaderNavTabs
Feature: MainTabs

  @HeaderTabs
  Scenario: User Successfully tests that al header  nav tabs open the right page
    Given user selects  Stays header "https://www.expedia.com/Hotels" tab
    Given user selects Flights header "https://www.expedia.com/Flights" tab
    Given user selects Cars header "https://www.expedia.com/Cars" tab
    Given user selects Packages  header"https://www.expedia.com/Vacation-Packages" tab
    Given user selects  Things to do header "https://www.expedia.com/Activities" tab
    Given user selects Cruises header "https://www.expedia.com/Cruises" tab
    Given user selects deals header "https://www.expedia.com/deals" tab



