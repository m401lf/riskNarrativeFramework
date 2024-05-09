package pages;

import helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Iterator;
import java.util.List;

public class FooterPage {
    final static Logger log = LoggerHelper.getLogger(FooterPage.class);
    @FindBy(css = ".footer-info-heading")
    public List<WebElement> footerLinks;
    WebDriver driver;

    public void clickOnFooterTextName(String textName) {
        List<WebElement> textNames = footerLinks;
        Iterator<WebElement> itr = textNames.iterator();
        while (itr.hasNext()) {
            WebElement c = itr.next();
            String text = c.getText().trim();
            if (text.equals(textName)) {
                c.click();
                break;
            }
        }
    }

}
