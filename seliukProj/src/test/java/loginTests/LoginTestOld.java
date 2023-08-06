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

public class LoginTestOld {
    WebDriver webDriver;

    @Test
    public void validLogIn() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was opened");

        webDriver.get("https://aqa-complexapp.onrender.com/");
        System.out.println("Site was opened");

        WebElement inputUserName = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("User name was inputted");

        WebElement inputPassWord = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassWord.clear();
        inputPassWord.sendKeys("123456qwerty");
        System.out.println("Password was inputted");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button 'Log In' was clicked");

        //WebElement buttonSignOut = webDriver.findElement(By.xpath(".//button[@class='btn btn-sm btn-secondary']"));
        Assert.assertTrue("Button 'Sign Out' is not displayed", isButtonSignOutVisible());
        System.out.println("Button 'Sign Out' is displayed");

        //webDriver.quit();
        //System.out.println("Browser was closed");
    }

    @Test
    public void invalidLogIn() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was opened");

        webDriver.get("https://aqa-complexapp.onrender.com/");
        System.out.println("Site was opened");

        WebElement inputUserName = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("User name was inputted");

        WebElement inputPassWord = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassWord.clear();
        inputPassWord.sendKeys("123456qwert");
        System.out.println("Password was inputted");
        /*WebElement inputPassWord = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassWord.clear();
        inputPassWord.sendKeys("123456qwert");
        System.out.println("Password was inputted");*/

        WebElement buttonLogIn = webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']"));
        buttonLogIn.click();


        Assert.assertFalse("Button 'Sign Out' is visible", isButtonSignOutVisible());
        System.out.println("Button 'Sign Out' is not visible");

        Assert.assertTrue("Button 'Sign In' is not visible", isButtonSignInVisible());
        System.out.println("Button 'Sign In' is visible");

        Assert.assertTrue("Message 'Invalid username/password' is not displayed", isMessageInvalidUsernamePasswordDisplayed());
        System.out.println("Message 'Invalid username/password' is displayed");

    }

    @After // this method will be executed after each test
    public void tearDown() {
        webDriver.quit();
        System.out.println("Browser was closed");
    }

    private boolean isButtonSignOutVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[@class='btn btn-sm btn-secondary']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isButtonSignInVisible() {
        try {
            return webDriver.findElement(By.xpath(".//*[@class='btn btn-primary btn-sm']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isMessageInvalidUsernamePasswordDisplayed() {
        try {
            return webDriver.findElement(By.xpath("//div[@class='alert alert-danger text-center' and text() = 'Invalid username / pasword']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
