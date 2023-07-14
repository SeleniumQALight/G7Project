package loginTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ActionsWithElements;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;
    ActionsWithElements actions = new ActionsWithElements(webDriver);

    public void prepForTest() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was opened");
    }

    @Test
    public void validLoginIn() {
        prepForTest();

        webDriver.get("https://qa-complexapp.onrender.com/");
        System.out.println("site was opened");

        WebElement inputUserName = webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("UserName was inputted");

        WebElement inputPassword = webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwerty");
        System.out.println("Password was inputted");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("Button was clicked");

        Assert.assertTrue("Button is not displayed", isButtonSignOutVisible());
    }

    @After//this method will be executed after each test
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
        prepForTest();

        actions.openPage("https://qa-complexapp.onrender.com/", webDriver);
        actions.enterTextIntoInput(webDriver.findElement(By.xpath("//input[@placeholder='Username']")), "qaauto");
        actions.enterTextIntoInput(webDriver.findElement(By.xpath("//input[@placeholder='Password']")), "123456qwert");
        actions.clickOnElement(webDriver.findElement(By.xpath("//button[@class='btn btn-primary btn-sm']")));

        Assert.assertTrue(actions.isElementDisplayed(webDriver.findElement(By.xpath("//button[text()='Sign In']"))));
        Assert.assertFalse(actions.isElementNotDisplayed(webDriver, "//button[text()='Sign Out']"));
        Assert.assertTrue(actions.isElementDisplayed(webDriver.findElement(By.xpath("//div[text()='Invalid username/password.']"))));
    }
}
