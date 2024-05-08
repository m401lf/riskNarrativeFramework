package helper.select;


import helper.LoggerHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.LinkedList;
import java.util.List;

public class DropDownHelper {
    final static Logger log = LoggerHelper.getLogger(DropDownHelper.class);
    WebDriver driver;

    public DropDownHelper(WebDriver driver) {
        this.driver = driver;
        log.info("DropDownHelper object created..");
    }

    public void selectUsingValue(WebElement element, String value) {
        Select select = new Select(element);
        log.info("selectUsingValue and value is: " + value);
        log.info("selectUsingValue and value is: " + value);
        select.selectByValue(value);
    }

    public void selectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        log.info("selectUsingIndex and index is: " + index);
        log.info("selectUsingIndex and index is: " + index);
        select.selectByIndex(index);
    }

    public void selectUsingVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        log.info("selectUsingVisibleText and visibleText is: " + visibleText);
        log.info("selectUsingVisibleText and visibleText is: " + visibleText);
        select.selectByVisibleText(visibleText);
    }

    public void deSelectUsingValue(WebElement element, String value) {
        Select select = new Select(element);
        log.info("deSelectUsingValue and value is: " + value);
        log.info("deSelectUsingValue and value is: " + value);
        select.deselectByValue(value);
    }

    public void deSelectUsingIndex(WebElement element, int index) {
        Select select = new Select(element);
        log.info("deSelectUsingIndex and index is: " + index);
        log.info("deSelectUsingIndex and index is: " + index);
        select.deselectByIndex(index);
    }

    public void deSelectUsingVisibleText(WebElement element, String visibleText) {
        Select select = new Select(element);
        log.info("deselectByVisibleText and visibleText is: " + visibleText);
        log.info("deselectByVisibleText and visibleText is: " + visibleText);
        select.deselectByVisibleText(visibleText);
    }

    public List<String> getAllDropDownData(WebElement element) {
        Select select = new Select(element);
        List<WebElement> elementList = select.getOptions();
        List<String> valueList = new LinkedList<String>();
        for (WebElement ele : elementList) {
            log.info(ele.getText());
            log.info(ele.getText());
            valueList.add(ele.getText());
        }
        return valueList;
    }

    public void selectByValueFromDropDown(WebElement dropDownElement, String value) {
        Select dropdown = new Select(dropDownElement);
        if (value != null && !(value.isEmpty())) {
            dropdown.selectByValue(value.trim());
        }
    }

    public boolean checkDropdownHasAllTheValues(WebElement dropdownElement, List<List<String>> data) {
        int counter = 0;
        Select dropdown = new Select(dropdownElement);
        List<WebElement> options = dropdown.getOptions();

        for (WebElement valueInDropdown : options) {
            loop:
            for (int i = 0; i < data.get(0).size(); i++) {
                if (valueInDropdown.getText().equals((data.get(0).get(i).trim()))) {
                    counter++;
                    break loop;
                }
            }
        }

        return counter == data.get(0).size();
    }

    public boolean assertFirstValueInDropDown(WebElement dropdownElement, String value) {
        boolean result = true;
        Select dropdown = new Select(dropdownElement);
        result = dropdown.getOptions().get(0).getText().equals(value);
        return result;
    }
}
