package webdriverutilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import utilities.utils.GlobalVars;

import java.time.Duration;
import java.util.HashMap;

public class WebDrv {
    private static WebDrv instance = null;
    private WebDriver webDriver;

    private WebDrv() {
    }

    public static WebDrv getInstance() {
        if (instance == null) {
            instance = new WebDrv();
        }
        return instance;
    }

    public static void setInstance() {
        instance = null;
    }

    public WebDriver openBrowser(String url, DesiredCapabilities caps) {

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("behavior", "allow");
        chromePrefs.put("download.prompt_for_download", false);
        chromePrefs.put("download.default_directory", GlobalVars.APPLICATIONS_DOWNLOAD_FILEPATH);
        System.out.println("Download path set to: " + GlobalVars.APPLICATIONS_DOWNLOAD_FILEPATH);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("prefs", chromePrefs);
        chromeOptions.addArguments("--disable-dev-shm-usage");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--window-size=1920,1080");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-gpu");
        chromeOptions.addArguments("--whitelisted-ips");
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("--test-type");
        //Benjamin Azeta
        chromeOptions.addArguments("--remote-allow-origins=*");
        chromeOptions.addArguments("--headless");
        String osName = System.getProperty("os.name");
        // In gitlab we currently use a specific Chrome version which is not detected
        // correctly by webdriver manager
        if (osName.equalsIgnoreCase("Linux")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver/linux/chromedriverlinux");
        } else {
            WebDriverManager.chromedriver().setup();
        }
        webDriver = new ChromeDriver(chromeOptions);
        WebDriverConfig config = new WebDriverConfig(webDriver);
        config.setPageLoadTimeout(Duration.ofSeconds(6));
        return webDriver;
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}