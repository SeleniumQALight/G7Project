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

    public void WebDriverHelper(){
        if (webDriver == null){
            webDriver = initDriver();
        }
    }

    public WebDriver getWebDriver() {return webDriver;   }

    public void quitDriver() {//закриває весь браузер
        webDriver.quit();
        logger.info("Browser was closed");
    }

    private WebDriver initDriver() {
        String browser = System.getProperty("browser");//передаємо з командної стрічки параметр -Dbrowser=chrome
        if ((browser == null) ||("edge".equals(browser.toLowerCase()))) {   //edge
            WebDriverManager.edgedriver().clearDriverCache().setup();
            webDriver = new EdgeDriver();
        } else if ("firefox".equals(browser.toLowerCase())) {
            WebDriverManager.firefoxdriver().setup();
            webDriver = new FirefoxDriver();
        } else if ("iedriver".equals(browser.toLowerCase())) {   //internet explorer
            WebDriverManager.iedriver().setup(); //zoom 100%
            webDriver = new InternetExplorerDriver();//security level medium
        } else if  ("chrome".equals(browser.toLowerCase())) {//якщо нічого не передали або передали chrome, дефолтний браузер
            WebDriverManager.chromedriver().clearDriverCache().setup();
            webDriver = new ChromeDriver();
        } else {
            throw new IllegalArgumentException("Browser" + browser + "is not supported");//якщо передали невірний браузер
        }
        return webDriver;
    }
}
