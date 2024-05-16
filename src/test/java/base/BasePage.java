package base;

import helper.*;
import helper.assertion.VerificationHelper;
import io.cucumber.datatable.DataTable;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.GlobalVars;

import java.time.Duration;
import java.util.*;

import static base.BaseTest.driver;

public class BasePage {

    final static Logger log = LoggerHelper.getLogger(BasePage.class);
    @FindBy(how = How.ID, using = "heading")
    protected WebElement heading;
    // save_and_Continue, save_continue
    @FindBy(how = How.ID, using = "save_continue")
    protected WebElement saveAndContinueButton;
    @FindBy(how = How.ID, using = "back_to_manage_users")
    protected WebElement goBackToManageUsersBtn;
    @FindBy(how = How.ID, using = "save_come_back")
    protected WebElement saveAndComeBackLaterLink;
    @FindBy(how = How.CLASS_NAME, using = "nhsuk-back-link__link")
    protected WebElement backButton;
    @FindBy(how = How.CLASS_NAME, using = "nhsuk-back-link__link")
    protected WebElement goBackLink;
    @FindBy(how = How.ID, using = "candidate_sign_out")
    protected WebElement candidateSignOut;
    @FindBy(how = How.ID, using = "helpLink")
    protected WebElement helpLink;
    @FindBy(how = How.ID, using = "helpText")
    protected WebElement helpText;
    @FindBy(css = ".//*")
    private List<WebElement> allPageElements;
    @FindBy(css = "a.navbar-brand")
    private WebElement logo;
    @FindBy(css = "a")
    private WebElement aTag;
    @FindBy(how = How.CLASS_NAME, using = "active")
    private WebElement loginButton;
    @FindBy(how = How.ID, using = "status_DRAFT")
    private WebElement applicationStatus;
    @FindBy(how = How.ID, using = "reference_number")
    private WebElement referenceNumber;
    @FindBy(how = How.ID, using = "create_employer")
    private WebElement addEmployerBtn;
    @FindBy(how = How.ID, using = "continue")
    private WebElement addEmployerAndContinue;
    @FindBy(how = How.ID, using = "save_come_back")
    private WebElement returnToPreEmpChecklist;
    @FindBy(how = How.ID, using = "userNameOnHeader")
    private WebElement accountname;
    @FindBy(how = How.ID, using = "employer_sign_out")
    private WebElement signout;
    @FindBy(how = How.ID, using = "advertising")
    private WebElement topNavAdvert;
    @FindBy(how = How.ID, using = "home")
    private WebElement topNavHome;
    @FindBy(how = How.ID, using = "sub_heading")
    private WebElement sub_heading;
    @FindBy(how = How.ID, using = "continue")
    private WebElement btn_changeAndContinue;
    @FindBy(how = How.ID, using = "continue")
    private WebElement btn_Continue;
    @FindBy(how = How.ID, using = "continue-button")
    private WebElement continueButton;
    @FindBy(how = How.ID, using = "submit")
    private WebElement continueBtn;
    @FindBy(how = How.LINK_TEXT, using = "Back")
    private WebElement lnk_back;
    @FindBy(how = How.LINK_TEXT, using = "back_to_your_job_adverts")
    private WebElement btn_goToYourJobAdverts;
    @FindBy(how = How.ID, using = "back_to_your_job_adverts")
    private WebElement btn_continue;
    @FindBy(how = How.ID, using = "back_to_job_listings")
    private WebElement goBackToJobListings;
    @FindBy(how = How.ID, using = "back_to_dashboard")
    private WebElement goBackToDashBoard;
    @FindBy(how = How.ID, using = "go_back_to_dashboard")
    private WebElement goBackToYourDashBoard;
    @FindBy(how = How.ID, using = "return_to_dashboard")
    private WebElement returnToDashBoardButton;
    @FindBy(how = How.ID, using = "employer_sign_out")
    private WebElement lnk_signOut;
    @FindBy(how = How.ID, using = "candidate_sign_out")
    private WebElement candidate_lnk_signOut;
    @FindBy(how = How.ID, using = "candidate_sign_in")
    private WebElement candidate_lnk_signIn;
    @FindBy(how = How.ID, using = "employer_name")
    private WebElement employerName;
    @FindBy(how = How.XPATH, using = "//a[text()='View']")
    private WebElement viewLink;

    /*
     * @FindBy(how = How.CLASS_NAME, using = "nhsuk-error-summary_list") private
     * WebElement err_Heading1;
     */

    // *************** Radio Buttons ************ //
    @FindBy(how = How.XPATH, using = "//a[text() = 'feedback']")
    private WebElement feedbackLink;
    // At Risk Marker
    @FindBy(how = How.CSS, using = "strong.status-box-at-risk")
    private List<WebElement> atRiskApplicants;
    @FindBy(how = How.CSS, using = "input.nhsuk-radios__input")
    private List<WebElement> radioBtns;
    @FindBy(how = How.CSS, using = "label.nhsuk-radios__label")
    private List<WebElement> radioBtnsLabels;
    // *************** Input labels ************ //
    @FindBy(how = How.CSS, using = "label.nhsuk-label")
    private List<WebElement> inputLabels;
    // *************** Single ************** //
    @FindBy(how = How.ID, using = "error-summary-title")
    private WebElement err_Heading;
    @FindBy(how = How.CSS, using = "ul.nhsuk-error-summary__list > li")
    private WebElement errorMsg;
    @FindBy(how = How.CSS, using = "div.nhsuk-error-summary__body > ul > li")
    private WebElement pageErrorMsg;
    // *************** multiple ************** //
    @FindBy(how = How.CSS, using = "ul.nhsuk-error-summary__list > li")
    private List<WebElement> errorMsgs;
    @FindBy(how = How.CSS, using = "div.nhsuk-error-summary__body > ul > li")
    private List<WebElement> pageErrorMsgs;
    @FindBy(how = How.ID, using = "error-summary-heading-example-2")
    private WebElement errorSummaryHeading;

    // ********* Footer links **************
    @FindBy(how = How.ID, using = "error-summary-description")
    private WebElement errorSummaryDescription;
    @FindBy(how = How.ID, using = "employer_sign_out")
    private WebElement lnk_employer_signOut;
    @FindBy(how = How.ID, using = "privacy-policy")
    private WebElement privacyPolicyLink;
    @FindBy(how = How.ID, using = "privacy")
    private WebElement candidatePrivacyPolicyLink;
    // @FindBy(how = How.XPATH, using = "//a[text()='Terms and conditions']")
    @FindBy(how = How.ID, using = "terms-conditions")
    private WebElement termsandconditionsLink;
    @FindBy(how = How.ID, using = "acceptableUse")
    private WebElement canTermsAndConditionsLink;
    @FindBy(how = How.XPATH, using = "//a[text()='Cookies']")
    private WebElement cookiesLink;
    @FindBy(how = How.CLASS_NAME, using = "nhsuk-details__summary-text")
    private WebElement googleAnalyticsLink;

    @FindBy(how = How.ID, using = "essential-cookies")
    private WebElement essentialCookiesLink;

    @FindBy(how = How.LINK_TEXT, using = "Find out how to manage cookies.")
    private WebElement manageCookiesLink;

    @FindBy(how = How.LINK_TEXT, using = "privacy policy")
    private WebElement policyPrivacyLink;

    @FindBy(how = How.CLASS_NAME, using = "nhsuk-radios__item")
    private WebElement useGoogleAnalyticsRadioBtn;

    @FindBy(how = How.ID, using = "google-analytics-false")
    private WebElement doNotUseGoogleAnalyticsRadioBtn;

    @FindBy(how = How.CLASS_NAME, using = "nhsuk-radios__item")
    private List<WebElement> selectCookiePreference;

    @FindBy(how = How.ID, using = "save")
    private WebElement saveBtn;

    @FindBy(how = How.ID, using = "google-analytics-true")
    private WebElement useGoogleAnalyticsBtn;

    @FindBy(how = How.ID, using = "analytics_enabled-true")
    private WebElement candidateUseGoogleAnalyticsBtn;

    @FindBy(how = How.ID, using = "google-analytics-false")
    private WebElement doNotUseGoogleAnalyticsBtn;

    @FindBy(how = How.ID, using = "analytics_enabled-false")
    private WebElement candidateDoNotUseGoogleAnalyticsBtn;

    @FindBy(how = How.CLASS_NAME, using = "nhsuk-details__summary-text")
    private WebElement findMoreAboutGoogleAnalyticsCookiesLink;

    @FindBy(how = How.ID, using = "details-content-0")
    private WebElement detailsGoogleAnalytics;

    @FindBy(how = How.ID, using = "details-content-1")
    private WebElement detailsEssentialCookies;

    //	==============cookies banner==================
    @FindBy(how = How.ID, using = "cookie-banner")
    private WebElement cookieBanner;

    @FindBy(how = How.ID, using = "accept-cookies")
    private WebElement acceptAnalyticsButton;

    @FindBy(how = How.ID, using = "reject-cookies")
    private WebElement rejectAnalyticsButton;

    @FindBy(how = How.ID, using = "cookies-info-link")
    private WebElement readMoreAboutCookiesLink;

    @FindBy(how = How.ID, using = "change-cookies-settings")
    private WebElement changeCookiesSettings;

    @FindBy(how = How.ID, using = "dismiss-cookie-messages")
    private WebElement hideCookieMessage;

    @FindBy(how = How.ID, using = "accepted-cookies-message")
    private WebElement acceptedCookiesMessage;

    @FindBy(how = How.ID, using = "rejected-cookies-message")
    private WebElement rejectedCookiesMessage;

    @FindBy(how = How.ID, using = "analytics_enabled-true")
    private WebElement useGoogleAnalyticsCookieBtn;

    @FindBy(how = How.LINK_TEXT, using = "Find out how to manage cookies.")
    private WebElement findOutHowToManageCookiesLink;

    @FindBy(how = How.ID, using = "accept-cookies")
    private List<WebElement> acceptCookies;

    public BasePage() {

    }

    public WebElement getLogo() {
        return logo;

    }

    public List<WebElement> getAllElements() {
        return allPageElements;

    }

    public void getRectHeightAndWidthOfAnElement(WebElement element) {
        Point p = element.getLocation();
        log.info(p.getX());
        log.info(p.getY());
        Rectangle r = element.getRect();
        log.info(r.getX());
        log.info(r.getY());
    }

    public boolean checkForTitle(WebDriver driver, String title) {
        log.info(title);
        if (title == null || title.isEmpty())
            throw new IllegalArgumentException(title);
        return driver.getTitle().trim().contains(title);
    }

    public boolean assertLogoIsDisplayed() {
        return logo.isDisplayed();

    }

    public String getLogoText() {
        return logo.getText();

    }

    public void clickLogoImage() {
        logo.click();

    }

    public String getTitle() {
        log.info("Title is: " + driver.getTitle());
        return new VerificationHelper(driver).getCurrentPageTitle();
    }


    public String getCurrentPageTitle() {
        log.info("Title is: " + driver.getTitle());
        return new VerificationHelper(driver).getCurrentPageTitle();
    }

    public String getCurrentPageUrl() {
        log.info("BasePage Url is: " + driver.getCurrentUrl());
        return new VerificationHelper(driver).getCurrentPageUrl();
    }

    public void acceptCookie() {
        if (acceptCookies.size() > 0) {
            driver.findElement(By.id("accept-cookies")).click();
        }
    }


    public void assertAcceptedCookiesMessageIsVisible() {
        Assert.assertTrue(acceptedCookiesMessage.isDisplayed());
    }


    public void assertCookieBannerIsNotVisible() {
        Assert.assertEquals(0, driver.findElements(By.id("cookie_banner")).size(), "Web element was present");
    }

    public void assertCookieBannerIsVisible() {
        Assert.assertTrue(cookieBanner.isDisplayed());

    }

    public void assertCookieIsNotPresent(String cookieName) {
        Assert.assertNull(driver.manage().getCookieNamed(cookieName));

    }

    public void assertCookieIsPresent(String seen_cookie_message, String cookieName) {
        Cookie cookie = driver.manage().getCookieNamed(cookieName);
        Assert.assertNotNull(cookie);
        Assert.assertEquals("The cookie value was not expected", cookie.getValue());

    }

    public void assertCookiesRadioButtons(DataTable dataTable) {
        List<String> data = dataTable.asList();

        for (int i = 0; i < data.size(); i++) {
            Assert.assertEquals("Radio Button did not match", data.get(i), selectCookiePreference.get(i).getText());
        }
    }

    public void assertDoNotUseGoogleAnalyticsRadioButtonIsDisplayed() {
        Assert.assertEquals("Do not use google analytics Radio button not displayed",
                doNotUseGoogleAnalyticsRadioBtn.isDisplayed());
    }

    public void assertElementDoesNotExist(By locator) {
        try {
            getElement(locator);
            Assert.assertTrue(false, "This element should not exist.");
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }

    public void assertElementExist(By locator) {
        try {
            getElement(locator);
        } catch (NoSuchElementException e) {
            Assert.assertTrue(false, "This element should exist.");
        }
    }

    public void assertTextDisplayedOnThePage(String str) {
        assertElementExist(By.xpath("//*[normalize-space(.)='" + str + "']"));
    }


    public void assertGoBackLinkIsDisplayed() {
        Assert.assertTrue(goBackLink.isDisplayed(), "Go Back Link is not displayed");
    }

    public void assertGoogleAnalyticsLinkIsDisplayed() {
        Assert.assertTrue(googleAnalyticsLink.isDisplayed(), "Google analytics is not displayed");
    }

    public void assertHeaderIsDisplayedInEnglish() throws InterruptedException {
        Assert.assertEquals("Sign In", heading.getText());
    }

    public void assertHeadingErrorIdIsDisplayed() {
        Assert.assertTrue(err_Heading.isDisplayed(), "Heading error ID is not displayed");
    }

    public void assertHeadingIsDisplayed() {
        Assert.assertTrue(heading.isDisplayed(), "Heading not displayed");
    }

    public void assertIfSignOutButtonExists() {
        Assert.assertEquals("Sign Out", signout.getText());
    }

    // ********* Input Label names ********* //

    public void assertInputLabel(int i, String labelName) {
        Assert.assertEquals("Input label not matching", labelName, inputLabels.get(i).getText());
    }

    public void assertManageCookiesPage() throws Exception {
        NavigateToNewTab.navigateToNewTab();

    }

    public void assertNoRadioButtonSelected(List<WebElement> elements) {
        Assert.assertTrue(elements.get(1).isSelected(), "Radio button not selected");
    }

    public void assertOnElementIsDisplayed(WebElement element) {
        if (driver.getCurrentUrl().contains("employer/new/check/")) {
            Assert.assertTrue(element.isDisplayed(), "Element is not displayed ");
        } else {

            Assert.assertTrue(element.isDisplayed(), "Add Employer button is not displayed ");
        }
    }


    public void assertOnElementIsNotDisplayed(List<WebElement> elements) {
        Assert.assertTrue(elements.size() == 0, "Element is displayed");
    }


    public void assertOnCorrectCookiesPreference(String userSelection) {
        ScrollPage.scrollToViewElement(driver, "google-analytics-true");
        Assert.assertTrue(useGoogleAnalyticsBtn.isSelected(), "Use google analytics Radio button not selected");
    }

    public void assertOnCorrectCandidateCookiesPreference(String userSelection) {
        Assert.assertTrue(candidateUseGoogleAnalyticsBtn.isSelected());
    }

    public void assertOnCorrectDefaultCookiesPreference(String userSelection) {
        ScrollPage.scrollToViewElement(driver, "google-analytics-false");
        Assert.assertTrue(doNotUseGoogleAnalyticsBtn.isSelected(), "Do not use google analytics Radio button not selected");
    }

    public void assertOnErrorMessage(String expectedErrorMsg) {
        Assert.assertEquals("Error message mismatch", expectedErrorMsg, errorMsg.getText());
    }

    public void assertOnErrorMessages(DataTable dataTable) {
        List<String> expectedErrorMsgs = dataTable.asList();
        for (int i = 0; i < errorMsgs.size(); i++) {
            Assert.assertEquals("Error Message did not match", expectedErrorMsgs.get(i), errorMsgs.get(i).getText());
        }
    }

    public void assertOnErrorMessages(int i) {
        Assert.assertTrue(errorMsgs.get(i).isDisplayed(), "Error message " + (i + 1) + " is not displayed");
    }

    public void assertOnErrorMessagesForFieldsFromTable(List<Map<String, String>> datatable) {
        for (Map<String, String> data : datatable) {
            WebElement fieldInputTextBox = driver.findElement(By.id(data.get("Field")));
            fieldInputTextBox.clear();
            fieldInputTextBox.sendKeys(data.get("invalidValue"));
            saveAndContinueButton.click();
            WebElement errorTextElement = driver
                    .findElement(By.id(data.get("ErrorField")));
            Assert.assertEquals(data.get("ErrorMessage"), errorTextElement.getText());

        }

    }

    public void assertOnErrorMessagesOnPage(DataTable dataTable) {
        List<String> expectedErrorMsgs = dataTable.asList();
        for (int i = 0; i < expectedErrorMsgs.size(); i++) {
            Assert.assertEquals("Error message did not match", expectedErrorMsgs.get(i),
                    pageErrorMsgs.get(i).getText());
        }

    }

    public void assertOnErrorMessagesOnPage(int i) {
        Assert.assertTrue(pageErrorMsgs.get(i).isDisplayed(), "Error message " + (i + 1) + " is not displayed");
    }

    public void assertOnHeadingText(String headingText) {
        String newHeading = null;
        if (headingText.contains("Applications in progress")) {
            newHeading = driver.findElement(By.id("applications_in_progress")).getText()
                    .trim();
        } else {
            //Benjamin Azeta
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("heading")));
            newHeading = driver.findElement(By.id("heading")).getText().trim();
        }
        Assert.assertTrue(newHeading.contains(headingText.trim()));
    }

    public void assertOnSecondaryHeadingText(String expectedSecondaryHeading) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("heading-text")));
        String actualSecondaryHeading = driver.findElement(By.cssSelector("flow-heading")).getText().trim();

        Assert.assertTrue(actualSecondaryHeading.equals(expectedSecondaryHeading.trim()));
    }

    public void assertOnOrderOfWebElementsByListOrder(List<String> elementIds) {
        String idOfParentElement = elementIds.get(0);
        WebElement parentWebElement = driver.findElement(By.id(idOfParentElement));
        List<WebElement> childWebElements = parentWebElement.findElements(By.xpath(".//*"));
        WebElementOrderChecker webElementOrderChecker = new WebElementOrderCheckerImpl(childWebElements);
        List<String> childIds = getIdListOfExpectedChildElements(elementIds);
    }

    public void assertOnPageErrorMessage(String expectedErrorMsg) {
        Assert.assertEquals("Error message mismatch", expectedErrorMsg, pageErrorMsg.getText().trim());
    }

    public void assertOnReferenceNumber() {
        Assert.assertTrue(referenceNumber.isDisplayed(), "Reference Number is not displayed ");
    }

    public void assertOnSubHeadingText(String subHeadingText) {
        WebElement subHeading = driver.findElement(By.id("sub_heading"));
        Assert.assertEquals(subHeadingText, subHeading.getText());
    }

    public void assertOnSubHeadingTextt(String subHeadingText) {
        WebElement subHeading = driver.findElement(By.id("error-summary-title"));
        Assert.assertEquals(subHeadingText, subHeading.getText());
    }

    public void assertOnUsername() {
        // The below will change based on the account name we create
        Assert.assertEquals("Signed in as Admin Surname", accountname.getText());
    }

    public void assertPolicyPrivacyLinkIsDisplayed() {
        Assert.assertTrue(policyPrivacyLink.isDisplayed(), "Policy privacy is not displayed");
    }

    // ********* Radio buttons ********* //

    public void assertRadioButtonsLabel(int i, String labelName) {
        Assert.assertTrue(radioBtnsLabels.get(i).getText().contains(labelName), "Radio button label not matching");
    }

    public void assertRadioButtonsUnchecked() {
        for (int i = 0; i < radioBtns.size(); i++) {
            Assert.assertFalse(radioBtns.get(i).isSelected(), (i + 1) + " Radio button is selected by default ");
        }
    }

    public void assertRejectedCookiesMessageIsNotVisible() {
        Assert.assertEquals(0, driver.findElements(By.id("rejected-cookies-message")).size(), "Web element was present");
    }

    public void assertRejectedCookiesMessageIsVisible() {
        Assert.assertTrue(rejectedCookiesMessage.isDisplayed());

    }

    public void assertTextShouldNotBeDisplayedInHeadingText(String headingText) {
        WebElement newHeading = driver.findElement(By.id("heading"));
        Assert.assertNotEquals(headingText, newHeading.getText());
    }

    public void assertUseGoogleAnalyticsRadioButtonIsDisplayed() {
        Assert.assertTrue(useGoogleAnalyticsRadioBtn.isDisplayed(), "Use google analytics Radio button not displayed");
    }

    public void assertWebElementNotDisplayedInCurrentPage(By locator) {
        try {
            driver.findElement(locator).isDisplayed();
        } catch (NoSuchElementException e) {
            Assert.assertTrue(e.getMessage().contains("no such element: Unable to locate element:"));
        }
    }

    public void assertYesRadioButtonSelected() {
        Assert.assertTrue(radioBtns.get(0).isSelected(), "Radio button not selected");
    }

    public void BackButtonIsDisplayed() {
        Assert.assertTrue(lnk_back.isEnabled());
    }

    public void clickAcceptAnalytics() {
        acceptAnalyticsButton.click();
    }

    public void clickAddEmployerAndContinueBtn() {
        addEmployerAndContinue.click();
    }

    public void clickAddEmployerBtn() {

        addEmployerBtn.click();
    }

    public void clickCandidatePrivacyPolicyLink() {
        candidatePrivacyPolicyLink.click();
    }

    public void clickCanTermsAndConditionsLink() {
        canTermsAndConditionsLink.click();
    }

    public void clickChangeCookiesSettingsLink() {
        changeCookiesSettings.click();
    }

    public void clickContinueButton() {
        continueButton.click();
    }

    public void clickCookiesLink(WebElement element) {
        try {
            ScrollPage.scrollToView(element);
        } catch (Exception e) {
            e.printStackTrace();
        }
        element.click();
    }

    public void clickHideCookieMessage() {
        hideCookieMessage.click();
    }

    public void clickNavHome() {
        topNavHome.click();
    }

    public void clickNavJobAdvertRef() {
        topNavAdvert.click();
    }

    public void clickOnBackButton() {
        backButton.click();
    }

    public void clickOnBrowserBackButton() {
        driver.navigate().back();
    }

    public void clickOnCandidateSignInLink() {
        candidate_lnk_signIn.click();
    }

    // ************** cookies section ******** //

    public void clickOnCandidateSignOutLink() {
        candidate_lnk_signOut.click();
    }

    public void clickOnCandidateUseGoogleAnalyticsCookiesButton() {
        ScrollPage.scrollToViewElement(driver, "analytics_enabled-true");
        useGoogleAnalyticsCookieBtn.click();
        saveBtn.click();
        driver.findElement(By.id("candidate_sign_in")).click();
    }

    public void clickOnChangeAndContinueButton() {
        btn_changeAndContinue.click();
    }

    public void clickOnContinueBtn() {
        continueBtn.click();
    }

    public void clickOnContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue")));
        ScrollPage.scrollToViewContinue(driver);
        btn_Continue.click();
    }

    public void clickOnEmployerSignOutLink() {
        lnk_employer_signOut.click();
    }

    public void clickOnFindOutMoreAboutEssentialCookiesLink() {
        essentialCookiesLink.click();
    }

//	public void assertUseGoogleAnalyticsRadioButtonIsSelected() {
//		Assert.assertTrue("Use google analytics Radio button not selected", useGoogleAnalyticsRadioBtn.isSelected());

    public void clickOnFindOutMoreAboutHowToManageCookiesLink() {
        findOutHowToManageCookiesLink.click();
    }

    public void clickOnFindOutMoreGoogleAnalyticsCookiesLink() {
        findMoreAboutGoogleAnalyticsCookiesLink.click();
    }

    public void clickOnGoBackLink() {
        if (goBackLink.isDisplayed() || goBackLink.isEnabled()) {
            goBackLink.click();
        } else {
            Assert.fail("I am unable to click on the Go Back link");
        }
    }

    public void clickOnGoBackToDashboard() {
        goBackToDashBoard.click();
    }

    public void clickOnReturnToDashBoardButton() {
        returnToDashBoardButton.click();
    }

    public void clickOnGoBackToJobListings() {
        goBackToJobListings.click();
    }

    public void clickOnGoBackToYourDashboard() {
        goBackToYourDashBoard.click();
    }

    public void clickOnGoToYourJobAdvertsButton() {
        driver.findElement(By.id("back_to_your_job_adverts")).click();
    }

    public void clickOnHowToApplyForJobs() {
        helpText.click();
    }

    public void clickOnHowToCreateandPublishJobs() {

        helpLink.click();
    }

    // Button Actions
    public void clickOnLoginButton() {
        loginButton.click();
        loginButton.isSelected();
    }

    public void clickOnReturnToYourJobAdvertLink() {
        btn_continue.click();
    }

    public void clickOnSaveAndComeBackLaterButton() {
        ScrollPage.scrollToViewSaveAndContinue(driver);
        saveAndComeBackLaterLink.click();
    }

    public void clickOnSaveAndContinueButton() {
        ScrollPage.scrollToViewSaveAndContinue(driver);
        //if (saveAndContinueButton.isDisplayed()) {
        // Benjamin Azeta
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(saveAndContinueButton)).click();
        //saveAndContinueButton.click();
        //}
    }

    public void clickOnGoBackToManageUsersBtn() {

        goBackToManageUsersBtn.click();
    }

    public void clickOnReturnToPreEmpChecklistLnk() {

        returnToPreEmpChecklist.click();
    }

    public void clickOnSignOutLink() {
        lnk_signOut.click();

    }

    public void clickOnTheSaveButton() {
        saveBtn.click();

    }

    public void clickOnUseGoogleAnalyticsCookiesButton() {
        useGoogleAnalyticsBtn.click();
        saveBtn.click();
        driver.findElement(By.id("employer_sign_in")).click();

    }

    public void clickOnViewLink() {
        viewLink.click();

    }

    public void clickOnFeedbackLink() {
        feedbackLink.click();

    }

    public void clickPrivacyPolicyLink() {
        privacyPolicyLink.click();

    }

    public void clickRadioBtnOption(int i) {
        radioBtns.get(i).click();

    }

    public void clickReadMoreAboutCookies() {
        readMoreAboutCookiesLink.click();

    }

    public void clickRejectAnalytics() {
        rejectAnalyticsButton.click();

    }

    public void clickSaveButton() {
        saveBtn.click();
    }

    public void clickTermsAndConditionsLink() {
        termsandconditionsLink.click();
    }

    public boolean doesThePageHaveValidationErrors() {
        try {
            WebElement errorSummaryElement = getElement(
                    By.cssSelector("ul[class='nhsuk-list nhsuk-error-summary__list']"));
            List<WebElement> errorSummaryChildElements = errorSummaryElement.findElements(By.xpath(".//*"));
            List<WebElement> errorFieldElements = driver
                    .findElements(By.className("error-message"));
        } catch (NoSuchElementException e) {
            return false;
        }

        return true;
    }

    public List<String> getArrayListOfStringWithCommaSeparated(String fieldNames) {
        List<String> errorIds = new ArrayList<>();
        if (fieldNames.contains(",")) {
            errorIds = Arrays.asList(fieldNames.split(","));
        } else {
            errorIds.add(fieldNames);
        }
        return errorIds;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public String getEmployerName() {
        return employerName.getText();
    }

    private List<String> getIdListOfExpectedChildElements(List<String> elementIds) {
        List<String> ids = new ArrayList<>();
        for (String elementId : elementIds) {
            ids.add(elementId);
        }
        ids.remove(0);
        return ids;
    }

    // navigate helper
    public void navigateTo(String url) {
        driver.navigate().to(url);

    }

    public void clickContinue() {
        btn_Continue.click();

    }

    public void waitForElementToAppear(By findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForWebElementToAppear(WebElement findBy) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }

    public void waitForElementToDisappear(WebElement ele) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.invisibilityOf(ele));
        log.info("Waiting Element to disappear....");

    }

    public void waitAndSendKeys(WebElement findBy, String keysToSend) {
        findBy.clear();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        wait.until(ExpectedConditions.visibilityOf(findBy)).sendKeys(keysToSend);
        log.info("Waited and Successfully sent keys to :: " + keysToSend);
    }

    public void waitAndClick(WebElement findBy) {
        log.info("Waiting Element to be clicked....");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.getExplicitWait()));
        log.info("Successfully clicked ");
        wait.until(ExpectedConditions.elementToBeClickable(findBy)).click();

    }

    public void SwitchWindowToChild() {
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        driver.switchTo().window(childWindow);
    }

}
