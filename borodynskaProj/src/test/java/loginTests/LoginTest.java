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

public class LoginTest{
    WebDriver webDriver;
    @Test
    public void validLogIn(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was opened");
        webDriver.get("https://qa-complexapp.onrender.com/");
        System.out.println("Site was opened");

        WebElement inputUserName =
                webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("yuliiaborodynska");
        System.out.println("UserName was inputted");

        WebElement inputPassword =
                webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123Qwertyasd");
        System.out.println("Password was inputted");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");

//        WebElement buttonSignOut =
//                webDriver.findElement(By.xpath(".//button[text()='Sign Out']"));

        Assert.assertTrue("Button is not displayed", isButtonSignOutVisible());

//        webDriver.quit();
//        System.out.println("Browser was closed");
    }

    @After
public void tearDown(){
        webDriver.quit();
        System.out.println("Browser was closed");
    }

    @Test
    public void invalidLogIn() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was opened");
        webDriver.get("https://qa-complexapp.onrender.com/");
        System.out.println("Site was opened");

        WebElement inputUserName =
                webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("yuliiaborodynsk");
        System.out.println("UserName was inputted");

        WebElement inputPassword =
                webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123Qwertyasd");
        System.out.println("Password was inputted");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");

        Assert.assertFalse("Sign-out button is visible", isButtonSignOutVisible());
        System.out.println("Sign-out button is not visible");
        Assert.assertTrue("Sign-in button is not visible", isButtonSignInVisible());
        System.out.println("Sign-in button is visible");
        Assert.assertTrue("Alert is not visible", isAlertVisible());
        System.out.println("Alert is visible");
    }

private boolean isButtonSignOutVisible() {
    try {
        return webDriver.findElement(By.xpath(".//button[text()='Sign Out']")).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

private boolean isButtonSignInVisible() {
    try {
        return webDriver.findElement(By.xpath(".//button[text()='Sign In']")).isDisplayed();
    } catch (Exception e) {
        return false;
    }

    }

private boolean isAlertVisible() {
    try {
        return webDriver.findElement(By.xpath(".//div[text()='Invalid username/password.']")).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

}
