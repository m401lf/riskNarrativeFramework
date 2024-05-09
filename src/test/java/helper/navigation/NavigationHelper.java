/**
 * @author rahul.rathore
 * <p>
 * 07-Aug-2016
 */
package helper.navigation;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utilities.IwebComponent;

import java.net.URL;


public class NavigationHelper implements IwebComponent {
    final static Logger log = LogManager.getLogger(NavigationHelper.class);
    WebDriver driver;

    public NavigationHelper(WebDriver driver) {
        this.driver = driver;
        log.debug("NavigationHelper : " + this.driver.hashCode());
    }

    public void navigateTo(String url) {
        log.info(url);
        driver.get(url);
    }

    public void navigateToURL(URL url) {
        log.info(url.getPath());
        driver.get(url.getPath());
    }

    public String getTitle() {
        String title = driver.getTitle();
        log.info(title);
        return driver.getTitle();
    }

    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        log.info(url);
        return driver.getCurrentUrl();
    }


}
