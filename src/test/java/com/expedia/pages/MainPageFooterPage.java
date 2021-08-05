package com.expedia.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.expedia.base.Hook.*;

public class MainPageFooterPage {


    WebDriverWait wait = new WebDriverWait(driver, 10);
    private static final org.apache.log4j.Logger logger = Logger.getLogger(MainPageFooterPage.class);
    JavascriptExecutor js = (JavascriptExecutor) driver;

    public MainPageFooterPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        logger.info("MainPageFooterPage Constructor initialized");
    }

    String companyLink = null;
    int linksSize = 0;

    @FindBy(xpath = "(//ul[@class='uitk-layout-grid-item no-bullet uitk-layout-grid-item-align-self-start uitk-layout-grid-item-rowstart-medium-2 uitk-layout-grid-item-rowstart-large-1'])[1]/li/div/a")
    List<WebElement> footerCompany_linksLocator;

    public String getFooterCompany_links(String expected) {
        js.executeScript("window.scrollBy(0,3000)");
        linksSize = footerCompany_linksLocator.size();
        for (int i = 0; i < linksSize - 1; i++) {
            if (footerCompany_linksLocator.get(i).getText().equalsIgnoreCase(expected)) {
                footerCompany_linksLocator.get(i).click();
                companyLink = driver.getCurrentUrl();
               // logger.info("Actual:  " + companyLink);
                driver.navigate().back();
                js.executeScript("window.scrollBy(0,3000)");
                wait.until(ExpectedConditions.visibilityOfAllElements(footerCompany_linksLocator));
            }
        }

        return companyLink;
    }


}
