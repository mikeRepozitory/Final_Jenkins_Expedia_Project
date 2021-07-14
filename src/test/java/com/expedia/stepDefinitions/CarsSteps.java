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


    @Then("user selects pickUp location {string}")
    public void userSelectsPickUpLocation(String pickUpLocation) throws InterruptedException {
        carsPage.GetCarPickUpLocation(pickUpLocation);
    }

    @Then("user selects dropOff location {string}")
    public void userSelectsDropOffLocation(String dropOffLocation) throws InterruptedException {
        carsPage.GetCarDropOffLocation(dropOffLocation);
    }


    @Then("user selects pickUp date {string}")
    public void userSelectsPickUpDate(String pickUpDate) {
        carsPage.carPickUpDateOption(pickUpDate);
    }

    @Then("user selects dropOff date {string}")
    public void userSelectsDropOffDate(String dropOffDate) {
        carsPage.getCarDropOffDateOption(dropOffDate);
    }

    @Then("user selects pickUp time {string}")
    public void userSelectsPickUpTime(String pickUpTime) {
        carsPage.getCarPickUpTime(pickUpTime);
    }

    @Then("user selects dropOff time {string}")
    public void userSelectsDropOffTime(String dropOffTime) {
        carsPage.getCarDropOffTime(dropOffTime);

    }

}
