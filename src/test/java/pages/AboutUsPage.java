package pages;

import helper.GenericMethods;
import helper.LoggerHelper;
import helper.assertion.VerificationHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GlobalVars;

import java.time.Duration;
import java.util.List;

public class AboutUsPage {
    final static Logger log = LoggerHelper.getLogger(AboutUsPage.class);
    @FindBy(xpath = "/html/body/header/div/div/div/nav/div/div/div[2]/div/div/ul/li[4]/ul/li/div/div/div/div/div/div/h4")
    List<WebElement> allLinks;
    WebDriver driver;
    GenericMethods gm;
    @FindBy(xpath = "//div[@class='score-content-spot']//p[contains(text(),'About Us')]")
    private WebElement aboutUsHeadingText;
    @FindBy(xpath = "//div[@class='score-style-box clearfix']//a[@class='score-button btn-clickable-area'][normalize-space()='Learn More']")
    private WebElement careersLink;

    public List<WebElement> getAllAboutUsLinks() {
        return allLinks;
    }

    public CareersJobsPage clickCareersLink() {
        if (careersLink.isDisplayed() && careersLink.isEnabled()) {
            log.info("Careers Link is displayed and enabled");
            careersLink.click();
            log.info("Clicked on Careers Link");
        }
        return new CareersJobsPage();
    }

    public boolean assertAnyLinksInAboutUsPage(String linkText) {
        return allLinks.stream()
                .parallel()
                .anyMatch(s -> s.getText().equalsIgnoreCase(linkText));
    }

    public String getCareersLinkText() {
        System.out.println(careersLink.getText());
        log.info("Getting Careers Link Text");
        return new VerificationHelper(driver).getText(careersLink);
    }

    public boolean assertAboutUsTextIsDisplayed() {
        log.info("Asserting About Us Link");
        return new VerificationHelper(driver).isDisplayed(aboutUsHeadingText);
    }

    public String getAboutUsText() {
        log.info("Getting About Us Text");
        return aboutUsHeadingText.getText().trim();
    }

    public boolean assertLinkByText(String linkText) {
        log.info("Asserting linkText");
        return allLinks.stream().parallel().anyMatch(link -> link.getText().equalsIgnoreCase(linkText));
    }

    public boolean assertAllLinksAreDisplayed() {
        log.info("Asserting All Links");
        return allLinks.stream().parallel().allMatch(link -> link.isDisplayed() && link.isEnabled());
    }

    public long getAllLinksCount() {
        log.info("Asserting all links count");
        return allLinks.stream().parallel().filter(WebElement::isDisplayed).count();
    }

    public void clickAnElementMatchingTextInAboutUs(List<WebElement> elements, String linkText) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until((d) -> elements.size() > 6);
        elements.stream().parallel().filter(item -> item.getText().contains(linkText)).findFirst().ifPresent(s -> s.click());
        log.info("Matching link text is clicked");
    }

    public List<String> getAboutUsTitlesList() {
        return allLinks.stream().parallel().filter(link -> link.isDisplayed() && link.isEnabled()).map(WebElement::getText).toList();
    }


}


