package com.expedia.stepDefinitions;

import com.expedia.pages.HereToHelpYouOnTheMoveTabs;
import com.expedia.pages.MoreTravelHeaderNavTabsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.expedia.base.Hook.driver;

public class MoreTravelHeaderNavTabsSteps {

    MoreTravelHeaderNavTabsPage moreTravelHeaderNavTabsPage = new MoreTravelHeaderNavTabsPage(driver);
    HereToHelpYouOnTheMoveTabs hereToHelpYouOnTheMoveTabs = new HereToHelpYouOnTheMoveTabs(driver);

    @Given("user clicks  {string} header {string} tab")
    public void userClicksHeaderTab(String Stays, String actualURL) throws InterruptedException {
        String resultSays = moreTravelHeaderNavTabsPage.getNavigation_Tab(Stays, actualURL);
        Assert.assertEquals(resultSays, actualURL);
    }

    @Then("user selects {string} headers tab and checks the link {string}")
    public void userSelectsHeadersTabAndChecksTheLink(String Flights, String actualURL) throws InterruptedException {
        String result = moreTravelHeaderNavTabsPage.getNavigation_Tab(Flights, actualURL);
        Assert.assertEquals(result, actualURL);
    }

    @Then("user then {string} header tab and the links should match {string}")
    public void userThenHeaderTabAndTheLinksShouldMatch(String Cars, String actualURL) throws InterruptedException {
        String result = moreTravelHeaderNavTabsPage.getNavigation_Tab(Cars, actualURL);
        Assert.assertEquals(result, actualURL);
    }

    @Then("user picks {string}  header{string} tab")
    public void userPicksHeaderTab(String Packages, String actualURL) throws InterruptedException {
        String result = moreTravelHeaderNavTabsPage.getNavigation_Tab(Packages, actualURL);
        Assert.assertEquals(result, actualURL);
    }

    @Then("user select  {string} header {string} tab")
    public void userSelectHeaderTab(String ThingsToDo, String actualURL) throws InterruptedException {
        String result = moreTravelHeaderNavTabsPage.getNavigation_Tab(ThingsToDo, actualURL);
        Assert.assertEquals(result, actualURL);
    }

    @Then("user selects {string} header tab {string}")
    public void userSelectsHeaderTab(String Cruises, String actualURL) throws InterruptedException {
        String result = moreTravelHeaderNavTabsPage.getNavigation_Tab(Cruises, actualURL);
        Assert.assertEquals(result, actualURL);
    }

    @Then("user clicks {string} header main tab {string}")
    public void userClicksHeaderMainTab(String Deals, String actualURL) throws InterruptedException {
        String result = moreTravelHeaderNavTabsPage.getNavigation_Tab(Deals, actualURL);
        Assert.assertEquals(result, actualURL);
    }

    @Given("user click is on main page  and clicks Use A Credit Or Coupon tab")
    public void userClickIsOnMainPageAndClicksUseACreditOrCouponTab() throws InterruptedException {
        hereToHelpYouOnTheMoveTabs.getUseACreditOrCoupon_Tab();
    }

    @Then("a new window should be load {string}")
    public void aNewWindowShouldBeLoad(String actualURL) throws InterruptedException {
        String result = hereToHelpYouOnTheMoveTabs.getCurrentURL(actualURL);
        Assert.assertEquals(result, actualURL);
    }

    @Given("user click is on main page  and clicks {string}")
    public void userClickIsOnMainPageAndClicks(String expectedResult) throws InterruptedException {
        String result = hereToHelpYouOnTheMoveTabs.getTrackYourRefund_Tab(expectedResult);
        Assert.assertEquals(result, expectedResult);
    }


}
