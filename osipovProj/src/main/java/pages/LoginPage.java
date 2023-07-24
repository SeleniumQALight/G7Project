package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;
    @FindBy(xpath = ".//*[text()='Sign In']")
    private WebElement buttonSignIn;
    @FindBy(xpath = "//div[text()='Invalid username / pasword']")
    private WebElement invalidLoginMessage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        openPage(BASE_URL);
    }
    public void enterTextIntoInputUserName(String userName) {
        enterTextIntoInput(inputUserName, userName);
    }

    public void enterTextIntoInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }
    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementIsNotDisplayed(buttonSignIn);
    }
    public void checkIsUserNameInputDisplayed() {
        checkElementDisplayed(inputUserName);
    }

    public void checkIsPasswordInputDisplayed() {
        checkElementDisplayed(inputPassword);
    }

    public void isInvalidLoginMessageDisplayed(){
        checkElementDisplayed(invalidLoginMessage);
    }
}

