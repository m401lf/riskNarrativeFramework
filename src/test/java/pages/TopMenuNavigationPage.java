package pages;

import helper.LoggerHelper;
import helper.assertion.VerificationHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class TopMenuNavigationPage {
    final static Logger log = LoggerHelper.getLogger(TopMenuNavigationPage.class);
    WebDriver driver;
    @FindBy(css = "a.navbar-brand")
    private WebElement logo;

    @FindBy(xpath = "/html/body/header/div/div/div/nav/div/div/div[2]/div/div/ul/li")
    private List<WebElement> topMenuList;

    @FindBy(xpath = "(//span[@class='caret'])[1]")
    private WebElement chooseYourIndustryLinkArrow;

    @FindBy(css = "(a[aria-expanded='false']")
    private WebElement chooseYourIndustryLink;

    @FindBy(xpath = "//a[@href='#'][normalize-space()='About Us']")
    private WebElement aboutUsLink;

    @FindBy(css = "#filter_keyword")
    private WebElement searchBox;

    @FindBy(css = ".button-in-search")
    private WebElement searchBtn;

    @FindBy(css = "a.score-button")
    private List<WebElement> top3MenuList;

    @FindBy(css = "button[aria-label='Internships &amp; Programs']")
    private WebElement internshipsPrograms;

    @FindBy(xpath = "/html/body/div[2]/div/div/div/div[1]/div/ul/li/a")
    private List<WebElement> internshipsProgramsDropdownList;

    @FindBy(css = "a.score-composite-link.btn-country-language-selector")
    private WebElement languageSelector;

    @FindBy(css = "a.score-composite-link.btn-product-sign-in")
    private WebElement productSignIn;

    @FindBy(xpath = "//a[normalize-space()='Contact']")
    private WebElement contactUsLink;

    @FindBy(xpath = "//a[normalize-space()='Insights and Resources']")
    private WebElement insightsResourcesLink;

    @FindBy(xpath = "//a[normalize-space()='Products']")
    private WebElement productsLink;


    public boolean assertChooseYourIndustryLinkIsDisplayed() {
        return chooseYourIndustryLink.isDisplayed();

    }

    public String getChooseYourIndustryLink() {
        return chooseYourIndustryLink.getText();

    }

    public void clickChooseYourIndustryLink() {
        if (chooseYourIndustryLinkArrow.isDisplayed() && chooseYourIndustryLinkArrow.isEnabled()) {
            log.info("Choose Your Industry Link is displayed and enabled");
        }
        chooseYourIndustryLinkArrow.click();
        log.info("Choose Your Industry Link is clicked");

    }

    public AboutUsPage clickAboutUsLink() {
        if (aboutUsLink.isDisplayed() && aboutUsLink.isEnabled()) {
            log.info("About Us Link is displayed and enabled");
        }
        aboutUsLink.click();
        log.info("About Us Link is clicked");
        return new AboutUsPage();
    }


    public boolean assertTopMenuItemsAreDisplayed() {
        return topMenuList.stream().parallel().filter(WebElement::isDisplayed).count() == topMenuList.size();

    }

    public boolean assertLogoIsDisplayed() {
        return logo.isDisplayed();

    }

    public String getAboutUsLinkText() {
        return aboutUsLink.getText();

    }

    public boolean assertAboutUsLinkIsDisplayed() {
        return aboutUsLink.isDisplayed();

    }

    public void inputSearchBox(String keyToSearch) {
        searchBox.sendKeys(keyToSearch);

    }

    public boolean assertSearchBoxIsDisplayed() {
        return searchBox.isDisplayed();

    }

    public SearchResultPage clickSearchBtn() {
        searchBtn.click();
        log.info("Search Button is clicked");
        return new SearchResultPage();
    }


    public List<WebElement> getTop3MenuList() {
        return top3MenuList;

    }

    public WebElement getInternshipsPrograms() {
        return internshipsPrograms;

    }

    public List<WebElement> getInternshipsProgramsDropdownList() {
        return internshipsProgramsDropdownList;

    }

    public void getLanguageSelector() {
        languageSelector.click();

    }

    public WebElement getProductSignIn() {
        return productSignIn;

    }

    public void getContactUsLink() {
        contactUsLink.click();

    }

    public void clickInsightsResourcesLink() {
        insightsResourcesLink.click();

    }

    public void clickProductsLink() {
        productsLink.click();

    }


    public String getChooseYourIndustryLinkText() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> chooseYourIndustryLink.isDisplayed());
        log.info("Choose Your Industry Link Text is " + chooseYourIndustryLink.getText());
        return new VerificationHelper(driver).getText(chooseYourIndustryLink);
    }

    public Boolean assertItemFromTopMenu(String itemNameFromTopMenu) {
        return topMenuList.stream().anyMatch(s->s.getText().equalsIgnoreCase(itemNameFromTopMenu));

    }

    public Boolean assertAndClickAnItemFromTopMenu(String itemNameFromTopMenu) {
        for (WebElement item : topMenuList) {
            if (item.getText().contains(itemNameFromTopMenu)) {
                log.info(item.getText() + " is displayed");
                item.click();
                return true;
            }
        }

        return true;
    }

    public void clickAnItemFromTopMenu(String itemNameFromTopMenu) {
        topMenuList.stream().parallel().filter(s -> s.getText().contains(itemNameFromTopMenu)).findFirst().ifPresent(WebElement::click);

    }
}