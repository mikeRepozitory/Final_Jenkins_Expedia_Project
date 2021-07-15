package com.expedia.pages;

import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.expedia.base.Hook.driver;

public class HotelRoomPage {
    String navigationType = null;
    Actions actions = new Actions(driver);
    String pickUpDate = null;
    String dropOffDate = null;
    String tripSelectorDropOffAt = null;
    String carPickUpTripSelector = null;

    String pickUpTime = null;
    String dropOffTime = null;
    Select select;
    String searchMainButton;


    WebDriverWait wait = new WebDriverWait(driver, 10);

    private static final Logger logger = Logger.getLogger(HotelRoomPage.class);

    public HotelRoomPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        logger.info("HotelRoomPage Constructor initialized");
    }


  /*  @FindBy(css = "[aria-controls='wizard-car-pwa']")
    WebElement car_Tab;
    @FindBy(xpath = "//button[@data-stid='location-field-locn-menu-trigger']")
    WebElement defaultPickUpLocation;
    @FindBy(xpath = "//button[@data-stid='location-field-loc2-menu-trigger']")
    WebElement defaultDropOffLocation;
    @FindBy(id = "location-field-locn")
    WebElement pickUpFrom_TextBox;

    @FindBy(xpath = "(//button[@data-stid='location-field-locn-result-item-button'])[1]")
    WebElement carPickUpFrom_TextBox_option_1;

    @FindBy(xpath = "(//button[@data-stid='location-field-loc2-result-item-button'])[1]")
    WebElement carDropOffAt_TextBox_option_1;


    @FindBy(xpath = "//button[@data-stid='location-field-loc2-menu-trigger']")
    WebElement dropOffAt_TextBox;

    @FindBy(xpath = "(//button[@class='uitk-faux-input uitk-form-field-trigger'])[1]")
    WebElement defaultPickUpDate;
    @FindBy(xpath = "(//button[@class='uitk-faux-input uitk-form-field-trigger'])[2]")
    WebElement defaultDropOffDate;
    @FindBy(xpath = "//td/button")
    List<WebElement> allCalendarDates;
    @FindBy(xpath = "//div/button[text()='Done']")
    WebElement calendarDone_button;

    @FindBy(xpath = "//select[@aria-label='Pick-up time']")
    WebElement pickUpTime_dropDown;
    @FindBy(xpath = "//select[@aria-label='Drop-off time']")
    WebElement dropOffTime_dropDown;

    @FindBy(xpath = "//button[text()='Search']")
    WebElement searchForRentalCarsMain_button;





    public String getCarNavigation_Tab(String navigationTypeSelector) {
        navigationType = car_Tab.getText();
        if (navigationType.equalsIgnoreCase(navigationTypeSelector)) {
            actions.moveToElement(car_Tab).click().build().perform();
            logger.info("clicked on: " + navigationType + " tab");
        }
        return navigationTypeSelector;
    }

    public String GetCarPickUpLocation(String actualPickUpLocation) {
        wait.until(ExpectedConditions.visibilityOf(defaultPickUpLocation));
        actions.moveToElement(defaultPickUpLocation).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(pickUpFrom_TextBox));
        actions.moveToElement(defaultPickUpLocation).sendKeys(actualPickUpLocation).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(carPickUpFrom_TextBox_option_1));
        actions.moveToElement(carPickUpFrom_TextBox_option_1).click().build().perform();

        carPickUpTripSelector = wait.until(ExpectedConditions.elementToBeClickable(defaultPickUpLocation)).getText();
        logger.info("Car pickUp location: " + carPickUpTripSelector);
        return carPickUpTripSelector;
    }

    public String GetCarDropOffLocation(String actualDropOffLocation) {
        wait.until(ExpectedConditions.visibilityOf(defaultDropOffLocation));
        actions.moveToElement(defaultDropOffLocation).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(dropOffAt_TextBox));
        actions.moveToElement(defaultDropOffLocation).sendKeys(actualDropOffLocation).build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(carDropOffAt_TextBox_option_1));
        actions.moveToElement(carDropOffAt_TextBox_option_1).click().build().perform();

        tripSelectorDropOffAt = wait.until(ExpectedConditions.elementToBeClickable(defaultDropOffLocation)).getText();
        logger.info("Car dropOff location: " + tripSelectorDropOffAt);
        return tripSelectorDropOffAt;
    }

    public String carPickUpDateOption(String actualPickUpDate) {
        pickUpDate = wait.until(ExpectedConditions.visibilityOf(defaultPickUpDate)).getAttribute("aria-label");
        logger.info("Default pickUp date:  " + pickUpDate);
        defaultPickUpDate.click();
        for (WebElement element : allCalendarDates) {
            if (element.getAttribute("aria-label").contains(actualPickUpDate)) {
                logger.info(actualPickUpDate = element.getAttribute("aria-label"));
                element.click();
                break;
            }
        }
        calendarDone_button.click();
        return actualPickUpDate;
    }

    public String getCarDropOffDateOption(String actualDropOffDate) {
        dropOffDate = wait.until(ExpectedConditions.visibilityOf(defaultDropOffDate)).getAttribute("aria-label");
        logger.info("Default dropOff date:  " + dropOffDate);
        defaultDropOffDate.click();
        for (WebElement element : allCalendarDates) {
            if (element.getAttribute("aria-label").contains(actualDropOffDate)) {
                logger.info(actualDropOffDate = element.getAttribute("aria-label"));
                element.click();
                break;
            }
        }
        calendarDone_button.click();
        return actualDropOffDate;
    }

    public String getCarPickUpTime(String actualTime) {
        select = new Select(pickUpTime_dropDown);
        logger.info("select size: " + select.getOptions().size());

        for (int i = 0; i < select.getOptions().size(); i++) {
            pickUpTime = select.getOptions().get(i).getText();
            if (pickUpTime.equalsIgnoreCase(actualTime)) {
                logger.info("Selected pickUp Time: " + pickUpTime);
                select.getOptions().get(i).click();
                break;
            }
        }
        return pickUpTime;
    }

    public String getCarDropOffTime(String actualTime) {
        select = new Select(dropOffTime_dropDown);
        for (int i = 0; i < select.getAllSelectedOptions().size(); i++) {
            dropOffTime = select.getOptions().get(i).getText();
            if (dropOffTime.contains(actualTime)) {
                logger.info("Selected dropOff Time : " + dropOffTime);
                select.getAllSelectedOptions().get(i).click();
                searchMainButton = searchForRentalCarsMain_button.getText();
                logger.info("Clicked on:  " + searchMainButton);
                searchForRentalCarsMain_button.click();
                break;
            }
        }
        return dropOffTime;
    }
*/

}
