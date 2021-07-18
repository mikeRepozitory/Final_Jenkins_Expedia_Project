package com.expedia.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.expedia.base.Hook.driver;

public class MoreTravelHeaderNavTabsPage {

    String tabString;
    String currentURL;
    private static final Logger logger = Logger.getLogger(MoreTravelHeaderNavTabsPage.class);

    public MoreTravelHeaderNavTabsPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        logger.info("AllHeaderNavTabsPage Constructor initialized");
    }

    @FindBy(xpath = "//div[text()='More travel']")
    WebElement moreTravelHeaderTab;
    @FindBy(xpath = "//div[@class='uitk-menu-container uitk-menu-open uitk-menu-pos-left uitk-menu-container-autoposition']/div/a/div")
    List<WebElement> allHeaderNavTabs_locator;

    public String getNavigation_Tab(String navigationTypeSelector, String actualURL) throws InterruptedException {
        moreTravelHeaderTab.click();
        for (int i = 0; i < allHeaderNavTabs_locator.size(); i++) {
            tabString = allHeaderNavTabs_locator.get(i).getText();
            if (tabString.equalsIgnoreCase(navigationTypeSelector)) {
                allHeaderNavTabs_locator.get(i).click();
                logger.info("clicked on: " + tabString);
                Thread.sleep(2000);
                currentURL = driver.getCurrentUrl();
                if (currentURL.equalsIgnoreCase(actualURL))
                    logger.info("URL is: " + actualURL);
                break;
            }
        }
        return currentURL;
    }

}