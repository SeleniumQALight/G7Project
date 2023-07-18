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

public class LoginTests {

    WebDriver webDriver;

    @Test
    public void validLoginIn() {

        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was  opened");

        webDriver.get("https://qa-complexapp.onrender.com");
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

        // WebElement buttonSignOut = webDriver.findElement(By.xpath(".//button[text()='Sign Out']"));

        Assert.assertTrue("button is not displayed", isButtonSignOutVisible());



        //webDriver.quit();
       // System.out.println("Browser was closed");
    }
    @After
    public void tearDown() {
        webDriver.quit();
        System.out.println("Browser was closed");
    }
    @Test
    public void invalidLoginIn() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        System.out.println("Browser was opened");

        webDriver.get("https://qa-complexapp.onrender.com");
        System.out.println("Site was opened");

        WebElement inputUserName = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("Username was inputted");

        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwert");
        System.out.println(" Invalid password was inputted");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");

        Assert.assertTrue("Sign in button is not displayed", isButtonSignInVisible());
        System.out.println("Sign in button is displayed");
        Assert.assertFalse("Sign out button is displayed", isButtonSignOutVisible());//
        System.out.println("Sign out button is not displayed");
        Assert.assertTrue("Error message is not displayed", isInvalidDataMessegeVisible());
        System.out.println("Error message is displayed");

    }


    private boolean isButtonSignInVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[text()='Sign In']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isButtonSignOutVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[text()='Sign Out']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    private boolean isInvalidDataMessegeVisible() {
        try {
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            return webDriver.findElement(By.xpath("//div[contains(text(),'Invalid username/password.')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }


}


