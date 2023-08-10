package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import pages.PageProvider;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class BaseTest {
    public final static String SHORT_USER_NAME = "tr";
    WebDriver webDriver;
    protected PageProvider pageProvider;
    protected Logger logger = Logger.getLogger(getClass());


    @Before
    public void setUp() {
        webDriver = initDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));//замість 5 секунд
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver);

    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }

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

