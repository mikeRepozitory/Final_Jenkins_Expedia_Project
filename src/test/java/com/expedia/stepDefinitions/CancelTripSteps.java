package com.expedia.stepDefinitions;

import com.expedia.pages.HereToHelpYouOnTheMoveTabs;
import io.cucumber.java.en.Given;
import org.testng.Assert;

import static com.expedia.base.Hook.driver;

public class CancelTripSteps {
    HereToHelpYouOnTheMoveTabs hereToHelpYouOnTheMoveTabs = new HereToHelpYouOnTheMoveTabs(driver);

    @Given("user click is on main page  and clicks on CancelTripPage link {string}")
    public void userClickIsOnMainPageAndClicksOnCancelTripPageLink(String expectedResult) throws InterruptedException {
        String actualResult = hereToHelpYouOnTheMoveTabs.getCancelOrChangeTrip_Tab(expectedResult);
        Assert.assertEquals(actualResult, expectedResult);
    }


}
