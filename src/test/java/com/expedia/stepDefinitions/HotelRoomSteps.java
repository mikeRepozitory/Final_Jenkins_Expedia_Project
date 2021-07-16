package com.expedia.stepDefinitions;

import com.expedia.pages.CarsPage;
import com.expedia.pages.HotelRoomPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.expedia.base.Hook.driver;

public class HotelRoomSteps {
    HotelRoomPage hotelRoomPage = new HotelRoomPage(driver);


    @Given("user clicks on {string} tab")
    public void userClicksOnTab(String actualDesired_OptionCStays) {
        String result = hotelRoomPage.getStaysNavigation_Tab(actualDesired_OptionCStays);
        Assert.assertEquals(actualDesired_OptionCStays, result);
    }


    @Then("user selects GoingTo location {string}")
    public void userSelectsGoingToLocation(String actualDesired_Locations) throws InterruptedException {
        String result = hotelRoomPage.getGoingToHotelLocation(actualDesired_Locations);
        Assert.assertEquals(result, actualDesired_Locations);
    }

    @Then("user selects checkInDate date {string}")
    public void userSelectsCheckInDateDate(String actualDesired_CheckInpDate) {
        String result = hotelRoomPage.getHotelCheckIn_DateOption(actualDesired_CheckInpDate);
        Assert.assertEquals(result, actualDesired_CheckInpDate);
    }

    @Then("user selects checkOutDate date {string}")
    public void userSelectsCheckOutDateDate(String actualDesired_CheckOutDate) {
        String result = hotelRoomPage.getHotelCheckOut_DateOption(actualDesired_CheckOutDate);
        Assert.assertEquals(result, actualDesired_CheckOutDate);
    }
    @Then("user selects {string} as well")
    public void userSelectsAsWell(String addCarAsWell) {
        String result = hotelRoomPage.addACar(addCarAsWell);
        Assert.assertEquals(result, addCarAsWell);

    }

    @Then("user removes the car {string}")
    public void userRemovesTheCar(String removeTheCar) throws InterruptedException {
        String result = hotelRoomPage.removeTheCar(removeTheCar);
        Assert.assertEquals(result, removeTheCar);
    }


    @And("after everything is done user should be able to click on {string} main button")
    public void afterEverythingIsDoneUserShouldBeAbleToClickOnMainButton(String searchMainButton) {
        String result = hotelRoomPage.clickOnSearch_MainButton(searchMainButton);
        Assert.assertEquals(result, searchMainButton);
    }



}
