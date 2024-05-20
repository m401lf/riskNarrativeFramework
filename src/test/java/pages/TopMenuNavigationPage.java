package pages;

import helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GlobalVars;

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

    @FindBy(xpath = "//a[normalize-space()='Choose Your Industry']")
    private WebElement chooseYourIndustryLink;

    @FindBy(xpath = "//a[@href='#'][normalize-space()='About Us']")
    private WebElement aboutUsLink;

    @FindBy(css = "#filter_keyword")
    private WebElement searchBox;

    @FindBy(css = ".button-in-search")
    private WebElement searchBtn;

    @FindBy(css = "/html/body/header/div/div/div/nav/div/div/div[2]/div/div/ul/li")
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

    public String getChooseYourIndustryLink() {
        return chooseYourIndustryLink.getText();

    }

    public void clickChooseYourIndustryLink() {
        chooseYourIndustryLinkArrow.click();
        log.info("Choose Your Industry Link is clicked");

    }

    public AboutUsPage clickAboutUsLink() {
        aboutUsLink.click();
        log.info("About Us Link is clicked");
        return new AboutUsPage();
    }

    public boolean assertTopMenuItemsAreDisplayed() {
        return topMenuList.stream().parallel().filter(WebElement::isDisplayed).count() == topMenuList.size();

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


    public List<WebElement> getTopMenuList() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(driver -> topMenuList.size() > GlobalVars.THREE);
        return topMenuList;

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

    public void clickAnItemMatchingTextFromTopMenuLinks(List<WebElement> topMenuList, String menuItemText) {
        topMenuList.stream().parallel().filter(item -> item.getText().contains(menuItemText)).findFirst().ifPresent(WebElement::click);
        log.info(menuItemText + " link is clicked");
    }


}