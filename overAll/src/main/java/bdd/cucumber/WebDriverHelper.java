package bdd.cucumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverHelper {
   private static WebDriver webDriver;

   // init driver
    public WebDriverHelper() {
        webDriver = initDriver();
    }

    // get driver
    public static WebDriver getWebDriver() {
        return webDriver;
    }

    //close driver
    public static void closeDriver() {
        webDriver.quit();
    }



    // init driver
    private static WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equals(browser.toLowerCase()))) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unknown browser " + browser);
        }
    }
}
