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

public class CarsPage {
    String navigationType = null;
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, 10);

    private static final org.apache.log4j.Logger logger = Logger.getLogger(CarsPage.class);

    public CarsPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        logger.info("carPage Constructor initialized");
    }


    @FindBy(css = "[aria-controls='wizard-car-pwa']")
    WebElement car_Tab;

    public String getCarNavigation_Tab(String navigationTypeSelector) {
        navigationType = car_Tab.getText();
        if (navigationType.equalsIgnoreCase(navigationTypeSelector)) {
            actions.moveToElement(car_Tab).click().build().perform();
            logger.info("clicked on: " + navigationType);
        }
        return navigationTypeSelector;
    }



}
