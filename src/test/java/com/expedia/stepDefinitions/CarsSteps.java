package com.expedia.stepDefinitions;

import com.expedia.pages.CarsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import static com.expedia.base.Hook.driver;

public class CarsSteps {
    CarsPage carsPage = new CarsPage(driver);

    @Given("user selects {string} rental tab")
    public void userSelectsRentalTab(String actualDesired_OptionCars) {
        carsPage.getCarNavigation_Tab(actualDesired_OptionCars);
    }

    @Then("user selects pickUp Location {string}")
    public void userSelectsPickUpLocation(String arg0) {
    }

    @Then("user selects dropOff Location {string}")
    public void userSelectsDropOffLocation(String arg0) {
    }

    @Then("user selects pickUp date {string}")
    public void userSelectsPickUpDate(String arg0) {
    }

    @Then("user selects dropOff date {string}")
    public void userSelectsDropOffDate(String arg0) {
    }

    @Then("user selects pickUp time {string}")
    public void userSelectsPickUpTime(String arg0) {
    }

    @Then("user selects dropOff time {string}")
    public void userSelectsDropOffTime(String arg0) {
    }
}
