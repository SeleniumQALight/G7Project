package bdd.helpers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverHelper {
    WebDriver webDriver;
    Logger logger= Logger.getLogger(getClass());

    public  WebDriverHelper(){
        if (webDriver == null){
            webDriver = initDriver();
        }
    }

    public WebDriver getWebDriver() {return webDriver; }

    public void quitWebDriver() {//закриває весь браузер
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
 //       } else if ("safari".equals(browser.toLowerCase())) { // якщо вказаний як edge -Dbrowser=edge
 //           WebDriverManager.safaridriver().setup();
 //           webDriver = new SafariDriver(); //
        } else if ("edge".equals(browser.toLowerCase())) { // якщо вказаний як edge -Dbrowser=edge
            WebDriverManager.edgedriver().setup();
            webDriver = new EdgeDriver(); //
        } else {
            throw new IllegalArgumentException("Browser " + browser + " is not supported");
        }

        return  webDriver;

    }

}

