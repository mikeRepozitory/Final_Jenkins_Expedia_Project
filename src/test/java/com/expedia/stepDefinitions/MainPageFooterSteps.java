package com.expedia.stepDefinitions;

import com.expedia.pages.CarsPage;
import com.expedia.pages.MainPageFooterPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import static com.expedia.base.Hook.driver;

public class MainPageFooterSteps {

    MainPageFooterPage mainPageFooterPage = new MainPageFooterPage(driver);
    String linksString = null;
    String Expected = null;

    private static final org.apache.log4j.Logger logger = Logger.getLogger(MainPageFooterSteps.class);


    @Given("user is on main page")
    public void userIsOnMainPage() {
        linksString = mainPageFooterPage.getFooterCompany_links("About");
        Assert.assertEquals(linksString, "https://www.expediagroup.com/home/default.aspx");
        logger.info("About Passed");
        linksString = mainPageFooterPage.getFooterCompany_links("Jobs");
        Assert.assertEquals(linksString, "https://lifeatexpediagroup.com/");
        logger.info("Jobs Passed");
        linksString = mainPageFooterPage.getFooterCompany_links("List your property");
        Assert.assertEquals(linksString,
                "https://apps.expediapartnercentral.com/en_US/list?utm_medium=referral&utm_source=wwwexpediacom-en_US&utm_campaign=Brand.DTI&utm_contentewd=footer-btn&siteId=1&tpid=1&eapid=0&langId=1033&utm_term=Brand.DTI&lasttouchMktgcode=Brand.DTI");
        logger.info("List your property Passed");
        linksString = mainPageFooterPage.getFooterCompany_links("Partnerships");
        Assert.assertEquals(linksString, "https://www.expediagroup.com/partner-with-us/default.aspx");
        logger.info("Partnerships Passed");
        linksString = mainPageFooterPage.getFooterCompany_links("Newsroom");
        Assert.assertEquals(linksString, "https://newsroom.expedia.com/");
        logger.info("Newsroom Passed");
        linksString = mainPageFooterPage.getFooterCompany_links("Investor Relations");
        Assert.assertEquals(linksString, "https://www.expediagroup.com/investors/investors-overview/default.aspx");
        logger.info("Investor Relations Passed");
        linksString = mainPageFooterPage.getFooterCompany_links("Advertising");
        Assert.assertEquals(linksString, "https://www.expediagroup.com/investors/investors-overview/default.aspx");
        logger.info("Advertising Passed");
    }


    @Then("user scrolls all the way to the bottom")
    public void userScrollsAllTheWayToTheBottom() {
    }

    @When("user clicks on the company links the corespoding page should open as per requirement docs")
    public void userClicksOnTheCompanyLinksTheCorespodingPageShouldOpenAsPerRequirementDocs() {


    }

    @When("user clicks on the company Visible Text {string} the corresponding {string} page should open as per requirement docs")
    public void user_clicks_on_the_company_visible_text_the_corresponding_page_should_open_as_per_requirement_docs(String string, String string2) {
        linksString = mainPageFooterPage.getFooterCompany_links(string);
        Assert.assertEquals(linksString, string2);
        logger.info(string + ": Passed");
    }


}
