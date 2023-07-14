package loginTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;

    @Test
    public void validLogIn() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("The browser was opened");

        webDriver.get("https://qa-complexapp.onrender.com");
        System.out.println("The site was opened");

        WebElement inputUserName =
                webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("Username was inputted");

        WebElement inputPassword =
                webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwerty");
        System.out.println("Password was inputted");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();

        System.out.println("The 'SignIn' button was clicked");

//        WebElement buttonSignOut =
//                webDriver.findElement(By.xpath(".//button[text()='Sign Out']"));

        Assert.assertTrue("The button is not displayed", isButtonSignOutVisible());

//        webDriver.quit();
//        System.out.println("The browser was closed");
    }

    @After // runs after each test
    public void tearDown() {
        webDriver.quit();
        System.out.println("The browser was closed");
    }

    private boolean isButtonSignOutVisible() {
        try {
            return webDriver.findElement(By.xpath(".//button[text()='Sign Out']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    @Test
    public void invalidLogIn() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("The browser was opened");

        webDriver.get("https://qa-complexapp.onrender.com");
        System.out.println("The site was opened");

        WebElement inputUserName =
                webDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        inputUserName.clear();
        inputUserName.sendKeys("qaauto");
        System.out.println("Username was inputted");

        WebElement inputPassword =
                webDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        inputPassword.clear();
        inputPassword.sendKeys("123456qwert");
        System.out.println("Password was inputted");

        webDriver.findElement(By.xpath(".//button[@class='btn btn-primary btn-sm']")).click();
        System.out.println("The 'Sign In' button was clicked");

        try {
            Assert.assertFalse("The 'Sign Out' button is displayed", isButtonSignOutVisible());
            System.out.println("The 'Sign Out' button isn't displayed");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

        try {
            Assert.assertTrue("The 'Sign In' button isn't displayed", isButtonSignInVisible());
            System.out.println("The 'Sign In' button is displayed");
        } catch (AssertionError e) {
            System.out.println(e.getMessage());
        }

        List<WebElement> errorMessages = webDriver.findElements(By.xpath("//div[@class = 'alert alert-danger text-center']"));
        if (!errorMessages.isEmpty()) {
            WebElement errorMessage = errorMessages.get(0);
            Assert.assertTrue("The 'Invalid username/password' message is displayed", errorMessage.isDisplayed());
            System.out.println("The 'Invalid username/password' message is displayed");
        } else {
            String errorMessage = "The 'Invalid username/password' message isn't displayed";
            System.out.println(errorMessage);
            throw new AssertionError(errorMessage); // Throw an assertion error to mark the test as "failed"
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