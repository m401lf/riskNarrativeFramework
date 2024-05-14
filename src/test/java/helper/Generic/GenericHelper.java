package helper.Generic;

import helper.LoggerHelper;
import helper.resource.ResourceHelper;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import utilities.DateTimeHelper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

//public class GenericHelper implements IwebComponent {
public class GenericHelper {
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

    public WebElement getElement(String locator, String type) {
        type = type.toLowerCase();
        if (type.equals("id")) {
            System.out.println("Element found with id: " + locator);
            return this.driver.findElement(By.id(locator));
        } else if (type.equals("name")) {
            System.out.println("Element found with name: " + locator);
            return this.driver.findElement(By.name(locator));
        } else if (type.equals("xpath")) {
            System.out.println("Element found with xpath: " + locator);
            return this.driver.findElement(By.xpath(locator));
        } else if (type.equals("css")) {
            System.out.println("Element found with css: " + locator);
            return this.driver.findElement(By.cssSelector(locator));
        } else if (type.equals("classname")) {
            System.out.println("Element found with classname: " + locator);
            return this.driver.findElement(By.className(locator));
        } else if (type.equals("tagname")) {
            System.out.println("Element found with tagname: " + locator);
            return this.driver.findElement(By.tagName(locator));
        } else if (type.equals("linktext")) {
            System.out.println("Element found with link text: " + locator);
            return this.driver.findElement(By.linkText(locator));
        } else if (type.equals("partiallinktext")) {
            System.out.println("Element found with partial link text: " + locator);
            return this.driver.findElement(By.partialLinkText(locator));
        } else {
            System.out.println("Locator type not supported");
            return null;
        }
    }

    public List<WebElement> getElementList(String locator, String type) {
        type = type.toLowerCase();
        List<WebElement> elementList = new ArrayList<WebElement>();
        if (type.equals("id")) {
            elementList = this.driver.findElements(By.id(locator));
        } else if (type.equals("name")) {
            elementList = this.driver.findElements(By.name(locator));
        } else if (type.equals("xpath")) {
            elementList = this.driver.findElements(By.xpath(locator));
        } else if (type.equals("css")) {
            elementList = this.driver.findElements(By.cssSelector(locator));
        } else if (type.equals("classname")) {
            elementList = this.driver.findElements(By.className(locator));
        } else if (type.equals("tagname")) {
            elementList = this.driver.findElements(By.tagName(locator));
        } else if (type.equals("linktext")) {
            elementList = this.driver.findElements(By.linkText(locator));
        } else if (type.equals("partiallinktext")) {
            elementList = this.driver.findElements(By.partialLinkText(locator));
        } else {
            System.out.println("Locator type not supported");
        }
        if (elementList.isEmpty()) {
            System.out.println("Element not found with " + type + ": " + locator);

        } else {
            System.out.println("Element found with " + type + ": " + locator);
        }
        return elementList;
    }

    public boolean isElementPresent(String locator, String type) {
        List<WebElement> elementList = getElementList(locator, type);

        int size = elementList.size();

        return size > 0;
    }

}
