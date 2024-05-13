package pages;

import helper.LoggerHelper;
import helper.assertion.VerificationHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.GlobalVars;

import java.time.Duration;
import java.util.List;


public class IndexPage {
    final static Logger log = LoggerHelper.getLogger(IndexPage.class);
    WebDriver driver;
    FinancialServicesPage financialServicesPage;

    @FindBy(xpath = "/html/body/header/div/div/div/nav/div/div/div[2]/div/div/ul/li[1]/ul/li/div/div[2]/ul/li/a/div[1]")
    private List<WebElement> industriesTitles;

    @FindBy(xpath = "//h3[normalize-space()='Industries']")
    private WebElement industriesTxt;

    @FindBy(xpath = "(//span[contains(text(),'Select an Industry')])[2]")
    private WebElement selectIndustryText;

    @FindBy(xpath = "//div[normalize-space()='Insurance']")
    private WebElement insuranceLink;

    @FindBy(xpath = "//div[normalize-space()='Financial Services']")
    private WebElement financialServicesLink;

    @FindBy(xpath = "/html/body/header/div/div/div/nav/div/div/div[2]/div/div/ul/li[1]/ul/li/div/div[1]/div/div[1]/ul/li")
    private List<WebElement> financialServicesItemList;


    public List<WebElement> getFinancialServicesItems() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(driver -> financialServicesItemList.size() > GlobalVars.THREE);
        return financialServicesItemList;

    }

    public List<WebElement> getIndustriesTitles() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(driver -> industriesTitles.size() > GlobalVars.THREE);
        return industriesTitles;

    }

    public boolean getIndustriesTitleListText() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(driver -> industriesTitles.size() > GlobalVars.THREE);
        try {
            driver.findElements(By.xpath("/html/body/header/div/div/div/nav/div/div/div[2]/div/div/ul/li[1]/ul/li/div/div[2]/ul/li/a/div[1]"));
            System.out.println("Pass: Element is Present");
        } catch (Exception e) {
            System.out.println("Fail: Element is Not Present");
        }

        return true;
    }

    public List<WebElement> assertIndustriesTitlesPresent(String title) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(driver -> industriesTitles.size() > GlobalVars.THREE);
        try {
            for (int i = 0; i < industriesTitles.size(); i++) {
                if (industriesTitles.get(i).isDisplayed()) {
                    log.info("Index " + i + " :: " + "Element is Present: " + industriesTitles.get(i).getText());
                }
            }
        } catch (Exception e) {
            log.error("Fail: Element is Not Present");
        }
        return industriesTitles;
    }

    public boolean assertIndustriesTitlesArePresent(String title) {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(driver -> industriesTitles.size() > GlobalVars.THREE);
        try {
            for (int i = 0; i < industriesTitles.size(); i++) {
                if (industriesTitles.get(i).isDisplayed()) {
                    log.info("Index " + i + " :: " + "Element is Present: " + industriesTitles.get(i).getText());
                }
            }
        } catch (Exception e) {
            log.error("Fail: Element is Not Present");
        }
        return industriesTitles.stream().anyMatch(s -> s.isDisplayed() && s.getText().contains(title));
    }

    public List<WebElement> assertFinancialServicesItemsPresent() {
        new WebDriverWait(driver, Duration.ofSeconds(GlobalVars.explicitWait)).until(driver -> financialServicesItemList.size() > 6);
        try {
            for (int i = 0; i < financialServicesItemList.size(); i++) {
                if (financialServicesItemList.get(i).isDisplayed()) {
                    log.info("Index " + i + " :: " + "Element is Present: " + financialServicesItemList.get(i).getText());
                }
            }
        } catch (Exception e) {
            log.error("Fail: Element is Not Present");
        }
        return financialServicesItemList;
    }

    public String getFinancialServicesLinkText() {
        return new VerificationHelper(driver).getText(financialServicesLink);

    }

    public boolean assertFinancialServicesLinkIsDisplayed() {
        return new VerificationHelper(driver).isDisplayed(financialServicesLink);

    }

    public FinancialServicesPage clickFinancialServicesLink() {
        financialServicesLink.click();
        log.info("Financial Services link is clicked");
        financialServicesPage = new FinancialServicesPage();
        return financialServicesPage;
    }


    public boolean assertIndustriesTextIsDisplayed() {
        return industriesTxt.isDisplayed();

    }

    public String getIndustriesText() {
        return industriesTxt.getText();

    }


    public List<WebElement> getFinancialServicesItemList() {
        return financialServicesItemList;

    }

    public List<String> getIndustriesTitlesList() {
        return getIndustriesTitles().stream().parallel().filter(s -> s.isDisplayed() && s.isEnabled()).map(WebElement::getText).toList();
    }

    public List<String> getFinancialServicesList() {
        return getFinancialServicesItemList().stream().parallel().filter(s -> s.isDisplayed() && s.isEnabled()).map(WebElement::getText).toList();
    }

    public long getFinancialServicesLinksCount() {
        return getFinancialServicesItemList().size();

    }

    public String getSelectIndustryText() {
        return selectIndustryText.getText();

    }

    public long getIndustriesLinksCount() {
        return getIndustriesTitlesList().size();

    }


}
