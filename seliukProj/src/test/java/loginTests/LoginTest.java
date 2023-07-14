package loginTests;

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
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was opened");

        webDriver.get("https://qa-complexapp.onrender.com/");
        System.out.println("Site was opened");

        WebElement inputUserName = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("UserName was inputted");

        WebElement inputPassWord = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassWord.clear();
        inputPassWord.sendKeys("123456qwerty");
        System.out.println("PassWord was inputted");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button 'LogIn' was clicked");

        //WebElement buttonSignOut = webDriver.findElement(By.xpath(".//button[@class=\"btn btn-sm btn-secondary\"]"));
        Assert.assertTrue("Button is not displayed", isButtonSignOutVisible());

        //webDriver.quit();
        //System.out.println("Browser was closed");
    }

    @After // this method will be executed after each test
    public void tearDown() {
        webDriver.quit();
        System.out.println("Browser was closed");
    }

    private boolean isButtonSignOutVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[@class=\"btn btn-sm btn-secondary\"]"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
