package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helper.LoggerHelper;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.TopMenuNavigationPage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.*;

public class BaseTest {
    final static Logger log = LoggerHelper.getLogger(BaseTest.class);
    public static File reportDirectory;
    public static ExtentReports extent;
    public static ExtentTest test;
    public static WebDriver driver;
    public Properties prop;
    public Properties p;
    public Properties dataProp;
    TopMenuNavigationPage naviPage;
    private String url;

    public WebDriver initializeDriver() throws IOException {

        // loading properties file
        FileReader file = new FileReader(System.getProperty("user.dir") + "//src//test//java//testData//GlobalData.properties");
        p = new Properties();
        p.load(file);

        // properties class
        prop = new Properties();
        File propFile = new File(System.getProperty("user.dir") + "//src//test//java//testData//GlobalData.properties");


        dataProp = new Properties();
        File dataPropFile = new File(System.getProperty("user.dir") + "//src//test//java//testData//testData.properties");

        try {
            FileInputStream fis = new FileInputStream(propFile);
            prop.load(fis);
        } catch (Throwable e) {
            e.printStackTrace();
        }

        try {
            FileInputStream dataFis = new FileInputStream(dataPropFile);
            dataProp.load(dataFis);
        } catch (Throwable e) {
            e.printStackTrace();
        }


        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
        if (browserName.contains("chrome")) {
            driver = new ChromeDriver();

            // Firefox
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();

        } else if (browserName.equalsIgnoreCase("edge")) {
            // Edge
            driver = new EdgeDriver();
        }

        //driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return driver;

    }

    public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException {
        //read json to string
        String jsonContent = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        //String to HashMap- Jackson Databind
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonContent, new TypeReference<>() {
        });

    }

    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir") + "//extentReports//" + testCaseName + ".png");
        FileUtils.copyFile(source, file);
        return System.getProperty("user.dir") + "//extentReports//" + testCaseName + ".png";
    }

    @BeforeMethod(alwaysRun = true)
    public TopMenuNavigationPage launchApplication(String url) throws IOException {
        driver = initializeDriver();
        getApplicationUrl(url);
        naviPage = new TopMenuNavigationPage();
        return naviPage;
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        log.info("Quitting the browser.....");
        driver.quit();

    }

    public void getApplicationUrl(String url) {
        driver.get(url);
        log.info("navigating to ..." + url);
    }


    public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver wd) {
                // This will tel if page is loaded
                return "complete".equals(((JavascriptExecutor) wd).executeScript("return document.readyState"));
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        // Wait for page complete
        wait.until(pageLoadCondition);
        // Lower implicitly wait time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    private boolean existsElement(WebElement element) {
        try {
            element.getText();
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }

    public void getScreenshot(WebElement element) throws IOException {
        File srcScreenShot = element.getScreenshotAs(OutputType.FILE);
        FileHandler.copy(srcScreenShot, new File(System.getProperty("user.dir") + "//screenShots/screenShot.png"));
    }

    public String captureScreen(String fileName, WebDriver driver) {
        if (BaseTest.driver == null) {
            log.info("driver is null..");
            return null;
        }
        if (Objects.equals(fileName, "")) {
            fileName = "blank";
        }
        File destFile = null;
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
        File screFile = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
        try {
            destFile = new File(reportDirectory + "/" + fileName + "_" + formater.format(calendar.getTime()) + ".png");
            Files.copy(screFile.toPath(), destFile.toPath());
            Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath() + "'height='100' width='100'/></a>");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return destFile.toString();
    }


}
