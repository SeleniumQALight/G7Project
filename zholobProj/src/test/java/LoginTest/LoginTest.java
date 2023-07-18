package LoginTest;

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
    public void validloginIn(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Broser was open");
        webDriver.get("https://qa-complexapp.onrender.com");
        System.out.println("site was opened");

        WebElement inputUserName =
        webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("Username was inputted");

        WebElement inputPass =
                webDriver.findElement(By.xpath(" //input[@placeholder='Password']"));
        inputPass.clear();
        inputPass.sendKeys("123456qwerty");
        System.out.println("Password was inputted");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']"))
        .click();
        System.out.println("Button was clicked");
 //       WebElement buttonSignOut =
 //               webDriver.findElement(By.xpath(".//button[text()='Sign Out']"));
        Assert.assertTrue(" Button is not displayed", isButtonSignOutVisible());

//        webDriver.quit();
 //       System.out.println("Browser was closed");
    }

    @After //this method will be executed after each test
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
    public void invalidLoginIN() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Broser was open");

        webDriver.get("https://qa-complexapp.onrender.com");
        System.out.println("site was opened");

        WebElement inputUserName =
                webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("Username was inputted");


        WebElement inputPass =
                webDriver.findElement(By.xpath(" //input[@placeholder='Password']"));
        inputPass.clear();
        inputPass.sendKeys("123456qwerty");
        System.out.println("Password was inputted");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button 'Sign In' was clicked");


        Assert.assertTrue ("Button 'Sign In' is not displayed", isButtonSignInVisible());

        Assert.assertTrue("text Invalid username/password is not displayed", textInvalidUserVisible());

        Assert.assertFalse("Button 'Sign Out' is displayed", isButtonSignOutVisible());


    }

    private boolean isButtonSignInVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[contains(text(),'Sign In')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    private boolean textInvalidUserVisible() {
        try {
            return webDriver.findElement(By.xpath("//div[@class='alert alert-danger text-center']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }


}



