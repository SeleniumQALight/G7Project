package baseTest;

//*
// Class BaseTest is a parent class for all tests. It contains setUp() and tearDown() methods.
// To set up the logger:
//      1. Add log4j dependency to pom.xml
//      2. Create log4j.properties file in src/main/resources
//      3. Add logger to BaseTest.java
// */

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageProvider;

import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;
    protected PageProvider pageProvider;
    Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //time to wait for work with particular element.
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver);

    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }
}
