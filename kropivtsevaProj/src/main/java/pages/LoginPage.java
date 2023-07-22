package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputUserPassword;

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;

    @FindBy(xpath = ".//button[@class='btn btn-danger btn-sm']")
    private WebElement buttonSignOut;

    @FindBy(xpath = ".//*[text()='Invalid username / pasword']")
    private WebElement messageInvalidUsernamePassword;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        openPage(baseUrl);
    }

    public void enterTextIntoInputUserName(String userName) {
        enterTextIntoInput(inputUserName, userName);
    }

    public void enterTextIntoInputUserPassword(String userPassword) {
        enterTextIntoInput(inputUserPassword, userPassword);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    public void checkMessageInvalidUsernamePasswordIsDisplayed() {
        checkElementDisplay(messageInvalidUsernamePassword);
    }

    public void checkIsButtonSignInVisible() {
        checkElementDisplay(buttonSignIn);
    }
}
