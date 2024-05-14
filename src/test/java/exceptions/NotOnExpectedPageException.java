package exceptions;


import helper.PageException;
import org.openqa.selenium.WebDriver;

public class NotOnExpectedPageException extends Exception {

    static WebDriver driver;

    public NotOnExpectedPageException(String message) {
        super(message);
    }

    public static void checkIfOnTheCorrectPageOtherwiseThrowException(String pageUrl, String exceptionMessage)
            throws NotOnExpectedPageException, PageException {
        if (!isCurrentPageTheExpectedPage(pageUrl)) {
            throw new NotOnExpectedPageException(exceptionMessage);
        }
    }

    private static boolean isCurrentPageTheExpectedPage(String pageUrl) throws PageException {
        return driver.getCurrentUrl().equals(pageUrl);
    }
}
