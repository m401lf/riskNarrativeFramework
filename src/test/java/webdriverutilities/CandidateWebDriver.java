package webdriverutilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;

public class CandidateWebDriver {
    private static CandidateWebDriver instance = null;
    private WebDriver webDriver;

    private CandidateWebDriver() {
    }

    public static CandidateWebDriver getInstance() {
        if (instance == null) {
            instance = new CandidateWebDriver();
        }
        return instance;
    }

    public WebDriver openBrowser(String url, DesiredCapabilities caps) throws MalformedURLException {
        webDriver = WebDriverConfig
                .configureAndOpenBrowser(url, caps,
                        webDriver);
        return webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

}
