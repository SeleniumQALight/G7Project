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
    public void validLogIn() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();//open browser
        webDriver.manage().window().maximize();//all size screen
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); // default zatrimka
        System.out.println("Browser is opened");

        webDriver.get("https://qa-complexapp.onrender.com/"); //open site
        System.out.println("Site was opened");

        WebElement inputUsername = webDriver.findElement(By.xpath("//input[@placeholder ='Username']"));
        inputUsername.clear();// clear field
        inputUsername.sendKeys("qaauto");//vvod s klaviaturi
        System.out.println("UserName was inputted");

        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder ='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwerty");
        System.out.println("Password was inputted");

        webDriver.findElement(By.xpath(".//button[@class ='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");

        // WebElement buttonSignOut = webDriver.findElement(By.xpath(".//button[@class ='btn btn-sm btn-secondary']"));

        Assert.assertTrue("Button is not displayed", isButtonSignOutVisible());

        // webDriver.quit();// close browser
        //System.out.println("Browser is closed");
    }
    @Test
    public void invalidLogIn() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser is opened");

        webDriver.get("https://qa-complexapp.onrender.com/");
        System.out.println("Site was opened");

        WebElement inputUsername = webDriver.findElement(By.xpath("//input[@placeholder ='Username']"));
        inputUsername.clear();
        inputUsername.sendKeys("qaauto");
        System.out.println("UserName was inputted");

        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder ='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwerty1");
        System.out.println("Password was inputted");

        WebElement buttonSignIn = webDriver.findElement(By.xpath(".//button[@class ='btn btn-primary btn-sm']"));
        buttonSignIn.click();
        System.out.println("Button was clicked");

        Assert.assertTrue("Sign In button is not displayed", isButtonSignInVisible());
        System.out.println("Sign In Button is displayed");

        Assert.assertTrue("Error message is not displayed", isErrorMessageVisible());
        System.out.println("Error message is displayed");

        Assert.assertFalse("Button is displayed", isButtonSignOutVisible());
        System.out.println("Sign Out Button isn't displayed");
    }

    @After // this method will be executed after each test
    public void tearDown() {
        webDriver.quit();// close browser
        System.out.println("Browser is closed");
    }

    private boolean isButtonSignOutVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[@class ='btn btn-sm btn-secondary']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    private boolean isButtonSignInVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[@class ='btn btn-primary btn-sm']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isErrorMessageVisible() {
        try {
            return webDriver.findElement(By.xpath(".//div[@class ='alert alert-danger text-center' and text()='Invalid username/password.']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
