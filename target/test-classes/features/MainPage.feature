@MainPageHeaderTab
Feature: Main page

  @HeaderTabLanguageTab
  Scenario: check the English language header tab and region to United Kingdom
    Given  use is on main page
    Then user clicks on English and a new popUp window should be displayed "true"
    Then user selects United Kingdom "United Kingdom" Region
    And use select  english "English" language
    Then clicks on "Save"  button