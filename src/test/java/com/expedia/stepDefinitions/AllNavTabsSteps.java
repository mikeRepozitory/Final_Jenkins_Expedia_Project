package com.expedia.stepDefinitions;

import com.expedia.pages.AllNavTabsPage;
import com.expedia.pages.CarsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.expedia.base.Hook.driver;

public class AllNavTabsSteps {

    AllNavTabsPage allNavTabsPage = new AllNavTabsPage(driver);


    @Given("user selects  Stays {string} tab")
    public void userSelectsStaysTab(String Stays) {
        String result = allNavTabsPage.getNavigation_Tab(Stays);
        Assert.assertEquals(result, Stays);
    }


    @Given("user selects Flights {string} tab")
    public void userSelectsFlightsTab(String Flights) {
        String result = allNavTabsPage.getNavigation_Tab(Flights);
        Assert.assertEquals(result, Flights);
    }

    @Given("user selects Cars {string} tab")
    public void userSelectsCarsTab(String Cars) {
        String result = allNavTabsPage.getNavigation_Tab(Cars);
        Assert.assertEquals(result, Cars);
    }

    @Given("user selects Packages {string} tab")
    public void userSelectsPackagesTab(String Packages) {
        String result = allNavTabsPage.getNavigation_Tab(Packages);
        Assert.assertEquals(result, Packages);
    }

    @Given("user selects  Things to do {string} tab")
    public void userSelectsThingsToDoTab(String thingsToDo) {
        String result = allNavTabsPage.getNavigation_Tab(thingsToDo);
        Assert.assertEquals(result, thingsToDo);
    }

    @Given("user selects Cruises {string} tab")
    public void userSelectsCruisesTab(String Cruises) {
        String result = allNavTabsPage.getNavigation_Tab(Cruises);
        Assert.assertEquals(result, Cruises);
    }


}
