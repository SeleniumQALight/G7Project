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
        System.out.println("User name was inputed");

        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwerty");
        System.out.println("Password was inputed");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");

        // WebElement buttonSignOut = webDriver.findElement(By.xpath(".//button[text()='Sign Out']"));

        Assert.assertTrue("Button is not displayed", isButtonSignOutVisible());


        //webDriver.quit();
        //System.out.println("Browser was closed");

    }


    @After // this annotation means that this method will be executed after each test
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

    private boolean isErrorMessageVisible() {
        try {
            return webDriver.findElement(By.xpath(".//div[text()='Invalid username/password.']")).isDisplayed();
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

    @Test
    public void invalidLogin() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was opened");

        webDriver.get("https://qa-complexapp.onrender.com/");
        System.out.println("Site was opened");

        WebElement inputUserName = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto1");
        System.out.println("Invalid User name was inputed");

        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwerty");
        System.out.println("Password was inputed");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");


        Assert.assertFalse("Button SignOut is displayed, Login successful", isButtonSignOutVisible());
        Assert.assertTrue("Error message is not displayed, Login successful", isErrorMessageVisible());
        Assert.assertFalse("Button SignIn is displayed, Login unsuccessful", isButtonSignInVisible());

    }


}



