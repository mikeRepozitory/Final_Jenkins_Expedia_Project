package com.expedia.stepDefinitions;

import com.expedia.pages.CarsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.expedia.base.Hook.driver;

public class CarsSteps {
    CarsPage carsPage = new CarsPage(driver);

    @Given("user selects {string} rental tab")
    public void userSelectsRentalTab(String actualDesired_OptionCars) {
        String result = carsPage.getCarNavigation_Tab(actualDesired_OptionCars);
        Assert.assertEquals(actualDesired_OptionCars, result);

    }


    @Then("user selects pickUp location {string}")
    public void userSelectsPickUpLocation(String pickUpLocation) throws InterruptedException {
        String result = carsPage.GetCarPickUpLocation(pickUpLocation);
        Assert.assertEquals(pickUpLocation, result);

    }

    @Then("user selects dropOff location {string}")
    public void userSelectsDropOffLocation(String dropOffLocation) throws InterruptedException {
        String result = carsPage.GetCarDropOffLocation(dropOffLocation);
        Assert.assertEquals(dropOffLocation, result);

    }


    @Then("user selects pickUp date {string}")
    public void userSelectsPickUpDate(String pickUpDate) {
        String result = carsPage.carPickUpDateOption(pickUpDate);
        Assert.assertEquals(result, pickUpDate);
    }

    @Then("user selects dropOff date {string}")
    public void userSelectsDropOffDate(String dropOffDate) {
        String result = carsPage.getCarDropOffDateOption(dropOffDate);
        Assert.assertEquals(result, dropOffDate);

    }

    @Then("user selects pickUp time {string}")
    public void userSelectsPickUpTime(String pickUpTime) {
        String result = carsPage.getCarPickUpTime(pickUpTime);
        Assert.assertEquals(result, pickUpTime);
    }

    @Then("user selects dropOff time {string}")
    public void userSelectsDropOffTime(String dropOffTime) {
        String result = carsPage.getCarDropOffTime(dropOffTime);
        Assert.assertEquals(result, dropOffTime);

    }

}
