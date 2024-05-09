package uk.co.riskNarrative.cucumber.features.stepDefinitions;

import base.BasePage;
import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;

public class commonSteps extends BaseTest {

    @Then("I close browser")
    public void i_close_browser() {
        tearDown();

    }

    @Given("I should see page title {string} and page url {string}")
    public void i_should_see_page_title_and_page_url(String pageTitle, String pageUrl) throws IOException {
        BasePage basePage = PageFactory.initElements(driver, BasePage.class);
        Assert.assertEquals(basePage.getCurrentPageTitle(), pageTitle);
        Assert.assertEquals(basePage.getCurrentPageUrl(), pageUrl);
    }

}