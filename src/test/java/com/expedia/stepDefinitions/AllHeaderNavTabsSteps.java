package com.expedia.stepDefinitions;

import com.expedia.pages.AllNavTabsPage;
import io.cucumber.java.en.Given;
import org.testng.Assert;

import static com.expedia.base.Hook.driver;

public class AllHeaderNavTabsSteps {

    AllNavTabsPage allNavTabsPage = new AllNavTabsPage(driver);

    @Given("user selects  Stays header {string} tab")
    public void userSelectsStaysHeaderTab(String Stays) {
        String result = allNavTabsPage.getNavigation_Tab(Stays);
        Assert.assertEquals(result, Stays);

    }

    @Given("user selects Flights header {string} tab")
    public void userSelectsFlightsHeaderTab(String Flights) {
        String result = allNavTabsPage.getNavigation_Tab(Flights);
        Assert.assertEquals(result, Flights);
    }

    @Given("user selects Cars header {string} tab")
    public void userSelectsCarsHeaderTab(String Cars) {
        String result = allNavTabsPage.getNavigation_Tab(Cars);
        Assert.assertEquals(result, Cars);
    }

    @Given("user selects Packages  header{string} tab")
    public void userSelectsPackagesHeaderTab(String Packages) {
        String result = allNavTabsPage.getNavigation_Tab(Packages);
        Assert.assertEquals(result, Packages);
    }

    @Given("user selects  Things to do header {string} tab")
    public void userSelectsThingsToDoHeaderTab(String thingsToDo) {
        String result = allNavTabsPage.getNavigation_Tab(thingsToDo);
        Assert.assertEquals(result, thingsToDo);
    }

    @Given("user selects Cruises header {string} tab")
    public void userSelectsCruisesHeaderTab(String Cruises) {
        String result = allNavTabsPage.getNavigation_Tab(Cruises);
        Assert.assertEquals(result, Cruises);
    }


    @Given("user selects deals header {string} tab")
    public void userSelectsDealsHeaderTab(String arg0) {
    }
}
