package com.expedia.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

import static com.expedia.base.Hook.driver;

public class FlightsPage implements Serializable {
    private static final org.apache.log4j.Logger logger = Logger.getLogger(FlightsPage.class);


    public FlightsPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        logger.info("Constructor initialized");
    }

    String navigationType = null;
    String tripSelectorLeavingFrom = null;
    String tripSelectorGoingTo = null;
    String currentURL = null;
    String cabinOptions = null;
    String tripOptions = null;
    String date = null;
    String dateFromTheCalendar;
    String numberOfAdultsTravelers = null;
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);

    @FindBy(css = "[class='uitk-header-brand-logo']")
    WebElement expediaMainLogo;
    @FindBy(css = "[aria-controls='wizard-flight-pwa']")
    WebElement flights_Tab;

    @FindBy(xpath = "//span[text()='Leaving from']")
    WebElement leavingFrom_TextBox;
    @FindBy(css = "[placeholder='Where are you leaving from?']")
    WebElement whereAreYouLeavingFrom_TextBox;
    @FindBy(xpath = "(//ul[@class='uitk-typeahead-results no-bullet']/li)[1]")
    WebElement leavingFrom_TextBox_option_1;
    @FindBy(xpath = "(//button[@class='uitk-faux-input'])[1]")
    WebElement leavingFrom_TextBox_Get_ariaLabel;

    @FindBy(xpath = "//span[text()='Going to']")
    WebElement goingTo_TextBox;
    @FindBy(css = "[placeholder='Where are you going to?']")
    WebElement whereAreYouGoingTo_TextBox_option;
    @FindBy(xpath = "((//ul[@class='uitk-typeahead-results no-bullet'])[2]/li)[1]/button")
    WebElement getGoingTo_TextBox_option_1;
    @FindBy(xpath = "(//button[@class='uitk-faux-input'])[2]")
    WebElement getGoingTo_TextBox_TextBox_GetText;

    @FindBy(css = "[class='uitk-faux-input uitk-form-field-trigger']")
    WebElement departingDate;
    @FindBy(xpath = "//div[@class='uitk-tabs-inner-container']/li/a/span")
    List<WebElement> round_Oneway_MultiCity_trip;

    @FindBy(xpath = "//td/button")
    List<WebElement> allDates;

 /*   @FindBy(xpath = "//nav[@class='PrimaryNav_PrimaryNav__3g1eL']/div")
    List<WebElement> primaryNav_Buttons;
    @FindBy(xpath = "(//table[@class='uitk-date-picker-weeks'])[1]")
    List<WebElement> calendarRightTable;
    @FindBy(xpath = "(//table[@class='uitk-date-picker-weeks'])[2]")
    List<WebElement> calendarLeftTable;*/

    public String getFlightNavigation_Tab(String navigationTypeSelector) {
        navigationType = flights_Tab.getText();
        if (navigationType.equalsIgnoreCase(navigationTypeSelector)) {
            actions.moveToElement(flights_Tab).click().build().perform();
            logger.info("clicked on: " + navigationType);
        }
        return navigationTypeSelector;
    }

    @FindBy(xpath = "(//div[@class='uitk-flex uitk-flex-justify-content-space-between uitk-date-picker-menu-pagination-container']/button)[1]")
    WebElement calendarPrevious_Button;
    @FindBy(xpath = "(//div[@class='uitk-flex uitk-flex-justify-content-space-between uitk-date-picker-menu-pagination-container']/button)[2]")
    WebElement calendarNext_Button;

    public String setRound_Oneway_MultiCity_trip_option(String actual_Round_Oneway_MultiCity_trip) {
        for (WebElement element : round_Oneway_MultiCity_trip) {
            tripOptions = element.getText();
            if (actual_Round_Oneway_MultiCity_trip.equalsIgnoreCase(tripOptions)) {
                element.click();
                currentURL = driver.getCurrentUrl();
                logger.info("clicked on: " + tripOptions);
                logger.info("currentURL: " + currentURL);
                break;
            }
        }
        return tripSelectorLeavingFrom;
    }

    public String selectTripTypeFrom_option(String tripTypeSelector) throws InterruptedException {
        actions.moveToElement(leavingFrom_TextBox).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(whereAreYouLeavingFrom_TextBox)).sendKeys(tripTypeSelector);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(leavingFrom_TextBox_option_1)).click();
        tripSelectorLeavingFrom = wait.until(ExpectedConditions.elementToBeClickable(leavingFrom_TextBox_Get_ariaLabel)).getText();
        logger.info("Leaving from: " + tripSelectorLeavingFrom);
        return tripSelectorLeavingFrom;
    }

    public String setTripTypeGoingTo(String tripTypeSelector) throws InterruptedException {
        actions.moveToElement(goingTo_TextBox).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(whereAreYouGoingTo_TextBox_option)).sendKeys(tripTypeSelector);
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(getGoingTo_TextBox_option_1)).click();
        tripSelectorGoingTo = wait.until(ExpectedConditions.elementToBeClickable(getGoingTo_TextBox_TextBox_GetText)).getText();
        logger.info("Going to: " + tripSelectorGoingTo);
        return tripSelectorGoingTo;
    }

    public void getDepartingDate(String actualTravelDate) {
        date = wait.until(ExpectedConditions.visibilityOf(departingDate)).getAttribute("aria-label");
        logger.info("aria-label: " + date);
        departingDate.click();

        for (WebElement element : allDates) {
            if (element.getAttribute("aria-label").contains(actualTravelDate)) {
                element.click();
                logger.info("clicked on  " + date);

            }
        }

    }
}

/*

    public String selectTripTypeSelector_option(String tripTypeSelector) {
        app_flights_selector_options = driver.findElements(By.xpath("//label[@class='BpkRadio_bpk-radio__3J6D- TripTypeSelector_TripTypeSelector__1qmS8']"));
        for (WebElement element : app_flights_selector_options) {
            tripSelector = element.getText();
            if (tripTypeSelector.equalsIgnoreCase(tripSelector)) {
                element.click();
                logger.info("clicked on: " + tripSelector);
                logger.info("currentURL: " + currentURL);
                break;
            }
        }
        return tripSelector;
    }

    public String selectFlyingFrom_option(String flyingFromWhere) {
        try {
            logger.info("in the try selectFlyingFrom_option ");
            flyingFrom_placeholder.sendKeys(flyingFromWhere);
        } catch (Exception e) {
            logger.info("in the catch selectFlyingFrom_option ");

            driver.switchTo().frame(4);
            popUpClose_button.click();
            driver.switchTo().defaultContent();
            flyingFrom_placeholder.sendKeys(flyingFromWhere);
            e.printStackTrace();
        } finally {
            logger.info("in the finally selectFlyingFrom_option ");

            flyingFrom_placeholder.sendKeys(flyingFromWhere);
        }

        return flyingFromWhere;
    }

    public String selectFlyingTo_option(String flyingTo) {
        try {
            flyingTO_placeholder.sendKeys(flyingTo);
        } catch (Exception e) {
            driver.switchTo().frame(4);
            popUpClose_button.click();
            driver.switchTo().defaultContent();
            flyingTO_placeholder.sendKeys(flyingTo);
            e.printStackTrace();
        } finally {
            flyingTO_placeholder.sendKeys(flyingTo);
        }

        return flyingTo;
    }


    public void setDepartureDate(String desiredDate) {
        departureDate_textBox.sendKeys(desiredDate);
        logger.info("desiredDate submitted: " + desiredDate);
    }


    public void searchForTheFlight() {
        searchFlights_Button.click();
    }*/
/*
    public String setCabinClass(String desiredCabinClassOption) throws InterruptedException {
        actions.moveToElement(cabinClassTravellersSelector).click().build().perform();
        Select select = new Select(cabinClass_SelectOption);
        for (int i = 0; i < select.getAllSelectedOptions().size(); i++) {
            cabinOptions = select.getAllSelectedOptions().get(i).getText();
            if (desiredCabinClassOption.equalsIgnoreCase(cabinOptions)) {
                select.getAllSelectedOptions().get(i).click();
                logger.info("clicked on: " + cabinOptions);
                Thread.sleep(1000);
                break;
            }
            logger.info("invalid navigationTypeSelector:  " + cabinOptions);
        }
        logger.info("cabinOptions:  " + cabinOptions);
        return cabinOptions;

    }*/
/*

    public String setNumberOfTravelers(String desiredNumberOfTravelers) {

        numberOfAdultsTravelers = numberOFAdultTravelersDefaultOption.getCssValue("value");
        logger.info("numberOfAdultsTravelers: " + numberOfAdultsTravelers);

        if (numberOfAdultsTravelers.equalsIgnoreCase(desiredNumberOfTravelers)) {
            SearchFlights_Button.click();
            logger.info("numberOfAdultsTravelers: " + numberOfAdultsTravelers);
        } else
            decreaseNumberOfAdults_Button.click();
        logger.info("failed to search flight !!! ");
        return numberOfAdultsTravelers;
    }

*/




