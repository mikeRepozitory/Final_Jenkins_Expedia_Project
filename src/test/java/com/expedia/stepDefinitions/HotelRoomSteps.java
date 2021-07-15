package com.expedia.stepDefinitions;

import com.expedia.pages.CarsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.expedia.base.Hook.driver;

public class HotelRoomSteps {

    @Given("user clicks on {string} tab")
    public void userClicksOnTab(String actualDesired_OptionCStays) {
      /*  String result = carsPage.getCarNavigation_Tab(actualDesired_OptionCars);
        Assert.assertEquals(actualDesired_OptionCars, result);*/
    }


    @Then("user selects GoingTo location {string}")
    public void userSelectsGoingToLocation(String actualDesired_Locations) {
/*        String result = carsPage.getCarNavigation_Tab(actualDesired_OptionCars);
        Assert.assertEquals(actualDesired_Locations, result);*/
    }

    @Then("user selects checkInDate date {string}")
    public void userSelectsCheckInDateDate(String actualDesired_CheckInpDate) {
     /*   String result = carsPage.carPickUpDateOption(pickUpDate);
        Assert.assertEquals(result, actualDesired_CheckInpDate);*/
    }

    @Then("user selects checkOutDate date {string}")
    public void userSelectsCheckOutDateDate(String actualDesired_CheckOutDate) {
      /*  String result = carsPage.getCarNavigation_Tab(actualDesired_OptionCars);
        Assert.assertEquals(actualDesired_CheckOutDate, result);*/

    }




}
