package helper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import webdriverutilities.WebDrv;

public class ActionClass {

    public static void selectFirstWord(WebElement elementName) {
        Actions action = new Actions(WebDrv.getInstance().getWebDriver());
        action.moveToElement(elementName, 0, 0).click().doubleClick().build().perform(); //selects first word

    }


}
