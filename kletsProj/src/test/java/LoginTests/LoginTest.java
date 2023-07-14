package LoginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;

    @Test
    public void validLogIn() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();//open browser
        webDriver.manage().window().maximize();//all size screen
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // default zatrimka
        System.out.println("Browser is opened");

        webDriver.get("https://qa-complexapp.onrender.com/"); //open site
        System.out.println("Site was opened");

        WebElement inputUsername = webDriver.findElement(By.xpath("//input[@placeholder ='Username']"));
        inputUsername.clear();// clear field
        inputUsername.sendKeys("qaauto");//vvod s klaviaturi
        System.out.println("UserName was inputted");

        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder ='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwerty");
        System.out.println("Password was inputted");

        webDriver.findElement(By.xpath(".//button[@class ='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");

        // WebElement buttonSignOut = webDriver.findElement(By.xpath(".//button[@class ='btn btn-sm btn-secondary']"));

        Assert.assertTrue("Button is not displayed", isButtonSignOutVisible());

        // webDriver.quit();// close browser
        //System.out.println("Browser is closed");
    }

    @After // this method will be executed after each test
    public void tearDown() {
        webDriver.quit();// close browser
        System.out.println("Browser is closed");
    }

    private boolean isButtonSignOutVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[@class ='btn btn-sm btn-secondary']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
