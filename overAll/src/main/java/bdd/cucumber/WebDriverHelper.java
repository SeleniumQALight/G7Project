package bdd.cucumber;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverHelper {
   private  WebDriver webDriver;

   // init driver
    public WebDriverHelper() {
        if (webDriver == null) {
            webDriver = initDriver();
        }
    }

    // get driver
    public WebDriver getWebDriver() {
        return webDriver;
    }

    //close driver
    public void closeDriver() {
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
