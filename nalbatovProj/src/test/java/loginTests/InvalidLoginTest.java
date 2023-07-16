package loginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLoginTest {
    WebDriver webDriver;

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
        System.out.println("Password was inputted");

        webDriver.findElement(By.xpath(".//button[text()='Sign In']")).click();
        System.out.println("Button was clicked");

        WebElement buttonLogin = webDriver.findElement(By.xpath(".//button[text()='Log In']"));
        WebElement buttonLogout = null;

        // Verify that the Log In button is displayed
        Assert.assertTrue("Log In button is not displayed", buttonLogin.isDisplayed());

        // Check if the Log Out button is displayed (if it exists)
        try {
            buttonLogout = webDriver.findElement(By.xpath(".//button[text()='Log Out']"));
        } catch (Exception e) {
            // Do nothing if the element is not found
        }
        Assert.assertNull("Log Out button is displayed", buttonLogout);

        // Check if the invalid login message is displayed
        Assert.assertTrue("Invalid Login Message is not displayed", isInvalidLoginMessageVisible());
    }

    @After
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
            System.out.println("Browser was closed");
        }
    }

    private boolean isInvalidLoginMessageVisible() {
        try {
            WebElement invalidLoginMessage = webDriver.findElement(By.xpath(".//div[@class='alert alert-danger text-center']"));
            return invalidLoginMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
