package helper;


import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class NavigateToNewTab {
    static WebDriver driver;

    public static void navigateToNewTab() throws Exception {
        String parent = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> I1 = s1.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                Thread.sleep(500);
                driver.switchTo().window(child_window);

            }
        }
    }

    public static void closeChildWindow() throws Exception {
        String parent = driver.getWindowHandle();
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> I1 = s1.iterator();
        while (I1.hasNext()) {
            String child_window = I1.next();
            if (!parent.equals(child_window)) {
                Thread.sleep(500);
                driver.switchTo().window(child_window).close();

            }
        }
        driver.switchTo().window(parent);
    }


}
