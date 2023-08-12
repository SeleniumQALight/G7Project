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
import org.openqa.selenium.safari.SafariDriver;
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
  //      webDriver = new ChromeDriver();
   //     webDriver.manage().window().maximize();
        webDriver = initDriver(); // ініціалізуємо драйвер
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT())); // чекаємо макс 10с поки елемент буде клікабельний
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver);

    }
    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }

    private WebDriver initDriver () { // метод для ініціалізації драйвера
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equals(browser.toLowerCase()))) { // якщо браузер не вказаний або вказаний як chrome -Dbrowser=chrome
            WebDriverManager.chromedriver().setup();
            webDriver = new ChromeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) { // якщо вказаний як firefox -Dbrowser=firefox
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("ie".equals(browser.toLowerCase())) { // якщо вказаний як ie -Dbrowser=ie
            WebDriverManager.iedriver().setup();
            webDriver = new InternetExplorerDriver(); // zoom 100%
        } else if ("safari".equals(browser.toLowerCase())) { // якщо вказаний як edge -Dbrowser=edge
            WebDriverManager.safaridriver().setup();
            webDriver = new SafariDriver(); //
        } else if ("edge".equals(browser.toLowerCase())) { // якщо вказаний як edge -Dbrowser=edge
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver(); //
        } else {
            throw new IllegalArgumentException("Browser " + browser + " is not supported");
        }

            return  webDriver;

    }

}


