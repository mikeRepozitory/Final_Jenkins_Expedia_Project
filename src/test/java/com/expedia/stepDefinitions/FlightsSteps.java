package com.expedia.stepDefinitions;

import com.expedia.pages.FlightsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.expedia.base.Hook.driver;


public class FlightsSteps {


    FlightsPage flightsPage = new FlightsPage(driver);


    @Given("user selects {string} tab")
    public void userSelectsTab(String navigationType) throws InterruptedException {
        flightsPage.getFlightNavigation_Tab(navigationType);

    }

    @Then("user selects {string} trip")
    public void userSelectsTrip(String oneWayTrip_option) {
        flightsPage.setRound_Oneway_MultiCity_trip_option(oneWayTrip_option);

    }

    @Then("user selects from {string}")
    public void userSelectsFrom(String from) throws InterruptedException {
        flightsPage.selectTripTypeFrom_option(from);

    }

    @Then("user selects to {string}")
    public void userSelectsTo(String to) throws InterruptedException {
        flightsPage.setTripTypeGoingTo(to);
    }

    @Then("user selects departure date {string}")
    public void userSelectsDepartureDate(String departureDate) {
        flightsPage.getDepartingDate(departureDate);
    }

    @Then("user selects Cabin Class & Travelers {string}")
    public void userSelectsCabinClassTravelers(String cabinClass) {
    }

    @Then("user selects number of Travelers {string}")
    public void userSelectsNumberOfTravelers(String numberOfTravelers) {


    }
}
