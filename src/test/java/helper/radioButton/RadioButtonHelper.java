package helper.radioButton;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class RadioButtonHelper {

    WebDriver driver;

    public RadioButtonHelper(WebDriver driver) {
        this.driver = driver;
    }


    public void selectRadioButtons(List<WebElement> radioButtons, int i) {
        for (i = 0; i < radioButtons.size(); i++) {
            radioButtons.get(i).click();
        }
    }

    public void assertRadioButtonsAreMutuallyExclusive(List<WebElement> radioList) {
        for (int i = 0; i < radioList.size(); i++) {
            WebElement selected = radioList.get(i);
            selected.click();
            for (int j = 0; j < radioList.size(); j++) {
                if (!(radioList.get(j).equals(selected))) {
                    Assert.assertFalse(radioList.get(j).isSelected());
                }
            }
        }

    }
}