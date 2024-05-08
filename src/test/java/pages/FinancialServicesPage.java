package pages;

import helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class FinancialServicesPage {
    final static Logger log = LoggerHelper.getLogger(FinancialServicesPage.class);
    WebDriver driver;
    @FindBy(css = ".subpage-title")
    private List<WebElement> industriesTitles;

    @FindBy(xpath = "//div[normalize-space()='Insurance']")
    private WebElement insuranceLink;


}
