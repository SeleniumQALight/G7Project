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

public class LoginTests {
    WebDriver webDriver;

    @Test
    public void validLogin() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was open");
        webDriver.get("https://qa-complexapp.onrender.com/");
        System.out.println("site was opened");

        WebElement inputUserName = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("UserName was inputted");

        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwerty");
        System.out.println("Password was inputted");
        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");

        //WebElement buttonSignOut = webDriver.findElement(By.xpath(".//button[text()='Sign Out']"));


        Assert.assertTrue("Button is not displayed", isButtonSignOutVisible());
    }

    @Test
    public void invalidLogin() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was open");
        webDriver.get("https://qa-complexapp.onrender.com/");
        System.out.println("site was opened");

        WebElement inputUserNameFalse = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserNameFalse.clear();
        inputUserNameFalse.sendKeys("qaauto");
        System.out.println("UserName was inputted");

        WebElement inputPasswordFalse = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPasswordFalse.clear();
        inputPasswordFalse.sendKeys("123456qwert");
        System.out.println("Password was inputted");
        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");
        Assert.assertFalse("SignOut button is there", isButtonSignOutVisible());
        Assert.assertTrue("Button SignIn is there", isButtonSignInVisible());
        Assert.assertTrue("Invalid login message", isInvalideLoginVisible());


    }


    // webDriver.quit();
    //System.out.println("Browser was closed");

    @After//this method will be executed after each test
    public void tearDown() {
        webDriver.quit();
        System.out.println("Browser was closed");
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

    private boolean isInvalideLoginVisible() {
        try {
            return webDriver.findElement(By.xpath(".//div[text()='Invalid username/password.']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
