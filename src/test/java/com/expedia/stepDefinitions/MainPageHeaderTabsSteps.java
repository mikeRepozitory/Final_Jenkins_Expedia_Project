package com.expedia.stepDefinitions;

import com.expedia.pages.AllNavTabsPage;
import com.expedia.pages.MainPageHeaderTabsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import static com.expedia.base.Hook.driver;

public class MainPageHeaderTabsSteps {
    MainPageHeaderTabsPage mainPageHeaderTabsPage = new MainPageHeaderTabsPage(driver);

    @Given("use is on main page")
    public void useIsOnMainPage() {
        mainPageHeaderTabsPage.getEnglishNavigation_Tab();
    }

    @Then("user clicks on English and a new popUp window should be displayed {string}")
    public void userClicksOnEnglishAndANewPopUpWindowShouldBeDisplayed(String expected) {
        boolean isDisplayed = mainPageHeaderTabsPage.isEnglishPopUpWindowDisplayed();
        System.out.println("isDisplayed: " + isDisplayed);
        Assert.assertTrue(isDisplayed);
    }


    @Then("user selects United Kingdom {string} Region")
    public void userSelectsUnitedKingdomRegion(String region) {
        String actual = mainPageHeaderTabsPage.getLanguageDropDownPopUpRegion(region);
        Assert.assertEquals(region, actual);

    }


    @And("use select  english {string} language")
    public void useSelectEnglishLanguage(String language) {
        String actual = mainPageHeaderTabsPage.getLanguageDropDownPopUp(language);
        Assert.assertEquals(language, actual);
    }


    @Then("clicks on {string}  button")
    public void clicksOnButton(String arg0) {
    }


}
