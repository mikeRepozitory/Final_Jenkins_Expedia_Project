package com.expedia.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.expedia.base.Hook.driver;

public class AllNavTabsPage {

    Actions actions = new Actions(driver);
    String tabString;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    private static final Logger logger = Logger.getLogger(AllNavTabsPage.class);

    public AllNavTabsPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        logger.info("carPage Constructor initialized");
    }


    @FindBy(xpath = "//div[@class='uitk-tabs-container']/ul/li/a")
    List<WebElement> allNavTabs_locator;


    public String getNavigation_Tab(String navigationTypeSelector) {
        for (WebElement element : allNavTabs_locator) {
            tabString = element.getText();
            if (tabString.equalsIgnoreCase(navigationTypeSelector)) {
                actions.moveToElement(element).click().build().perform();
                logger.info("clicked on: " + tabString + " tab");
            }
        }
        return navigationTypeSelector;

    }

}
