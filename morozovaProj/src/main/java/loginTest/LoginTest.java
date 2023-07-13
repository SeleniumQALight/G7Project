package loginTest;

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
    public void validLoginIn() {
        WebDriverManager.chromedriver().setup();//maven zarune chromedriver
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
        System.out.println("Browser was opened");
        webDriver.get("https://qa-complexapp.onrender.com");
        System.out.println("Site was opened");
        WebElement inputUserName =
                webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("Username was inputted");
        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwerty");
        System.out.println("Password was inputted");
        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");
//        WebElement buttonSignOut = webDriver.findElement(By.xpath(".//button [text()= 'Sign Out']"));
        Assert.assertTrue("Button is not displayed", isButtonSignOutVisible());

//        webDriver.quit();
//        System.out.println("Browser was closed");

    }
    @After //this method will be executed after each test
    public void tearDown() {
        webDriver.quit();
        System.out.println("Browser was closed");
    }


    private boolean isButtonSignOutVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button [text()= 'Sign Out']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
//    @Test
//public void invalidLoginIn() {
//        WebDriverManager.chromedriver().setup();//maven zarune chromedriver
//        webDriver = new ChromeDriver();
//        webDriver.manage().window().maximize();
//        webDriver.manage().timeouts().implicitlyWait(55, TimeUnit.SECONDS);
//        System.out.println("Browser was opened");
//        webDriver.get("https://qa-complexapp.onrender.com");
//        System.out.println("Site was opened");
//        WebElement inputUserName =
//                webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
//        inputUserName.clear();
//        inputUserName.sendKeys("qaauto");
//        System.out.println("Username was inputted");
//        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
//        inputPassword.clear();
//        inputPassword.sendKeys("123456qwerty");
//        System.out.println("Password was inputted");
//        webDriver.findElement(By.xpath(".//button[text()='Sign In']")).click();
//        System.out.println("Button was clicked");
//        WebElement buttonSignOut = webDriver.findElement(By.xpath(".//button [text()= 'Sign Out']"));
//        Assert.assertTrue("Button is not displayed", isButtonSignOutVisible());
//
//        webDriver.quit();
//        System.out.println("Browser was closed");
//
//    }

}