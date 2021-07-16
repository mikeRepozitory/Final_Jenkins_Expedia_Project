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

import java.util.List;

import static com.expedia.base.Hook.driver;

public class HotelRoomPage {

    WebDriverWait wait = new WebDriverWait(driver, 10);

    private static final Logger logger = Logger.getLogger(HotelRoomPage.class);

    public HotelRoomPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        logger.info("HotelRoomPage Constructor initialized");
    }

    String navigationType = null;
    Actions actions = new Actions(driver);
    String checkInDate = null;
    String checkOutDate = null;
    String goingToTripSelector = null;
    String searchMainButton = null;
    String addACarCheckBoxString = null;
    String addFlightCheckBoxString = null;
    String tripSelectorLeavingFrom = null;


    @FindBy(css = "[aria-controls='wizard-hotel-pwa-v2']")
    WebElement hotel_Tab;
    @FindBy(css = "[data-stid='location-field-destination-menu-trigger']")
    WebElement goingToLocation;
    @FindBy(id = "location-field-destination")
    WebElement goingTo_TextBox;
    @FindBy(xpath = "(//button[@data-stid='location-field-destination-result-item-button'])[1]")
    WebElement goingTo_TextBox_option_DropDownAfterUserSendsKeys;
    @FindBy(xpath = "(//button[@class='uitk-faux-input uitk-form-field-trigger'])[1]")
    WebElement defaultHotelCheckIn_date;
    @FindBy(xpath = "(//button[@class='uitk-faux-input uitk-form-field-trigger'])[2]")
    WebElement defaultCheckOutDate;
    @FindBy(xpath = "//td/button")
    List<WebElement> allCalendarDates;
    @FindBy(xpath = "(//div/button[text()='Done'])[2]")
    WebElement calendarDone_button;


    @FindBy(xpath = "(//label[@class='uitk-checkbox-switch-label uitk-switch-label'])[2]")
    WebElement addACar_checkBox_WebElementLocator;
    @FindBy(xpath = "//button[text()='Search']")
    WebElement searchMain_button_Locator;


    @FindBy(xpath = "(//label[@class='uitk-checkbox-switch-label uitk-switch-label'])[1]")
    WebElement addAFlight_CheckBox_WebElement_Locator;
    @FindBy(css = "[placeholder='Where are you leaving from?']")
    WebElement whereAreYouLeavingFrom_TextBox;
    @FindBy(xpath = "//span[text()='Leaving from']")
    WebElement leavingFrom_TextBox;
    @FindBy(xpath = "(//ul[@class=\"uitk-typeahead-results no-bullet\"]/li)[1]/button/div")
    WebElement leavingFrom_TextBox_option_1;
    @FindBy(xpath = "(//button[@class='uitk-faux-input'])[1]")
    WebElement leavingFrom_TextBox_Get_ariaLabel;


    public String getStaysNavigation_Tab(String navigationTypeSelector) {
        navigationType = hotel_Tab.getText();
        if (navigationType.equalsIgnoreCase(navigationTypeSelector)) {
            actions.moveToElement(hotel_Tab).click().build().perform();
            logger.info("clicked on: " + navigationType + "  tab");
        }
        return navigationTypeSelector;
    }

    public String getGoingToHotelLocation(String actualGoingToLocation) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(goingToLocation));
        logger.info("aria-label: " + goingToLocation.getAttribute("aria-label"));

        actions.moveToElement(goingToLocation).click().build().perform();
        wait.until(ExpectedConditions.visibilityOf(goingTo_TextBox));
        actions.moveToElement(goingToLocation).sendKeys(actualGoingToLocation).build().perform();
        Thread.sleep(1000);

        wait.until(ExpectedConditions.visibilityOf(goingTo_TextBox_option_DropDownAfterUserSendsKeys));
        actions.moveToElement(goingTo_TextBox_option_DropDownAfterUserSendsKeys).click().build().perform();

        goingToTripSelector = wait.until(ExpectedConditions.visibilityOf(goingToLocation)).getText();
        logger.info("Actual hotel checkIn location: " + goingToTripSelector);
        if (goingToTripSelector.contains(actualGoingToLocation)) {
            return goingToTripSelector;

        } else {
            logger.info("Error hotel checkIn location is different: " + goingToTripSelector);
        }
        return goingToTripSelector;
    }

    public String getHotelCheckIn_DateOption(String actualHotelCheckIn) {
        checkInDate = wait.until(ExpectedConditions.visibilityOf(defaultHotelCheckIn_date)).getText();
        logger.info("Default checkIn date:  " + checkInDate);
        wait.until(ExpectedConditions.visibilityOf(defaultHotelCheckIn_date)).click();
        for (WebElement element : allCalendarDates) {
            if (element.getAttribute("aria-label").contains(actualHotelCheckIn)) {
                logger.info(actualHotelCheckIn = element.getAttribute("aria-label"));
                element.click();
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(calendarDone_button)).click();
        return actualHotelCheckIn;
    }

    public String getHotelCheckOut_DateOption(String actualCheckOutDate) {
        checkOutDate = wait.until(ExpectedConditions.visibilityOf(defaultCheckOutDate)).getText();
        logger.info("Default checkOut date:  " + checkOutDate);
        wait.until(ExpectedConditions.visibilityOf(defaultCheckOutDate)).click();
        for (WebElement element : allCalendarDates) {
            if (element.getAttribute("aria-label").contains(actualCheckOutDate)) {
                logger.info(actualCheckOutDate = element.getAttribute("aria-label"));
                element.click();
                break;
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(calendarDone_button)).click();
        return actualCheckOutDate;
    }

    public String addACar(String addOption) {
        addACarCheckBoxString = wait.until(ExpectedConditions.visibilityOf(addACar_checkBox_WebElementLocator)).getText();
        logger.info("addACarCheckBoxString: " + addACarCheckBoxString);
        if (addACar_checkBox_WebElementLocator.getText().contains(addOption)) {
            addACar_checkBox_WebElementLocator.click();
        }
        return addACarCheckBoxString;
    }

    public String removeTheCar(String removeOption) throws InterruptedException {
        removeOption = wait.until(ExpectedConditions.visibilityOf(addACar_checkBox_WebElementLocator)).getText();
        logger.info("remove the car if selected: " + addACarCheckBoxString);
        if (addACar_checkBox_WebElementLocator.isEnabled()) {
            addACar_checkBox_WebElementLocator.click();
        }

        Thread.sleep(4000);
        return removeOption;
    }



    public String clickOnSearch_MainButton(String actualSearchMainButton) {
        searchMainButton = searchMain_button_Locator.getText();
        if (searchMainButton.contains(actualSearchMainButton)) {
            logger.info("Clicked on:  " + searchMainButton);
            wait.until(ExpectedConditions.visibilityOf(searchMain_button_Locator)).click();
        } else {
            logger.info("Button is not found:  " + searchMainButton);

        }
        return actualSearchMainButton;

    }


}


