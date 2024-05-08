/**
 * @author rahul.rathore
 * <p>
 * 06-Aug-2016
 */
package helper.Generic;

import helper.LoggerHelper;
import helper.resource.ResourceHelper;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import utilities.DateTimeHelper;
import utilities.IwebComponent;

import java.io.File;
import java.io.IOException;

public class GenericHelper implements IwebComponent {

    final static Logger log = LoggerHelper.getLogger(GenericHelper.class);
    private final WebDriver driver;

    public GenericHelper(WebDriver driver) {
        this.driver = driver;
        log.debug("GenericHelper : " + this.driver.hashCode());
    }

    public WebElement getElement(By locator) {
        log.info(locator);
        if (IsElementPresentQuick(locator))
            return driver.findElement(locator);

        try {
            throw new NoSuchElementException("Element Not Found : " + locator);
        } catch (RuntimeException re) {
            log.error(re);
            throw re;
        }
    }


    public WebElement getElementWithNull(By locator) {
        log.info(locator);
        try {
            return driver.findElement(locator);
        } catch (NoSuchElementException e) {
            // Ignore
        }
        return null;
    }

    public boolean IsElementPresentQuick(By locator) {
        boolean flag = driver.findElements(locator).size() >= 1;
        log.info(flag);
        return flag;
    }

    public String takeScreenShot(String name) throws IOException {

        if (driver instanceof HtmlUnitDriver) {
            log.fatal("HtmlUnitDriver Cannot take the ScreenShot");
            return "";
        }

        File destDir = new File(ResourceHelper.getResourcePath("screenShots/")
                + DateTimeHelper.getCurrentDate());
        if (!destDir.exists())
            destDir.mkdir();

        File destPath = new File(destDir.getAbsolutePath()
                + System.getProperty("file.separator") + name + ".jpg");
        try {
            FileUtils
                    .copyFile(((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.FILE), destPath);
        } catch (IOException e) {
            log.error(e);
            throw e;
        }
        log.info(destPath.getAbsolutePath());
        return destPath.getAbsolutePath();
    }

    public String takeScreenShot() {
        log.info("");
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
    }

}
