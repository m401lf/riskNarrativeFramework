package pages;

import helper.LoggerHelper;
import helper.assertion.VerificationHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CareersPage {
    final static Logger log = LoggerHelper.getLogger(CareersPage.class);
    WebDriver driver;

    @FindBy(css = ".horizontal > div:nth-child(3) > a:nth-child(1)")
    private WebElement searchJobsButton;

    @FindBy(xpath = "//strong[normalize-space()='Explore More']")
    private WebElement exploreMoreText;

    @FindBy(xpath = "//h2[normalize-space()='Careers']")
    private WebElement careersHeadingText;

    public WebElement getSearchJobsButton() {
        return searchJobsButton;

    }

    public JobsPage clickSearchJobsButton() {
        searchJobsButton.click();
        log.info("Search jobs button is clicked");
        return new JobsPage();
    }

    public String getSearchJobsButtonText() {
        return new VerificationHelper(driver).getText(searchJobsButton);

    }

    public String getExploreMoreText() {
        return new VerificationHelper(driver).getText(exploreMoreText);

    }

    public String getCareersHeadingText() {
        return new VerificationHelper(driver).getText(careersHeadingText);

    }


}


