package loginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.checkerframework.checker.units.qual.A;
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

        WebElement inputUsername = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUsername.clear();
        inputUsername.sendKeys("qaauto");
        System.out.println("UserName was inputted");

        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("12345qwerty");
        System.out.println("Password was inputted");

        WebElement signInButton = webDriver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']"));
        signInButton.click();
        System.out.println("Button was clicked");

//        WebElement singOutButton = webDriver.findElement(By.xpath(".//button[text()='Sign Out']"));


        Assert.assertTrue("Button is displayed", isButtonSignOutVisible());

        webDriver.quit();
        System.out.println("Browser was closed");
    }

    @Test
    public void unValidLogin(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://aqa-complexapp.onrender.com/");
        System.out.println("Site was opened");

        WebElement inputUsername = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUsername.clear();
        inputUsername.sendKeys("qaauto");
        System.out.println("UserName was inputted");

        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("12345qwery");
        System.out.println("Password was inputted");

        WebElement signInButton = webDriver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']"));
        signInButton.click();
        System.out.println("Button was clicked");

        Assert.assertFalse("Button is displayed", isButtonSignOutVisible());
        Assert.assertTrue("Button is not displayed", isButtonSignInVisible());
        Assert.assertTrue("Validation is not displayed", isValidationVisible());

        webDriver.quit();
        System.out.println("Browser was closed");
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }

    private boolean isButtonSignOutVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[text()='Sign Out']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isButtonSignInVisible(){
        try {
            return webDriver.findElement(By.xpath("//button[text()='Sign In']")).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    private boolean isValidationVisible(){
        try {
            return webDriver.findElement(By.xpath("//div[text()='Invalid username / pasword']")).isDisplayed();
        } catch (Exception e){
            return false;
        }
    }
}
