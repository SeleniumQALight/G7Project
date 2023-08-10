package baseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.PageProvider;

import java.time.Duration;

public class BaseTest {
    WebDriver webDriver;
    public PageProvider pageProvider;
    Logger logger = Logger.getLogger(getClass());

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        logger.info("Browser was opened");
        pageProvider = new PageProvider(webDriver);
    }

    public void openNewTab() {
        webDriver.switchTo().newWindow(WindowType.TAB);
    }

    public void closeCurrentTab() {
        webDriver.close();
    }

    public void switchToTab(int tabNumber) {
        webDriver.switchTo().window(webDriver.getWindowHandles().toArray()[tabNumber].toString());
    }

    public void switchToFirstTabAndRefresh() {
        switchToTab(0);
        webDriver.navigate().refresh();
    }

    @After
    public void tearDown() {
        webDriver.quit();
        logger.info("Browser was closed");
    }
}
