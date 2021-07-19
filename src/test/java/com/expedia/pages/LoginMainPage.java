package com.expedia.pages;

import com.expedia.base.Library;
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

public class LoginMainPage {

    Actions actions = new Actions(driver);
    String message = null;

    WebDriverWait wait = new WebDriverWait(driver, 10);
    Library library = new Library();

    private static final Logger logger = Logger.getLogger(LoginMainPage.class);

    public LoginMainPage(WebDriver driver) {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
        logger.info("carPage Constructor initialized");
    }

    @FindBy(xpath = "//div[@id='wrong-credentials-error-div']/h5")
    WebElement wrongCredentialAlertMessage;
    @FindBy(xpath = "(//input[@type='email'])[3]")
    WebElement emailUserName_locator;
    @FindBy(css = "[type='email'")
    WebElement googleEmailUserName_locator;

    @FindBy(css = "[id='account_name_text_field']")
    WebElement appleEmailUserNameTextBo_locator;
    @FindBy(css = "[class='icon icon_sign_in']")
    WebElement appleNextUserNameButton_locator;
    @FindBy(css = "[id='password_text_field']")
    WebElement applePasswordTextBox_locator;

    @FindBy(css = "[type='password'")
    WebElement googlePassword_locator;
    @FindBy(xpath = "//input[@type='password']")
    WebElement password_locator;
    @FindBy(xpath = "(//div[@class='VfPpkd-RLmnJb'])[1]")
    WebElement googleNextButton_locator;
    @FindBy(xpath = "//button[@id='submitButton']")
    WebElement submitButton_locator;
    @FindBy(xpath = "//form[@class='googleSignInform']/button")
    WebElement signInWithGoogleButton_locator;
    @FindBy(xpath = "//form[@class='appleSignInform']/button/span")
    WebElement signInWithAppleButton_locator;
    @FindBy(xpath = "//span[text()='Wrong password. Try again or click Forgot password to reset it.']")
    WebElement wrongCredentialAlertGoogleMessage_locator;
    @FindBy(xpath = "//button[@id='unlock-account-1626718627830-7']")
    WebElement wrongCredentialAlertAppleMessage_locator;

    public void getUsernameAndPassword(String userName, String password) {
        emailUserName_locator.sendKeys(userName);
        password_locator.sendKeys(password);
        submitButton_locator.click();
        logger.info("Success sent the credentials");
    }

    public String isLoggedInMessage(String expected) {
        message = wrongCredentialAlertMessage.getText();
        if (wrongCredentialAlertMessage.isDisplayed() && message.equalsIgnoreCase(expected)) {
            logger.info("Error while sending credentials: ");
            return message;
        } else
            return null;
    }

    public String isGoogleLoginWindowDisplayed(String expected) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(signInWithGoogleButton_locator));
        message = signInWithGoogleButton_locator.getText();
        logger.info("message: " + message);
        if (signInWithGoogleButton_locator.isDisplayed()) {
            actions.moveToElement(signInWithGoogleButton_locator).click().build().perform();
            return message;
        } else
            return null;
    }

    public String isAppleLoginWindowDisplayed(String expected) throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(signInWithAppleButton_locator));
        message = signInWithAppleButton_locator.getText();
        logger.info("message: " + message);
        if (signInWithAppleButton_locator.isDisplayed()) {
            actions.moveToElement(signInWithAppleButton_locator).click().build().perform();
            return message;
        } else
            return null;
    }

    public void getSignInWithGoogleUsernameAndPassword(String userName, String password) {
        library.switchTab(2);
        googleEmailUserName_locator.sendKeys(userName);
        actions.moveToElement(googleNextButton_locator).click().build().perform();
        // googleNextButton_locator.click();
        googlePassword_locator.sendKeys(password);
        googleNextButton_locator.click();
        logger.info("Success sent the credentials");
    }

    public void getSignInWithAppleUsernameAndPassword(String userName, String password) {
        library.switchTab(2);
        appleEmailUserNameTextBo_locator.sendKeys(userName);
        actions.moveToElement(appleNextUserNameButton_locator).click().build().perform();
        // googleNextButton_locator.click();
        applePasswordTextBox_locator.sendKeys(password);
        wait.until(ExpectedConditions.visibilityOf(appleNextUserNameButton_locator));
        appleNextUserNameButton_locator.click();
        // actions.moveToElement(appleNextUserNameButton_locator).click().build().perform();
        logger.info("Success sent the credentials");
    }

    public String isLoggedInGoogleMessage(String expected) {
        message = wrongCredentialAlertGoogleMessage_locator.getText();
        if (wrongCredentialAlertGoogleMessage_locator.isDisplayed() && message.equalsIgnoreCase(expected)) {
            logger.info("Error while sending credentials: ");
            return message;
        } else
            return null;
    }

    public String isLoggedInAppleMessage(String expected) {
        wait.until(ExpectedConditions.visibilityOf(wrongCredentialAlertAppleMessage_locator));
        message = wrongCredentialAlertAppleMessage_locator.getText();
        if (wrongCredentialAlertAppleMessage_locator.isDisplayed() && message.equalsIgnoreCase(expected)) {
            logger.info("Error while sending credentials: ");
            return message;
        } else
            return null;
    }


}
