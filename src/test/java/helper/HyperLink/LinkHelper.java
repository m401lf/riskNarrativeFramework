/**
 * @author rahul.rathore
 * <p>
 * 07-Aug-2016
 */
package helper.HyperLink;

import helper.Generic.GenericHelper;
import helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LinkHelper extends GenericHelper {

    final static Logger log = LoggerHelper.getLogger(LinkHelper.class);
    private final WebDriver driver;

    public LinkHelper(WebDriver driver) {
        super(driver);
        this.driver = driver;
        log.debug("LinkHelper : " + this.driver.hashCode());
    }

    public void clickLink(String linkText) {
        log.info(linkText);
        getElement(By.linkText(linkText)).click();
    }

    public void clickPartialLink(String partialLinkText) {
        log.info(partialLinkText);
        getElement(By.partialLinkText(partialLinkText)).click();
    }

    public String getHyperLink(By locator) {
        log.info(locator);
        return getHyperLink(getElement(locator));
    }

    public String getHyperLink(WebElement element) {
        String link = element.getAttribute("hreg");
        log.info("Element : " + element + " Value : " + link);
        return link;
    }
}
