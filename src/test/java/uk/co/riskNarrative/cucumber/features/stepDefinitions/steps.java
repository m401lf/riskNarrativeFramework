package uk.co.riskNarrative.cucumber.features.stepDefinitions;

import base.BasePage;
import base.BaseTest;
import helper.GenericMethods;
import helper.LoggerHelper;
import helper.assertion.AssertionHelper;
import helper.assertion.VerificationHelper;
import helper.javaScript.JavaScriptHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import pages.*;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class steps extends BaseTest {
    final static Logger log = LoggerHelper.getLogger(steps.class);
    TopMenuNavigationPage naviPage;
    AboutUsPage aboutUsPage;
    IndexPage indexPage;
    CareersPage careersPage;
    JobsPage jobsPage;
    CookieBannerPage cookieBannerPage;
    BasePage basePage;
    GenericMethods gm;

    @Given("I landed on a home page {string}")
    public void i_landed_on_a_home_page(String url) throws IOException {
        naviPage = new TopMenuNavigationPage();
        naviPage = launchApplication(url);
    }

    @When("click on {string} link")
    public void click_careers_link(String linkText) {
        aboutUsPage = PageFactory.initElements(driver, AboutUsPage.class);
        AssertionHelper.updateTestStatus(aboutUsPage.assertAnyLinksInAboutUsPage(linkText));
        careersPage = aboutUsPage.clickCareersLink();
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindowId = it.next();
        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        log.info("Parent Window Id: " + parentWindowId);
    }

    @Then("I tap on {string}")
    public void i_tap_on(String SearchJobsText) {
        careersPage = PageFactory.initElements(driver, CareersPage.class);
        AssertionHelper.updateTestStatus(careersPage.getSearchJobsButtonText().contains(SearchJobsText));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", careersPage.getSearchJobsButton());
    }

    @When("I should be taken to Jobs page as title includes {string}")
    public void i_should_be_taken_to_jobs_page_as_title(String pageTitle) {
        AssertionHelper.updateTestStatus(new VerificationHelper(driver).getCurrentPageTitle().contains(pageTitle));

    }

    @When("I should be taken to Careers page as title includes {string}")
    public void i_should_be_taken_to_careers_page_as_title(String pageTitle) {
        AssertionHelper.updateTestStatus(new VerificationHelper(driver).getCurrentPageTitle().contains(pageTitle));

    }

    @When("I can see in Careers page as follows:")
    public void i_can_see_in_careers_page_as_follows(DataTable dataTable) {
        careersPage = PageFactory.initElements(driver, CareersPage.class);
        AssertionHelper.updateTestStatus(careersPage.getExploreMoreText().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(careersPage.getCareersHeadingText().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(careersPage.getSearchJobsButtonText().contains(dataTable.cell(2, 0)));
    }

    @When("I search for job with a job title {string}")
    public void i_search_for_job_with_a_job_title(String jobTitle) {
        jobsPage = PageFactory.initElements(driver, JobsPage.class);
        jobsPage.inputSearchBox(jobTitle);
        jobsPage.clickSearchButton();
    }

    @Then("I can see the search result count as {string}")
    public void i_can_see_the_search_result_count_as(String searchResult) {
        jobsPage = PageFactory.initElements(driver, JobsPage.class);
        Assert.assertTrue(jobsPage.getNoSearchResultsHeaderText().contains(searchResult));
    }

    @Then("I can see the job search result count displayed in the page is greater than {int}")
    public void i_can_see_the_job_search_result_count_displayed_in_the_page_is_greater_than(Integer jobCount) throws Exception {
        jobsPage = PageFactory.initElements(driver, JobsPage.class);
        Assert.assertTrue(jobsPage.getDisplayedJobsTitlesCountGreaterThanZero() > jobCount);
    }

    @When("I should see Text for many items {string}")
    public void i_should_see_text_for_many_items(String jobTitle) {
        jobsPage = PageFactory.initElements(driver, JobsPage.class);
        Assert.assertTrue(jobsPage.getTextForManySearchResultsItems().contains(jobTitle));

    }

    @When("I can see search results related to the {string}")
    public void i_can_see_search_results_having(String jobTitle) {
        jobsPage = PageFactory.initElements(driver, JobsPage.class);
        Assert.assertTrue(jobsPage.assertSearchResultsForJobTitle(jobTitle));
    }

    @And("I can see search results not related to the {string}")
    public void i_can_see_search_results_not_relating_to_the(String jobTitle) {
        jobsPage = PageFactory.initElements(driver, JobsPage.class);
        Assert.assertFalse(jobsPage.assertJobSearchResultsByJobTitle(jobTitle));
    }


    @Given("I should see the cookie banner")
    public void i_should_see_the_cookie_banner() {
        cookieBannerPage = PageFactory.initElements(driver, CookieBannerPage.class);
        Assert.assertTrue(cookieBannerPage.assertCookieBannerIsDisplayed(), "Cookie Banner is not displayed");
    }

    @Given("I tap on Accept all Cookies")
    public void i_tap_on_accept_all_cookies() throws InterruptedException {
        cookieBannerPage = PageFactory.initElements(driver, CookieBannerPage.class);
        cookieBannerPage.clickAcceptAllCookiesButton();
    }

    @Given("I should not see the cookie banner")
    public void i_should_not_see_the_cookie_banner() {
        Assert.assertEquals(0, driver.findElements(By.id("cookie_banner")).size(), "Web element was present");
    }

    @And("logo is displayed")
    public void logo_is_displayed() {
        basePage = PageFactory.initElements(driver, BasePage.class);
        AssertionHelper.updateTestStatus(basePage.assertLogoIsDisplayed());
    }

    @When("I click {string} link")
    public void i_tap_on_about_us_link(String menuItemText) {
        naviPage = PageFactory.initElements(driver, TopMenuNavigationPage.class);
        naviPage.clickAnItemMatchingTextFromTopMenuLinks(naviPage.getTopMenuList(), menuItemText);

    }

    @When("I should see About Us page links as follows:")
    public void i_should_see_and_other_links_as_follows(DataTable dataTable) {
        AboutUsPage aboutUsPage = PageFactory.initElements(driver, AboutUsPage.class);
        AssertionHelper.updateTestStatus(aboutUsPage.getAboutUsTitlesList().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(aboutUsPage.getAboutUsTitlesList().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(aboutUsPage.getAboutUsTitlesList().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(aboutUsPage.getAboutUsTitlesList().contains(dataTable.cell(3, 0)));
        AssertionHelper.updateTestStatus(aboutUsPage.getAboutUsTitlesList().contains(dataTable.cell(4, 0)));
        AssertionHelper.updateTestStatus(aboutUsPage.getAboutUsTitlesList().contains(dataTable.cell(5, 0)));
        AssertionHelper.updateTestStatus(aboutUsPage.getAboutUsTitlesList().contains(dataTable.cell(6, 0)));
        AssertionHelper.updateTestStatus(aboutUsPage.getAboutUsTitlesList().contains(dataTable.cell(7, 0)));
        gm = new GenericMethods(driver);
        boolean status = gm.isElementPresent("/html/body/header/div/div/div/nav/div/div/div[2]/div/div/ul/li[4]/ul/li/div/div/div/div/div/div/h4", "xpath");
        System.out.println(status);
        AssertionHelper.updateTestStatus(status);
    }

    @When("I should see {string} and {int} other links")
    public void i_should_see_and_other_links(String aboutUsText, int linkCount) {
        AboutUsPage aboutUsPage = PageFactory.initElements(driver, AboutUsPage.class);
        AssertionHelper.updateTestStatus(aboutUsPage.getAboutUsText().contains(aboutUsText));
        Assert.assertEquals(aboutUsPage.getAllLinksCount(), linkCount);
    }

    @When("I tap {string} link in top menu page")
    public void i_tap_link_in_top_menu_page(String menuItemText) {
        naviPage = PageFactory.initElements(driver, TopMenuNavigationPage.class);
        naviPage.clickAnItemMatchingTextFromTopMenuLinks(naviPage.getTopMenuList(), menuItemText);
    }

    @Then("I can see page heading as {string} and {int} other links")
    public void i_can_see_page_heading_as_industries(String industriesTitle, int linksCount) {
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        AssertionHelper.updateTestStatus(indexPage.getIndustriesText().contains(industriesTitle));
        AssertionHelper.updateTestStatus(indexPage.getIndustriesLinksCount() == linksCount);
    }

    @Then("Industries Sub links are displayed as follows:")
    public void industries_and_sub_links_are_displayed_as_follows(DataTable dataTable) {
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        AssertionHelper.updateTestStatus(indexPage.getIndustriesTitlesList().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(indexPage.getIndustriesTitlesList().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(indexPage.getIndustriesTitlesList().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(indexPage.getIndustriesTitlesList().contains(dataTable.cell(3, 0)));

    }

    @Then("Industries Sub links are present")
    public void industries_and_sub_links_are_present() {
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        AssertionHelper.updateTestStatus(indexPage.assertIndustriesTitlesArePresent("Financial Services"));
        AssertionHelper.updateTestStatus(indexPage.assertIndustriesTitlesArePresent("Insurance"));
        AssertionHelper.updateTestStatus(indexPage.assertIndustriesTitlesArePresent("Life and Pensions"));
        AssertionHelper.updateTestStatus(indexPage.assertIndustriesTitlesArePresent("Corporations and Non-Profits"));
    }

    @Then("Financial Services Sub title links are present")
    public void financial_services_sub_title_links_are_present() {
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        AssertionHelper.updateTestStatus(indexPage.assertFinancialServicesItemsPresent().get(0).isDisplayed());

    }

    @When("I tap {string} link Industries")
    public void i_tap_on_financial_services_industries_links(String industryName) {
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        AssertionHelper.updateTestStatus(indexPage.getFinancialServicesLinkText().equalsIgnoreCase(industryName));
        indexPage.clickElementInIndustriesLink(industryName);

    }

    @Then("I can see {string} and {int} red links are displayed")
    public void i_should_see_seven_links_are_displayed(String selectIndustry, int linkCount) {
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        AssertionHelper.updateTestStatus(indexPage.getSelectIndustryText().equalsIgnoreCase(selectIndustry));
        AssertionHelper.updateTestStatus(indexPage.getFinancialServicesLinksCount() == linkCount);
    }

    @Then("I should see red links are displayed as follows:")
    public void i_should_see_red_links_are_displayed_as_follows(DataTable dataTable) {
        indexPage = PageFactory.initElements(driver, IndexPage.class);
        AssertionHelper.updateTestStatus(indexPage.getFinancialServicesList().contains(dataTable.cell(0, 0)));
        AssertionHelper.updateTestStatus(indexPage.getFinancialServicesList().contains(dataTable.cell(1, 0)));
        AssertionHelper.updateTestStatus(indexPage.getFinancialServicesList().contains(dataTable.cell(2, 0)));
        AssertionHelper.updateTestStatus(indexPage.getFinancialServicesList().contains(dataTable.cell(3, 0)));
        AssertionHelper.updateTestStatus(indexPage.getFinancialServicesList().contains(dataTable.cell(4, 0)));
        AssertionHelper.updateTestStatus(indexPage.getFinancialServicesList().contains(dataTable.cell(5, 0)));
        AssertionHelper.updateTestStatus(indexPage.getFinancialServicesList().contains(dataTable.cell(6, 0)));
    }

    @Then("{string} is displayed")
    public void cookie_preference_center_is_displayed(String headingText) {
        cookieBannerPage = PageFactory.initElements(driver, CookieBannerPage.class);
        Assert.assertEquals(cookieBannerPage.getCookiePreferenceCenterText(), headingText);
    }

    @When("I click on {string} in home page")
    public void i_click_on_cookies_settings_in_home_page(String cookieSettingsText) throws IOException {
        cookieBannerPage = PageFactory.initElements(driver, CookieBannerPage.class);
        getScreenshot(cookieBannerPage.getCookieBanner());
        AssertionHelper.updateTestStatus(cookieBannerPage.getCookieSettingsButtonText().contains(cookieSettingsText));
        cookieBannerPage.clickCookieSettingsButton();
    }

    @When("I should see {string} is {string} by default")
    public void i_should_see_strictly_necessary_cookies_is_always_active_by_default(String categoryName, String cookieValue) {
        cookieBannerPage = PageFactory.initElements(driver, CookieBannerPage.class);
        new JavaScriptHelper(driver).scrollIntoView(cookieBannerPage.getStrictlyNecessaryCookies());
        cookieBannerPage.assertItemDisplayedFromCategoryHeaderList(categoryName);
        AssertionHelper.updateTestStatus(cookieBannerPage.getAlwaysActiveText().contains(cookieValue));
    }

    @When("I click plus icon in {string} from Manage Consent Preferences")
    public void i_click_plus_icon_from_consent_preferences(String categoryName) {
        cookieBannerPage = PageFactory.initElements(driver, CookieBannerPage.class);
        cookieBannerPage.clickAccordionPlusMinusList(categoryName);
    }

    @When("I can see minus icon and switch nob should not be displayed in {string}")
    public void i_can_see_minus_icon_and_switch_nob_should_not_be_displayed(String categoryName) {
        cookieBannerPage = PageFactory.initElements(driver, CookieBannerPage.class);
        cookieBannerPage.assertPlusOrMinusButtonIsDisplayed(categoryName);
        cookieBannerPage.assertSwitchNobIsDisplayed(categoryName);
    }

    @Then("I click on {string} button in home page")
    public void i_click_accept_all_cookies_button_in_home_page(String acceptAllCookies) {
        cookieBannerPage = PageFactory.initElements(driver, CookieBannerPage.class);
        existsElement(cookieBannerPage.getCookieBanner());
        AssertionHelper.updateTestStatus(cookieBannerPage.getAcceptAllCookiesButtonText().contains(acceptAllCookies));
        cookieBannerPage.clickAcceptAllCookiesButton();
    }

    @Then("I tap on {string} button")
    public void i_tap_on_confirm_my_choices_button(String confirmMyChoiceButtonText) {
        cookieBannerPage = PageFactory.initElements(driver, CookieBannerPage.class);
        AssertionHelper.updateTestStatus(cookieBannerPage.getConfirmMyChoiceButtonText().contains(confirmMyChoiceButtonText));
        cookieBannerPage.clickConfirmMyChoicesButton();
    }

    @When("I click plus icon and switch nob from category {string}")
    public void i_click_plus_icon_and_switch_nob_from_Category(String categoryCookiesName) {
        cookieBannerPage = PageFactory.initElements(driver, CookieBannerPage.class);
        cookieBannerPage.clickAccordionPlusMinusList(categoryCookiesName);
        cookieBannerPage.clickSwitchNobs(categoryCookiesName);
    }

    @When("I can see minus icon and switch nob turns green color in {string}")
    public void i_can_see_minus_icon_and_switch_nob_turns_green_color(String categoryName) {
        cookieBannerPage = PageFactory.initElements(driver, CookieBannerPage.class);
        cookieBannerPage.assertPlusOrMinusButtonIsDisplayed(categoryName);
        cookieBannerPage.assertSwitchNobIsDisplayed(categoryName);
    }

    @When("I click {string} Cookies button")
    public void i_click_allow_all_cookies_button(String allowAllCookiesText) {
        cookieBannerPage = PageFactory.initElements(driver, CookieBannerPage.class);
        AssertionHelper.updateTestStatus(cookieBannerPage.getAllowAllButtonText().contains(allowAllCookiesText));
        cookieBannerPage.clickAllowAllButton();
    }

    @When("I should see Showing {string} in Job page")
    public void i_should_see_showing_result_in_job_page(String resultText) {
        jobsPage = PageFactory.initElements(driver, JobsPage.class);
        AssertionHelper.updateTestStatus(jobsPage.getStatisticsResultText().contains(resultText));
    }


}
