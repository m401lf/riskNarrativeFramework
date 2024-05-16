package pages;

import helper.GenericMethods;
import helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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


    public CareersPage clickCareersLink() {
        if (careersLink.isDisplayed() && careersLink.isEnabled()) {
            log.info("Careers Link is displayed and enabled");
            careersLink.click();
            log.info("Clicked on Careers Link");
        }
        return new CareersPage();
    }

    public boolean assertAnyLinksInAboutUsPage(String linkText) {
        return allLinks.stream()
                .parallel()
                .anyMatch(s -> s.getText().equalsIgnoreCase(linkText));
    }

    public String getAboutUsText() {
        log.info("Getting About Us Text");
        return aboutUsHeadingText.getText().trim();
    }

    public long getAllLinksCount() {
        log.info("Asserting all links count");
        return allLinks.stream().parallel().filter(WebElement::isDisplayed).count();
    }

    public List<String> getAboutUsTitlesList() {
        return allLinks.stream().parallel().filter(link -> link.isDisplayed() && link.isEnabled()).map(WebElement::getText).toList();
    }


}


