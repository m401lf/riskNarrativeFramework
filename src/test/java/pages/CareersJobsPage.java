package pages;

import com.google.common.util.concurrent.Uninterruptibles;
import helper.LoggerHelper;
import helper.assertion.VerificationHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GlobalVars;

import java.time.Duration;
import java.util.List;

public class CareersJobsPage {
    final static Logger log = LoggerHelper.getLogger(CareersJobsPage.class);
    CareersJobsPage careersJobsPage;
    WebDriver driver;
    @FindBy(xpath = "//h1[normalize-space()='Search all jobs']")
    private WebElement searchAllJobsHeader;
    @FindBy(css = "input.search-box-input.ais-search-box--input")
    private WebElement searchBox;
    @FindBy(css = "span.search-box-button-text")
    private WebElement searchButton;

    @FindBy(css = "div.no-results")
    private WebElement noSearchResultsHeader;

    @FindBy(css = ".score-button.hidden-xs.hidden-sm")
    private WebElement searchAllJobsBtn;

    @FindBy(css = "div[class='search-results'] div[class='ais-body ais-stats--body']")
    private WebElement showingResultForSearchAllButton;

    @FindBy(css = "#search-results-statistics-e0271e2d03ab43d1b65ffb7850e12e1d")
    private WebElement showingResultsStatistics;
    @FindBy(css = ".search-results-item-title")
    private List<WebElement> displayedJobsTitlesList;
    @FindBy(css = ".social-btn-share")
    private WebElement socialShareButton;
    @FindBy(css = "#search-results-statistics-e0271e2d03ab43d1b65ffb7850e12e1d")
    private WebElement searchResultsHeader;
    @FindBy(css = "a.search-results-item-title-url")
    private List<WebElement> searchResultsJobList;
    @FindBy(css = "h3.search-filter-header")
    private List<WebElement> searchFilterHeaders;
    @FindBy(xpath = "//div[contains(text(),'Clear all')]")
    private WebElement clearAllLink;
    @FindBy(xpath = "(//div[@class='ais-body ais-stats--body'])[1]")
    private WebElement textForManySearchResultsItems;
    @FindBy(css = "span.selected-placeholder.selected-item")
    private WebElement selectOneMoreText;
    @FindBy(xpath = "div[class='lnrs-filter-selected-options'] span[class='caret']")
    private List<WebElement> selectOneMoreDropDownList;

    public boolean assertSearchAllJobsHeaderIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(searchAllJobsHeader);
    }

    public void clickSocialShareButton() {
        socialShareButton.click();
    }

    public boolean assertSocialShareButtonIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(socialShareButton);
    }

    public WebElement getSearchResultsHeader() {
        return searchResultsHeader;

    }

    public List<WebElement> getSearchResultsJobList() {
        return searchResultsJobList;

    }

    public List<String> getSearchFilterHeadersText() {
        return searchFilterHeaders.stream().parallel().filter(WebElement::isDisplayed).map(WebElement::getText).toList();
    }


    public WebElement getSearchAllJobsHeader() {
        return searchAllJobsHeader;

    }

    public WebElement getSearchBox() {
        return searchBox;

    }

    public WebElement getSearchButton() {
        return searchButton;

    }

    public WebElement getShowingResultsStatistics() {
        return showingResultsStatistics;

    }

    public String getShowingResultsStatisticsTxt() throws InterruptedException {
        return showingResultsStatistics.getText();

    }

    public WebElement getNoSearchResultsHeader() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(driver -> noSearchResultsHeader.isDisplayed());
        return noSearchResultsHeader;

    }

    public boolean assertSearchBoxIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(searchBox);

    }

    public boolean assertSearchBoxIsEnable() {
        return new VerificationHelper(driver).isEnabled(searchBox);

    }


    public String getShowingResultsStatisticsText() {
        return new VerificationHelper(driver).getText(showingResultsStatistics);
    }

    public boolean assertShowingResultsStatisticsIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(showingResultsStatistics);
    }

    public int getDisplayedJobsTitlesCountGreaterThanZero() {
        log.info("Displayed jobs titles count is greater than zero: " + displayedJobsTitlesList.size());
        return displayedJobsTitlesList.size();

    }

    public boolean assertSearchResultsForJobTitle(String jobTitle) {
        log.info("Displayed jobs titles count: " + displayedJobsTitlesList.size());
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(ExpectedConditions.visibilityOfAllElements(displayedJobsTitlesList));
        log.info("jobs titles is related and relevant to the job search: " + jobTitle);
        return displayedJobsTitlesList.stream().parallel().filter(WebElement::isDisplayed).anyMatch(s -> s.getText().contains(jobTitle));

    }

    public boolean assertJobSearchResultsByJobTitle(String jobTitle) {
        for (int i = 0; i < displayedJobsTitlesList.size(); i++) {
            if (displayedJobsTitlesList.get(i).isDisplayed()) {
                return displayedJobsTitlesList.get(i).getText().contains(jobTitle);
            }
        }
        return false;
    }

    public void inputSearchBox(String jobTitle) {
        searchBox.clear();
        log.info("Search box is cleared");
        searchBox.sendKeys(jobTitle);
        log.info("Search box is entered with job title: " + jobTitle);
    }

    public String getTextForManySearchResultsItems() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(driver -> textForManySearchResultsItems.isDisplayed());
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(GlobalVars.SHORT_IMPLICIT_WAIT_TIME));
        log.info("Text for many search results items is displayed: " + textForManySearchResultsItems.getText());
        return new VerificationHelper(driver).getText(textForManySearchResultsItems);
    }

    public boolean assertTextForManySearchResultsItemsIsDisplayed() {
        new Actions(driver).moveToElement(textForManySearchResultsItems).build().perform();
        return new VerificationHelper(driver).isDisplayed(textForManySearchResultsItems);
    }

    public boolean assertTextForManyItemsIsNotDisplayed() {
        new Actions(driver).moveToElement(textForManySearchResultsItems).build().perform();
        return new VerificationHelper(driver).isNotDisplayed(textForManySearchResultsItems);
    }


    public boolean assertSelectOneMoreTextIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(selectOneMoreText);

    }

    public List<WebElement> getSelectOneMoreDropDownList() {
        return selectOneMoreDropDownList;

    }

    public void enterSearchBox(String jobTitle) {
        searchBox.clear();
        searchBox.sendKeys(jobTitle);
        log.info("Search box is entered with text: " + jobTitle);
    }

    public SearchResultPage clickSearchButton() {
        if (searchButton.isDisplayed() && searchButton.isEnabled()) {
            log.info("Careers Link is displayed and enabled");
        }
        searchButton.click();
        log.info("Search button is clicked");
        return new SearchResultPage();
    }

    public SearchResultPage searchWithValidJobTitle(String jobTitle) {
        enterSearchBox(jobTitle);
        searchButton.click();
        return new SearchResultPage();

    }

    public SearchResultPage SearchWithInvalidJobTitle(String jobTitle) {
        enterSearchBox(jobTitle);
        searchButton.click();
        return new SearchResultPage();
    }

    public String getSearchResultsCountText() {
        return new VerificationHelper(driver).getText(searchResultsHeader);

    }

    public boolean assertSearchResultsHeaderIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(searchResultsHeader);

    }

    public boolean assertNoSearchResultsHeaderIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(noSearchResultsHeader);

    }

    public String getNoSearchResultsHeaderText() {
        return new VerificationHelper(driver).getText(noSearchResultsHeader);

    }

    public String getSearchAllJobsButtonText() {
        return new VerificationHelper(driver).getText(searchAllJobsBtn);

    }

    public boolean assertSearchAllJobsButtonIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(searchAllJobsBtn);

    }

    public CareersJobsPage clickSearchAllJobsButton() {
        if (searchAllJobsBtn.isDisplayed() && searchAllJobsBtn.isEnabled()) {
            log.info("Careers Link is displayed and enabled");
        }
        searchAllJobsBtn.click();
        log.info("Search all jobs button is clicked");
        careersJobsPage = new CareersJobsPage();
        return careersJobsPage;
    }

    public String getShowingResultForSearchAllButtonText() {
        return new VerificationHelper(driver).getText(showingResultForSearchAllButton);

    }


    public boolean assertShowingResultsStatisticsSearchAllJobsIsDisplayed() {
        boolean isDisplayed = new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(driver -> showingResultForSearchAllButton.isDisplayed());
        log.info("Showing result for search all jobs button is displayed: " + showingResultForSearchAllButton.getText());
        return isDisplayed;
    }

}


