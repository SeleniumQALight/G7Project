package baseTest;

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
import libs.ScreenShot;




public class BaseTest {
    public final static String SHORT_USER_NAME = "tr";
    WebDriver webDriver;
    protected PageProvider pageProvider;
    protected Logger logger = Logger.getLogger(getClass());
    protected ArrayList<ScreenShot> listOfScreenShots = new ArrayList<>();


    @Before
    public void setUp() {
        logger.info("-----" + testName.getMethodName() + " was started ----");
        webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));//замість 5 секунд
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver);
    }

//    @After
//    public void tearDown() {
//        webDriver.quit();
//        logger.info("Browser was closed");
//        logger.info("-----" + testName.getMethodName() + " was stop ----");
//    }

    @Rule()//order = Integer.MIN_VALUE)
    public final TestWatcher watchman = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }

        public void saveScreenshot(ArrayList<ScreenShot> screenShots) {
            screenShots.forEach(screenShot -> Allure.addAttachment(screenShot.getName(),
                    new ByteArrayInputStream(screenShot.getScreenShotImg())));
        }

        public void screenshot() {//
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
    //------------------------


    @Rule
    public TestName testName = new TestName();


    private WebDriver initDriver() {
        String browser = System.getProperty("browser");//передаємо з командної стрічки параметр -Dbrowser=chrome
        if ((browser == null) || ("chrome".equals(browser.toLowerCase()))) {//якщо нічого не передали або передали chrome, дефолтний браузер
            WebDriverManager.chromedriver().setup();
             webDriver = new ChromeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
             webDriver = new FirefoxDriver();
        } else if ("iedriver".equals(browser.toLowerCase())) {   //internet explorer
            WebDriverManager.iedriver().setup(); //zoom 100%
             webDriver = new InternetExplorerDriver();//security level medium
        } else if ("edge".equals(browser.toLowerCase())) {   //edge
            WebDriverManager.edgedriver().setup();
             webDriver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser" + browser + "is not supported");//якщо передали невірний браузер
        }
        return webDriver;
    }
}

