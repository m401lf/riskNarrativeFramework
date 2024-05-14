package pages;

import com.google.common.util.concurrent.Uninterruptibles;
import helper.LoggerHelper;
import helper.assertion.VerificationHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utilities.GlobalVars;

import java.time.Duration;
import java.util.List;


public class CookieBannerPage {
    final static Logger log = LoggerHelper.getLogger(CookieBannerPage.class);
    WebDriver driver;

    @FindBy(id = "onetrust-banner-sdk")
    private WebElement cookieBanner;
    @FindBy(xpath = "//*[@id='onetrust-button-group']//button")
    private List<WebElement> cookieBannerButtons;
    @FindBy(id = "onetrust-policy-text")
    private WebElement cookiesPolicyText;
    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    private WebElement acceptAllCookiesButton;
    @FindBy(css = "button.cookie-setting-link")
    private WebElement cookieSettingsButton;
    @FindBy(css = "img[alt='Company Logo']")
    private WebElement coyLogoImg;
    @FindBy(css = "#ot-category-title")
    private WebElement manageConsentPreferencesHeader;
    @FindBy(css = "button[ot-accordion='true']")
    private List<WebElement> categoriesAccordionList;
    @FindBy(css = "#ot-pc-title")
    private WebElement cookiePreferenceCenterHeadingText;
    @FindBy(css = "#ot-header-id-1")
    private WebElement strictlyNecessaryCookies;
    @FindBy(css = ".ot-acc-hdr.ot-always-active-group")
    private WebElement alwaysActive;
    @FindBy(css = "h4.ot-cat-header")
    private List<WebElement> categoryHeaderList;
    @FindBy(css = "#ot-pc-desc")
    private WebElement descriptionText;
    @FindBy(xpath = "//div[@id='ot-pc-desc']//a[normalize-space()='Cookie Policy']")
    private WebElement cookiePolicyLink;
    @FindBy(xpath = "//a[normalize-space()='Your Privacy Choices']")
    private WebElement yourPrivacyChoicesLink;
    @FindBy(css = "a[href='https://risk.lexisnexis.com/corporate/privacy-policy']")
    private WebElement privacyPolicyLink;
    @FindBy(css = "#accept-recommended-btn-handler")
    private WebElement allowAllButton;
    @FindBy(css = "div.ot-plus-minus")
    private List<WebElement> accordionPlusMinusList;
    @FindBy(css = "span.ot-switch-nob")
    private List<WebElement> switchNobsList;
    @FindBy(css = "button.save-preference-btn-handler")
    private WebElement confirmMyChoicesButton;
    @FindBy(css = "img[title='Powered by OneTrust Opens in a new Tab']")
    private WebElement poweredByOneTrust;
    @FindBy(css = "id='close-pc-btn-handler'")
    private WebElement closeX;


    public void acceptCookie() {
        log.info("Accepting all cookies");
        acceptAllCookiesButton.click();

    }

    public void assertCookieIsNotPresent(String cookieName) {
        Assert.assertNull(driver.manage().getCookieNamed(cookieName));

    }

    public boolean assertCookieBannerIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(cookieBanner);

    }

    public boolean assertAcceptAllCookiesButtonIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(acceptAllCookiesButton);

    }

    public boolean assertCookieSettingsButtonIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(cookieSettingsButton);

    }

    public String getAcceptAllCookiesButtonText() throws InterruptedException {
        Thread.sleep(5000);
        return acceptAllCookiesButton.getText();

    }

    public String getCookieSettingsButtonText() {
        return new VerificationHelper(driver).getText(cookieSettingsButton);

    }

    public WebElement getCookieBanner() {
        return cookieBanner;

    }

    public void clickAcceptAllCookiesButton() {
        acceptAllCookiesButton.click();
        log.info("Accept all cookies button clicked");
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(GlobalVars.THREE));

    }

    public void clickAllowAllButton() {
        allowAllButton.click();
        log.info("Allow all cookies button clicked");
    }

    public void clickCookieSettingsButton() {
        log.info("Cookie settings button clicked");
        cookieSettingsButton.click();

    }

    public List<WebElement> getCookieBannerButtons() {
        log.info("Size of cookies Banner button :" + cookieBannerButtons.size());
        return cookieBannerButtons;

    }

    public String getManageConsentPreferencesHeaderText() {
        return new VerificationHelper(driver).getText(manageConsentPreferencesHeader);

    }

    public void clickPlusMinusAndSwitchNobInCategoriesAccordionList(String cookies) {
        for (int i = 0; i < accordionPlusMinusList.size(); i++) {
            if (accordionPlusMinusList.get(i).isDisplayed() && accordionPlusMinusList.get(i).getText().contains(cookies)) {
                accordionPlusMinusList.get(i).click();
                switchNobsList.get(i).click();
            }
        }
    }

    public String getCookiePreferenceCenterText() {
        return new VerificationHelper(driver).getText(cookiePreferenceCenterHeadingText);

    }

    public boolean assertCookiePreferenceCenterTextIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(cookiePreferenceCenterHeadingText);

    }

    public String getDescriptionText() {
        return new VerificationHelper(driver).getText(descriptionText);

    }

    public boolean assertDescriptionTextIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(descriptionText);

    }

    public String getCookiePolicyLinkText() {
        return new VerificationHelper(driver).getText(cookiePolicyLink);

    }

    public boolean assertCookiePolicyLinkIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(cookiePolicyLink);

    }

    public void clickCookiePolicyLink() {
        yourPrivacyChoicesLink.click();

    }

    public String getYourPrivacyChoicesLinkText() {
        return new VerificationHelper(driver).getText(yourPrivacyChoicesLink);

    }

    public boolean assertYourPrivacyChoicesLinkIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(yourPrivacyChoicesLink);

    }

    public String getPrivacyPolicyLinkText() {
        return new VerificationHelper(driver).getText(privacyPolicyLink);

    }

    public boolean assertPrivacyPolicyLinkIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(privacyPolicyLink);

    }

    public boolean assertAllowAllButtonIsDisplayed() {
        return allowAllButton.isDisplayed();

    }

    public void clickAccordionPlusMinusList() {
        for (WebElement accordionPlusMinus : accordionPlusMinusList) {
            if (accordionPlusMinus.isDisplayed()) {
                accordionPlusMinus.click();
            }
        }

    }

    public List<WebElement> clickAccordionPlusMinusList(String categoriesAccordionName) {
        for (int i = 0; i < accordionPlusMinusList.size(); i++) {
            if (accordionPlusMinusList.get(i).isDisplayed() && categoriesAccordionList.get(i).getText().contains(categoriesAccordionName)) {
                accordionPlusMinusList.get(i).click();
            }
        }

        return null;
    }

    public List<WebElement> clickSwitchNobsList(String categoriesAccordionName) {
        for (int i = 0; i < switchNobsList.size(); i++) {
            if (switchNobsList.get(i).isDisplayed() && categoriesAccordionList.get(i).getText().contains(categoriesAccordionName)) {
                switchNobsList.get(i).click();

            }
        }

        return switchNobsList;
    }

    public void clickSwitchNobs(String categoriesAccordionName) {
        for (int i = 0; i < switchNobsList.size(); i++) {
            if (switchNobsList.get(i).isDisplayed() && categoriesAccordionList.get(i).getText().contains(categoriesAccordionName)) {
                switchNobsList.get(i).click();

            }

        }
    }

    public boolean assertConfirmMyChoicesButtonIsEnabled() {
        return new VerificationHelper(driver).isEnabled(confirmMyChoicesButton);

    }

    public boolean assertConfirmMyChoicesButtonIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(confirmMyChoicesButton);

    }

    public void clickConfirmMyChoicesButton() {
        confirmMyChoicesButton.click();

    }

    public String getPoweredByOneTrustText() {
        return new VerificationHelper(driver).getText(poweredByOneTrust);

    }

    public boolean assertPoweredByOneTrustIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(poweredByOneTrust);

    }

    public void clickCloseX() {
        closeX.click();

    }

    public boolean assertCloseXIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(closeX);

    }

    public WebElement getStrictlyNecessaryCookies() {
        return strictlyNecessaryCookies;

    }

    public String getStrictlyNecessaryCookiesText() {
        return new VerificationHelper(driver).getText(strictlyNecessaryCookies);
    }

    public boolean assertStrictlyNecessaryCookiesIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(strictlyNecessaryCookies);
    }


    public WebElement getAlwaysActive() {
        return alwaysActive;

    }

    public boolean assertAlwaysActiveIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(alwaysActive);

    }

    public String getAlwaysActiveText() {
        return new VerificationHelper(driver).getText(alwaysActive);

    }

    public boolean assertAlwaysActiveIsEnabled() {
        return new VerificationHelper(driver).isEnabled(alwaysActive);

    }

    public void clickAlwaysActive() {
        alwaysActive.click();

    }

    public List<WebElement> getCategoryHeaderList() {
        return categoryHeaderList;

    }

    public boolean assertCategoryHeaderListIsDisplayed(String categoryName) {
        return categoriesAccordionList.stream().parallel().filter(WebElement::isDisplayed).anyMatch(s -> s.getText().contains(categoryName));
    }

    public boolean assertItemDisplayedFromCategoryHeaderList(String categoryName) {
        return categoriesAccordionList.stream().parallel().anyMatch(s -> s.getText().contains(categoryName));
    }


    public void assertPlusOrMinusButtonIsDisplayed(String categoryName) {
        for (int i = 0; i < accordionPlusMinusList.size(); i++) {
            if (accordionPlusMinusList.get(i).isDisplayed() && categoriesAccordionList.get(i).getText().contains(categoryName)) {
                new VerificationHelper(driver).assertItemDisplayedFromList(accordionPlusMinusList, categoryName);
            }
        }

    }

    public void assertSwitchNobIsDisplayed(String categoryName) {
        for (int i = 0; i < switchNobsList.size(); i++) {
            if (switchNobsList.get(i).isDisplayed() && categoriesAccordionList.get(i).getText().contains(categoryName)) {
                new VerificationHelper(driver).assertItemDisplayedFromList(switchNobsList, categoryName);
            }
        }

    }

    public String getConfirmMyChoiceButtonText() {
        return new VerificationHelper(driver).getText(confirmMyChoicesButton);
    }

}
