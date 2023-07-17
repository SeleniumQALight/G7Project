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
    public void validLoginIn() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was opened");

        webDriver.get("https://qa-complexapp.onrender.com");
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
        System.out.println("Browser was opened");

        webDriver.get("https://qa-complexapp.onrender.com");
        System.out.println("site was opened");
        WebElement inputUserName = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("UserName was inputted");

        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwert");
        System.out.println("Password was inputted");

        WebElement buttonLogin = webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']"));
        buttonLogin.click();
        System.out.println("Button was clicked");

        Assert.assertTrue("Sign in button is not displayed", isButtonSignInVisible());
        System.out.println("Sign in button is displayed");

        Assert.assertTrue("Error message is not displayed", isErrorMessageVisible());
        System.out.println("Error message is displayed");

        Assert.assertFalse("Button Sign Out is displayed, but should not", isButtonSignOutVisible());
        System.out.println("Button Sign Out is not displayed");


    }

    // webDriver.quit();
    //System.out.println("browser was closed");
    @After//this
    public void tearDown() {
        webDriver.quit();
        System.out.println("browser was closed");
    }

    public boolean isButtonSignOutVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[@class='btn btn-sm btn-secondary']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


    private boolean isButtonSignInVisible() {
        try {
            return webDriver.findElement(By.xpath(".//*[@class='btn btn-primary btn-sm']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isErrorMessageVisible() {
        try {
            return webDriver.findElement(By.xpath(".//*[@class='alert alert-danger text-center']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

}
