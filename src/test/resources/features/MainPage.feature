@MainPageHeaderTab
Feature: Main page

  @HeaderTabLanguageTab
  Scenario: check the English language header tab and region to United Kingdom
    Given  use is on main page
    Then user clicks on English and a new popUp window should be displayed "true"
    Then user selects United Kingdom "United Kingdom" Region
    And use select  english "English" language
    Then clicks on "Save"  button


  @SignIn
  Scenario: User checks that the sign in button works
    Given  use is on main page and clicks on "Sign in"
    Then user clicks on "Sign in"
    And a new window with the current url "https://www.expedia.com/user/signin?ckoflag=0&uurl=e3id%3Dredr%26rurl%3D%2F" should be displayed for user to sign in

  @signUpItsFreePopUpWindow
  Scenario: User checks that the sign up button works
    Given  use is on main page and clicks on Sign in "Sign in"
    Then user clicks on Sign up, it’s free "Sign up, it’s free"
    And a new window "https://www.expedia.com/user/createaccount?%20&uurl=e3id%3Dredr%26rurl%3D%2F" should be displayed for user to sign up



