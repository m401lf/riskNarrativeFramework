package helper.Button;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.IwebComponent;

public class ButtonHelper implements IwebComponent {
    Logger log = LogManager.getLogger(ButtonHelper.class);
    WebDriver driver;

    public ButtonHelper(WebDriver driver) {
        this.driver = driver;
        log.debug("Button Helper : " + this.driver.hashCode());
    }

    public void click(By locator) {
        click(driver.findElement(locator));
        log.info(locator);
    }

    public void click(WebElement element) {
        element.click();
        log.info(element);
    }
}
