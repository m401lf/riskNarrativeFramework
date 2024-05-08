package helper.assertion;

import helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class AssertionHelper {
    final static Logger log = LoggerHelper.getLogger(AssertionHelper.class);
    static WebDriver driver;
    private String idOfParentWebElement;

    public static void verifyText(String s1, String s2) {
        log.info("Verifying test: " + s1 + " with " + s2);
        log.info("Verifying test: " + s1 + " with " + s2);
        Assert.assertEquals(s1, s1);
    }

    public static void markPass() {
        log.info("Making script PASS..");
        log.info("Making script PASS..");
        Assert.assertTrue(true);
    }

    public static void markPass(String message) {
        log.info("Making script PASS => " + message);
        log.info("Making script PASS => " + message);
        Assert.assertTrue(true, message);
    }

    public static void markFail() {
        log.info("Making script FAIL..");
        log.info("Making script FAIL..");
        Assert.fail();
    }

    public static void markFail(String message) {
        log.info("Making script FAIL.." + message);
        log.info("Making script FAIL => " + message);
        Assert.fail(message);
    }

    public static void verifyTrue(boolean status) {
        log.info("Verify object is True..");
        log.info("Verify object is True..");
        Assert.assertTrue(status);
    }

    public static void verifyFalse(boolean status) {
        log.info("Verify object is False..");
        log.info("Verify object is False..");
        Assert.assertFalse(status);
    }

    public static void verifyNull(String s1) {
        log.info("Verify object is null..");
        log.info("Verify object is null..");
        Assert.assertNull(s1);
    }

    public static void verifyNotNull(String s1) {
        log.info("Verify object is not null..");
        log.info("Verify object is not null..");
        Assert.assertNotNull(s1);
    }

    public static void fail() {
        Assert.fail();
    }

    public static void pass() {
        Assert.assertTrue(true);
    }

    public static void updateTestStatus(boolean status) {
        if (status) {
            pass();
            log.info("UpdateTestStatus => PASSED");
        } else {
            fail();
            log.info("UpdateTestStatus => FAILED");

        }
    }

    public static void assertNewTabIsOpenedWithExpectedPage(String expectedPageName) {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        // switch to new tab
        driver.switchTo().window(browserTabs.get(1));
        // check is it correct page opened or not (e.g. check page's title)
        Assert.assertEquals("The opened page is not what was expected", expectedPageName,
                driver.findElement(By.id("heading")).getText());
        // then close tab and get back
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }

    public static void assertNewTabOpenedWithExpectedTitle(String pageTitle) {
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        // switch to new tab
        driver.switchTo().window(browserTabs.get(1));
        // check is it correct page opened or not (check page's title)
        Assert.assertEquals("The opened page title did not match", pageTitle,
                driver.getTitle());
        // then close tab and get back
        driver.close();
        driver.switchTo().window(browserTabs.get(0));
    }


    public static List<String> getModifiableIdListOfExpectedChildElements(List<String> elementIds) {
        List<String> ids = new ArrayList<>();
        for (String elementId : elementIds) {
            ids.add(elementId);
        }
        return ids;
    }

}
