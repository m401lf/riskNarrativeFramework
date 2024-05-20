package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ExtentReporterNG {


    public static ExtentReports getReportObject() {
        String path = System.getProperty("user.dir") + "//extentReports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);

        reporter.config().setReportName("risk.lexisnexis.com");
        reporter.config().setDocumentTitle("Test Results");
        reporter.config().setEncoding("utf-8");
        reporter.config().setCss("js-string");
        reporter.config().setProtocol(Protocol.HTTPS);
        reporter.config().setTheme(Theme.DARK);
        //reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setTimeStampFormat("MMM dd, yyyy HH:mm:ss");
        reporter.config().isTimelineEnabled();
        reporter.config().setTimelineEnabled(true);

        Properties configProp = new Properties();
        File configPropFile = new File(
                System.getProperty("user.dir") + "//src//test//java//config//configfile//config.properties");
        try {
            FileInputStream fisConfigProp = new FileInputStream(configPropFile);
            configProp.load(fisConfigProp);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        ExtentTest Extenttest = extent.createTest("Testing");
        Extenttest.pass("PASSED");
        extent.setSystemInfo("Automation Tester", "Ben Zeta");
        extent.setSystemInfo("Application URL", "risk.lexisnexis.com");
        extent.setSystemInfo("Browser Name", "Chrome");
        extent.setSystemInfo("Email", "benazeta70@gmail.com");
        extent.setSystemInfo("Password", "");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("Username", System.getProperty("user.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));

        return extent;


    }
}
