package LoginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
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
        WebElement buttonSignOut =
                webDriver.findElement(By.xpath(".//button[text()='Sign Out']"));
        Assert.assertTrue(" Button is not displayed", buttonSignOut.isDisplayed());


        webDriver.quit();
        System.out.println("Browser was closed");

    }
}
