package baseTest;

//*
// Class BaseTest is a parent class for all tests. It contains setUp() and tearDown() methods.
// To set up the logger:
//      1. Add log4j dependency to pom.xml
//      2. Create log4j.properties file in src/main/resources
//      3. Add logger to BaseTest.java
// */

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.PageProvider;

import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;
    protected PageProvider pageProvider;
    Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() {
        logger.info("---------------------");
        logger.info("Test " + testName.getMethodName() + " was started");
        //WebDriverManager.chromedriver().setup();
        //webDriver = new ChromeDriver();
        webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT())); //time to wait for work with particular element.
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver);

    }

    @Rule
    public TestName testName = new TestName();

    @After
    public void tearDown() {
        logger.info("Test " + testName.getMethodName() + " was finished");
        webDriver.quit();
        logger.info("Browser was closed");
        logger.info("---------------------");
    }

    private WebDriver initDriver() {
        String browser = System.getProperty("browser");
        if ((browser == null) || browser.equalsIgnoreCase("chrome")) { //if browser is not specified or browser is chrome -Dbrowser=chrome
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("ie".equals(browser.toLowerCase())) {
            WebDriverManager.iedriver().setup(); //zoom level should be 100%, security level - medium, protected mode should be enabled for all zones
            webDriver = new InternetExplorerDriver();
        } else if ("edge".equals(browser.toLowerCase())) {
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver();
        } else if ("safari".equals(browser.toLowerCase())) {
            WebDriverManager.safaridriver().setup(); //zoom level should be 100%, security level - medium, protected mode should be enabled for all zones
            webDriver = new SafariDriver();
        }
        else {
            throw new IllegalArgumentException("Browser " + browser + " is not supported");
        }
        return webDriver;
    }



}
