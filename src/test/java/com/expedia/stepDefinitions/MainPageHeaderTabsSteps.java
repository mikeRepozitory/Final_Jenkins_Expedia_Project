package com.expedia.stepDefinitions;

import com.expedia.pages.MainPageHeaderTabsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;
import org.testng.Assert;

import static com.expedia.base.Hook.driver;

public class MainPageHeaderTabsSteps {
    MainPageHeaderTabsPage mainPageHeaderTabsPage = new MainPageHeaderTabsPage(driver);
    private static final Logger logger = Logger.getLogger(MainPageHeaderTabsSteps.class);


    @Given("use is on main page")
    public void useIsOnMainPage() {
        mainPageHeaderTabsPage.getEnglishNavigation_Tab();
    }

    @Then("user clicks on English and a new popUp window should be displayed {string}")
    public void userClicksOnEnglishAndANewPopUpWindowShouldBeDisplayed(String expected) {
        boolean isDisplayed = mainPageHeaderTabsPage.isEnglishPopUpWindowDisplayed();
        System.out.println("isDisplayed: " + isDisplayed);
        Assert.assertTrue(isDisplayed);
    }

    @Then("user selects United Kingdom {string} Region")
    public void userSelectsUnitedKingdomRegion(String region) {
        String actual = mainPageHeaderTabsPage.getLanguageDropDownPopUpRegion(region);
        Assert.assertEquals(region, actual);
    }


    @And("use select  english {string} language")
    public void useSelectEnglishLanguage(String language) {
        String actual = mainPageHeaderTabsPage.getLanguageDropDownPopUp(language);
        Assert.assertEquals(language, actual);
    }


    @Then("clicks on {string}  button")
    public void clicksOnButton(String expected) {
        String result = mainPageHeaderTabsPage.getLanguageDropDownPopUpSave_button(expected);
        Assert.assertEquals(result, expected);
    }


    @Given("use is on main page and clicks on {string}")
    public void useIsOnMainPageAndClicksOn(String expected) throws InterruptedException {
        String result = mainPageHeaderTabsPage.getHeaderMainSignIn_button(expected);
        Assert.assertEquals(result, expected);
    }

    @Given("use is on main page and clicks on Sign in {string}")
    public void useIsOnMainPageAndClicksOnSignIn(String expected) throws InterruptedException {
        String result = mainPageHeaderTabsPage.getHeaderMainSignIn_button(expected);
        Assert.assertEquals(result, expected);
    }

    @Given("use is on main page and clicks on List your property {string}")
    public void useIsOnMainPageAndClicksOnListYourProperty(String expected) {
        String result = mainPageHeaderTabsPage.getListYourPropertyHeaderNavigation_Tab(expected);
        Assert.assertEquals(result, expected);
    }

    @And("a new window {string} should be open another new tab with Expedia GROUP")
    public void aNewWindowShouldBeOpenAnotherNewTabWithExpediaGROUP(String expectedPageTitle) throws InterruptedException {
        String result = mainPageHeaderTabsPage.getCurrentPageTitle(expectedPageTitle);
        Assert.assertEquals(result, expectedPageTitle);
    }

    @Then("user clicks on {string}")
    public void userClicksOn(String expected) {
        String result = mainPageHeaderTabsPage.getPopUpWindowSignIn_button(expected);
        Assert.assertEquals(result, expected);
    }

    @And("a new window with the current url {string} should be displayed for user to sign in")
    public void aNewWindowWithTheCurrentUrlShouldBeDisplayedForUserToSignIn(String expected) {
        String result = mainPageHeaderTabsPage.getCurrentUrl(expected);
        Assert.assertEquals(result, expected);
    }

    @Then("user clicks on Sign up, it’s free {string}")
    public void userClicksOnSignUpItSFree(String expected) {
        String result = mainPageHeaderTabsPage.getPopUpWindowsSgnUpItsFreePopUpWindow_button(expected);
        Assert.assertEquals(result, expected);
    }


    @And("a new window {string} should be displayed for user to sign up")
    public void aNewWindowShouldBeDisplayedForUserToSignUp(String expected) {
        String result = mainPageHeaderTabsPage.getCurrentUrl(expected);
        Assert.assertEquals(result, expected);
    }


    @Then("user clicks on  List of favorites {string}")
    public void userClicksOnListOfFavorites(String expected) {
        String result = mainPageHeaderTabsPage.getListOfFavoritesPopUpWindow_button(expected);
        Assert.assertEquals(result, expected);

    }

    @And("a new window {string} should be displayed with the list of favorites")
    public void aNewWindowShouldBeDisplayedWithTheListOfFavorites(String expected) {
        String result = mainPageHeaderTabsPage.getCurrentUrl(expected);
        Assert.assertEquals(result, expected);
    }

    @Then("user clicks on Expedia Rewards {string}")
    public void userClicksOnExpediaRewards(String expected) {
        String result = mainPageHeaderTabsPage.getExpediaRewardsPopUpWindow_button(expected);
        Assert.assertEquals(result, expected);
    }

    @And("a new window {string} should be displayed with the Expedia Rewards")
    public void aNewWindowShouldBeDisplayedWithTheExpediaRewards(String expected) {
        String result = mainPageHeaderTabsPage.getCurrentUrl(expected);
        Assert.assertEquals(result, expected);
    }

    @Then("user clicks on Feedback {string}")
    public void userClicksOnFeedback(String expected) {
        String result = mainPageHeaderTabsPage.getFeedbackPopUpWindow_button(expected);
        Assert.assertEquals(result, expected);
    }

    @And("a new window {string} should be open another new tab with Feedback")
    public void aNewWindowShouldBeOpenAnotherNewTabWithFeedback(String expected) {
        String result = mainPageHeaderTabsPage.getCurrentUrl(expected);
        Assert.assertEquals(result, expected);
    }


}
