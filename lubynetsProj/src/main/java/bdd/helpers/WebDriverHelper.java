package bdd.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverHelper {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public WebDriverHelper() {
        if (webDriver == null) {
            webDriver = initDriver();
        }
    }
    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void quitDriver() {
            webDriver.quit();
            logger.info("Browser was closed");
        }

    private WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equals(browser.toLowerCase()))) {
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("iedriver".equals(browser.toLowerCase())) {
            WebDriverManager.iedriver().setup(); // zoom 100%
            webDriver = new InternetExplorerDriver();//level of security - Medium
        } else if ("edgedriver".equals(browser.toLowerCase())) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        } else if ("safari".equals(browser.toLowerCase())) {
            WebDriverManager.getInstance(SafariDriver.class).setup();
            webDriver = new SafariDriver();
        } else {
            throw new IllegalArgumentException("Can't init driver for browser " + browser);
        }

        return webDriver;
    }
}
