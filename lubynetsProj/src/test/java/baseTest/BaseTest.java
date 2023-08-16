package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PageProvider;

import java.time.Duration;

import static java.time.Duration.ofSeconds;


public class BaseTest {
    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected PageProvider pageProvider;

    @Before
    public void setUp() {
       WebDriver webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));
        WebDriverWait wait = new WebDriverWait(webDriver, ofSeconds(5));
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver);
    }

    @After
    public void tearDown() {
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
        } else if("iedriver".equals(browser.toLowerCase())) {
            WebDriverManager.iedriver().setup(); // zoom 100%
            webDriver = new InternetExplorerDriver();//level of security - Medium
        }
        else if("edgedriver".equals(browser.toLowerCase())) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        }
        else if ("safari".equals(browser.toLowerCase())) {
            WebDriverManager.getInstance(SafariDriver.class).setup();
            webDriver = new SafariDriver();
        }
        else {
            throw new IllegalArgumentException("Can't init driver for browser " + browser);
        }

        return  webDriver;
    }


}
