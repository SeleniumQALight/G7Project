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

        webDriver.get("https://qa-complexapp.onrender.com/");
        System.out.println("site was opened");

        WebElement inputUserName = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("Username was inputted");
        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwerty");
        System.out.println("Password was inputted");
        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");
        Assert.assertTrue("Button is not displayed", isButtonSignOutPresent());
    }

    @Test
    public void invalidLogin() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was opened");

        webDriver.get("https://qa-complexapp.onrender.com/");
        System.out.println("site was opened");

        WebElement inputUserName = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("invalidName");
        System.out.println("Invalid username was inputted");

        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("invalidPassword");
        System.out.println("Invalid password was inputted");

        webDriver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");

        Assert.assertFalse("Sign Out button is displayed", isButtonSignOutPresent());
        Assert.assertTrue("Sign In button is not displayed", isButtonSignInPresent());
        Assert.assertTrue("Invalid username/password message is not displayed", isInvalidCMessagePresent());
    }

    @After // @After - виконується після кожного тесту
    public void tearDown() {
        webDriver.quit();
        System.out.println("Browser was closed");
    }

    private boolean isButtonSignOutPresent() {
        try {
            return webDriver.findElement(By.xpath("//button[contains(text(), 'Sign Out')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isButtonSignInPresent() {
        try {
            return webDriver.findElement(By.xpath("//button[contains(text(), 'Sign In')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isInvalidCMessagePresent() {
        try {
            return webDriver.findElement(By.xpath("//div[contains(@class, 'alert alert-danger text-center') and contains(text(), 'Invalid username  pasword')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}

