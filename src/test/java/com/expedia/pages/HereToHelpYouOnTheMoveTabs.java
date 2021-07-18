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

import static com.expedia.base.Hook.driver;

public class HereToHelpYouOnTheMoveTabs {

    Actions actions = new Actions(driver);
    String tabString = null;
    String popUpWindow = null;
    String currentURL = null;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    private static final Logger logger = Logger.getLogger(HereToHelpYouOnTheMoveTabs.class);

    public HereToHelpYouOnTheMoveTabs(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        logger.info("HereToHelpYouOnTheMoveTabs Constructor initialized");
    }

    @FindBy(xpath = "(//a[@class='uitk-card-aloha-link'])[1]/span")
    WebElement cancelOrChangeTrip;
    @FindBy(xpath = "(//a[@class='uitk-card-aloha-link'])[2]")
    WebElement useACreditOrCoupon_locator;
    @FindBy(xpath = "(//a[@class='uitk-card-aloha-link'])[3]")
    WebElement trackYourRefund_locator;
    @FindBy(css = "[class='uitk-subheading cpce-vac-header-text']")
    WebElement visualAgentPopUpWindow;
    @FindBy(xpath = "//iframe[@id='vac_iframe_7f93fe09-1d7c-4eb4-a66d-5f6f08740614']")
    WebElement iframe;

    public String getCancelOrChangeTrip_Tab(String result) throws InterruptedException {
        Thread.sleep(1000);
        tabString = cancelOrChangeTrip.getText();
        wait.until(ExpectedConditions.visibilityOf(cancelOrChangeTrip));
        actions.moveToElement(cancelOrChangeTrip).click().build().perform();
        logger.info("Clicked on: " + tabString);
        Thread.sleep(5000);
        driver.switchTo().frame(iframe);
        popUpWindow = visualAgentPopUpWindow.getText();
        if (popUpWindow.contains(result)) {

        }
        return popUpWindow;
    }

    public void getUseACreditOrCoupon_Tab() throws InterruptedException {
        Thread.sleep(1000);
        tabString = useACreditOrCoupon_locator.getText();
        useACreditOrCoupon_locator.click();
        logger.info("Clicked on: " + tabString);
    }

    public String getCurrentURL(String url) throws InterruptedException {
        Thread.sleep(1000);
        currentURL = driver.getCurrentUrl();
        if (currentURL.equalsIgnoreCase(url)) {
            logger.info("currentURL: " + currentURL);

        } else {
            logger.info("Invalid url: " + currentURL);
        }
        return currentURL;
    }

    public String getTrackYourRefund_Tab(String popUpTabName) throws InterruptedException {
        Thread.sleep(1000);
        tabString = trackYourRefund_locator.getText();
        trackYourRefund_locator.click();
        logger.info("Clicked on: " + tabString);
        driver.switchTo().frame(4);


        return currentURL;
    }



}
