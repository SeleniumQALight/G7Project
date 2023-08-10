package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pages.PageProvider;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;



public class BaseTest {
    WebDriver webDriver;
    protected PageProvider pageProvider;
    protected Logger logger = Logger.getLogger(getClass());


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT())); // чекаємо макс 10с поки елемент буде клікабельний
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver);

    }
    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }


}


