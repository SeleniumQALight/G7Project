package baseTest;

//*
// Class BaseTest is a parent class for all tests. It contains setUp() and tearDown() methods.
// To set up the logger:
//      1. Add log4j dependency to pom.xml
//      2. Create log4j.properties file in src/main/resources
//      3. Add logger to BaseTest.java
// */

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import libs.ConfigProvider;
import libs.ScreenShot;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import pages.PageProvider;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.ArrayList;

public class BaseTest {
    protected ArrayList<ScreenShot> listOfScreenShots = new ArrayList<>();
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

//    @After
//    public void tearDown() {
//        logger.info("Test " + testName.getMethodName() + " was finished");
//        webDriver.quit();
//        logger.info("Browser was closed");
//        logger.info("---------------------");
//    }
@Rule()
public final TestWatcher watchman = new TestWatcher() {
    @Override
    protected void failed(Throwable e, Description description) {
        screenshot();
    }

    public void saveScreenshot(ArrayList<ScreenShot> screenShots) {
        screenShots.forEach(screenShot -> Allure.addAttachment(screenShot.getName(),
                new ByteArrayInputStream(screenShot.getScreenShotImg())));
    }

    public void screenshot() {
        if (webDriver == null) {
            logger.info("Driver for screenshot not found");
            return;
        }
        byte[] screen = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        listOfScreenShots.add(new ScreenShot("Default screenShot after failed test", screen));
        saveScreenshot(listOfScreenShots);
    }

    @Override
    protected void finished(Description description) {
        logger.info(
                String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
        try {
            webDriver.quit();
            logger.info("Browser was closed");
        } catch (Exception e) {
            logger.error(e);
        }
    }

};

    protected void takeScreenshot() {
        System.out.println("screenshot was taken");
        byte[] screen = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
        listOfScreenShots.add(new ScreenShot(testName.getMethodName() + "_after", screen));
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
