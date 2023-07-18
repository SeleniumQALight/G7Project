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
        inputUserName.sendKeys("dariak");
        System.out.println("User name was inputted");

        WebElement inputUserPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputUserPassword.clear();
        inputUserPassword.sendKeys("123456qwerty");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");

//        WebElement buttonSingOut = webDriver.findElement(By.xpath(".//button[text()='Sign Out']"));
        Assert.assertTrue("Button 'Sign Out' is not displayed ", isButtonSignOutVisible());


//        webDriver.quit();
//        System.out.println("Browser was closed");
    }

    @After //
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

    @Test

    public void invalidLoginIn() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was opened");

        webDriver.get("https://qa-complexapp.onrender.com/");
        System.out.println("site was opened");

        WebElement inputUserName = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("dariak");
        System.out.println("User name was inputted");

        WebElement inputUserPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputUserPassword.clear();
        inputUserPassword.sendKeys("123456qwert");

        webDriver.findElement(By.xpath(".//button[text()='Sign In']")).click();
        System.out.println("Button was clicked");

        Assert.assertTrue("Message - Invalid username/password.", isMessageInvalidUsernamePasswordVisible());
        Assert.assertTrue("Button 'Sign Out' is not displayed ", isButtonSignOutNotVisible());
        Assert.assertTrue("Button 'Sign in' is displayed ", isButtonSignInVisible());
    }

    private boolean isMessageInvalidUsernamePasswordVisible() {
        try {
            return webDriver.findElement(By.xpath(".//div[@class='alert alert-danger text-center' and text()='Invalid username/password.']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isButtonSignOutNotVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[@class=''btn btn-sm btn-secondary']")).isDisplayed();
        } catch (Exception e) {
            return true;
        }
    }

    private boolean isButtonSignInVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}