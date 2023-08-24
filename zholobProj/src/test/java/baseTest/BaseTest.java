package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import libs.ConfigProvider;
import libs.ScreenShot;
import org.apache.log4j.Logger;
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
    WebDriver webDriver;
    protected PageProvider pageProvider;
    protected Logger logger = Logger.getLogger(getClass());
    protected ArrayList<ScreenShot> listOfScreenShots = new ArrayList<>(); // для того щоб зберігати скріншоти


    @Before
    public void setUp() {
        logger.info("__________________" + testName.getMethodName()  + " was started_________________________"); // для того щоб виводило назву тесту в логах
        WebDriverManager.chromedriver().setup();
  //      webDriver = new ChromeDriver();
   //     webDriver.manage().window().maximize();
        webDriver = initDriver(); // ініціалізуємо драйвер
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT())); // чекаємо макс 10с поки елемент буде клікабельний
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver);

    }
//    @After
//    public void tearDown() {
//        webDriver.quit();
 //       logger.info("Browser was closed");
//        logger.info("__________________" + testName.getMethodName() + " end _________________________");// для того щоб виводило назву тесту в логах
 //   }

    @Rule()
    public final TestWatcher watchman = new TestWatcher() {  // для того щоб виводило назву тесту в логах СКРЫНШОТ
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
                webDriver.quit(); // закриваємо браузер
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
// для скрыншота

    @Rule
    public TestName testName = new TestName();// для того щоб виводило назву тесту в логах


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


