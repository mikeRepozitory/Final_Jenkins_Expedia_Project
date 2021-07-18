package com.expedia.pages;

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

import static com.expedia.base.Hook.driver;

public class MainPageHeaderTabsPage {

    Actions actions = new Actions(driver);
    String tabString;
    Select select = null;
    String selectDropDownOptions = null;
    String saveButton = null;
    String singIn_Button = null;
    String currentURLString = null;
    String signUpItsFreePopUpWindow_String = null;

    WebDriverWait wait = new WebDriverWait(driver, 10);

    private static final Logger logger = Logger.getLogger(MainPageHeaderTabsPage.class);

    public MainPageHeaderTabsPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        logger.info("MainPageHeaderTabsPage Constructor initialized");
    }

    @FindBy(xpath = "//div[@class='uitk-text uitk-type-300 uitk-text uitk-text-default-theme']")
    WebElement englishNavTabs_locator;
    @FindBy(xpath = "//div[@class='uitk-dialog uitk-dialog-fullscreen uitk-dialog-fullscreen-bg-default']")
    WebElement englishPopUpWindow_locator;
    @FindBy(xpath = "//select[@id='site-selector']")
    WebElement getLanguageDropDownPopUpRegion_locator;
    @FindBy(xpath = "//select[@id='language-selector']")
    WebElement getLanguageDropDownPopUp_locator;
    @FindBy(xpath = "//button[text()='Save']")
    WebElement getLanguagePopUpSaveButton_locator;
    @FindBy(xpath = "//div[@id='gc-custom-header-nav-bar-acct-menu']/button")
    WebElement navHeaderSignInMain_Button_locator;
    @FindBy(xpath = "//a[@class='uitk-button uitk-button-medium uitk-button-fullWidth uitk-button-has-text uitk-button-primary']")
    WebElement singInPopUpWindow_Locator;
    @FindBy(xpath = "//a[@class='uitk-button uitk-button-medium uitk-button-fullWidth uitk-button-has-text uitk-button-tertiary']")
    WebElement signUpItsFreePopUpWindow_Locator;

    public void getEnglishNavigation_Tab() {
        tabString = englishNavTabs_locator.getText();
        englishNavTabs_locator.click();
        logger.info("clicked on: " + tabString + " tab");
    }

    public boolean isEnglishPopUpWindowDisplayed() {
        if (englishPopUpWindow_locator.isDisplayed()) {
            //   tabString = englishPopUpWindow_locator.getText();
            //    logger.info("window: " + tabString + " tab is displayed");
            return true;
        } else {
            return false;
        }
    }

    public String getLanguageDropDownPopUpRegion(String region) {
        select = new Select(getLanguageDropDownPopUpRegion_locator);
        logger.info("select size: " + select.getOptions().size());
        for (int i = 0; i < select.getOptions().size(); i++) {
            selectDropDownOptions = select.getOptions().get(i).getText();
            if (selectDropDownOptions.equalsIgnoreCase(region)) {
                logger.info("selectDropDownOptions: " + selectDropDownOptions);
                select.getOptions().get(i).click();
                break;
            }
        }
        return selectDropDownOptions;
    }


    public String getLanguageDropDownPopUp(String language) {
        select = new Select(getLanguageDropDownPopUp_locator);
        // logger.info("select size: " + select.getOptions().size());
        for (int i = 0; i < select.getOptions().size(); i++) {
            selectDropDownOptions = select.getOptions().get(i).getText();
            if (selectDropDownOptions.equalsIgnoreCase(language)) {
                logger.info("selectDropDownOptions: " + selectDropDownOptions);
                select.getOptions().get(i).click();
                break;
            }
        }
        return selectDropDownOptions;
    }


    public String getLanguageDropDownPopUpSave_button(String expectedResult) {
        saveButton = getLanguagePopUpSaveButton_locator.getText();
        if (saveButton.equalsIgnoreCase(expectedResult)) {
            logger.info("clicked on saveButton: " + saveButton);
            getLanguagePopUpSaveButton_locator.click();
            return saveButton;
        } else return null;
    }

    public String getHeaderMainSignIn_button(String sinInButton)  {
        wait.until(ExpectedConditions.visibilityOf(navHeaderSignInMain_Button_locator));
        singIn_Button = navHeaderSignInMain_Button_locator.getText();
        if (singIn_Button.equalsIgnoreCase(sinInButton) && singInPopUpWindow_Locator.isDisplayed()) {
            logger.info("Passed: " + singIn_Button);
            return singIn_Button;
        } else
        navHeaderSignInMain_Button_locator.click();
        return singIn_Button;
    }

    public String getPopUpWindowsSgnUpItsFreePopUpWindow_button(String sinInButton) {
        wait.until(ExpectedConditions.visibilityOf(signUpItsFreePopUpWindow_Locator));
        singIn_Button = signUpItsFreePopUpWindow_Locator.getText();
        if (singIn_Button.equalsIgnoreCase(sinInButton) && signUpItsFreePopUpWindow_Locator.isDisplayed()) {
            signUpItsFreePopUpWindow_Locator.click();
            logger.info("Passed: " + singIn_Button);
            return singIn_Button;
        } else return null;
    }


    public String getPopUpWindowSignIn_button(String signUpItsFreePopUpWindow) {
        signUpItsFreePopUpWindow_String = singInPopUpWindow_Locator.getText();
        if (singIn_Button.equalsIgnoreCase(signUpItsFreePopUpWindow) && singInPopUpWindow_Locator.isDisplayed()) {
            singInPopUpWindow_Locator.click();
            logger.info("Passed: " + signUpItsFreePopUpWindow_String);
            return signUpItsFreePopUpWindow_String;
        } else return null;
    }




    public String getCurrentUrl(String URL)  {
        currentURLString = driver.getCurrentUrl();
        if (currentURLString.equalsIgnoreCase(URL)) {
            logger.info("Passed: " + currentURLString);
            return currentURLString;
        } else return null;
    }





}