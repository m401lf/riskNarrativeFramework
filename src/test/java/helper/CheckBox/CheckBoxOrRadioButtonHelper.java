package helper.CheckBox;

import helper.Button.ButtonHelper;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.IwebComponent;

public class CheckBoxOrRadioButtonHelper implements IwebComponent {
    Logger log = LogManager.getLogger(ButtonHelper.class);
    WebDriver driver;

    public CheckBoxOrRadioButtonHelper(WebDriver driver) {
        this.driver = driver;
        log.debug("CheckBoxOrRadioButtonHelper : " + this.driver.hashCode());
    }

    public void selectCheckBox(By locator) {
        log.info(locator);
        selectCheckBox(driver.findElement(locator));
    }

    public void unSelectCheckBox(By locator) {
        log.info(locator);
        unSelectCheckBox(driver.findElement(locator));
    }

    public boolean isSelectedBy(By locator) {
        log.info(locator);
        return isSelected(driver.findElement(locator));
    }

    public boolean isSelected(WebElement element) {
        boolean flag = element.isSelected();
        log.info(flag);
        return flag;
    }

    public void selectCheckBox(WebElement element) {
        if (!isSelected(element))
            element.click();
        log.info(element);
    }

    public void unSelectCheckBox(WebElement element) {
        if (isSelected(element))
            element.click();
        log.info(element);
    }
}
