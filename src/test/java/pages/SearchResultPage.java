package pages;

import helper.LoggerHelper;
import helper.assertion.VerificationHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {
    final static Logger log = LoggerHelper.getLogger(IndexPage.class);
    WebDriver driver;
    @FindBy(xpath = "//h1[normalize-space()='Search Results']")
    private WebElement searchResultsHeadingText;

    public String getSearchResultsHeadingText() {
        return new VerificationHelper(driver).getText(searchResultsHeadingText);
    }

    public boolean assertSearchResultsHeadingTextIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(searchResultsHeadingText);
    }


}
