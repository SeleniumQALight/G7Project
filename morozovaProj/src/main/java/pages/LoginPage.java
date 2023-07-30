package pages;

import data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[text()='Sign In']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[@class='alert alert-danger text-center' and text() = 'Invalid username / pasword']")
    private WebElement messageInvalidUsernameAndPassword;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void openLoginPage() {
        openPage(BASE_URL);
    }

    public void enterTextIntoInputUserName(String UserName) {
        enterTextIntoInput(inputUserName, UserName);
    }

    public void enterTextIntoInputPassword(String Password) {
        enterTextIntoInput(inputPassword, Password);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    public void loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }
    public void checkIsInputUserNameVisible() {
        checkElementDisplayed(inputUserName);
    }

    public void checkIsInputUserNameNotVisible() {
        checkElementNotDisplayed(inputUserName);
    }

    public void checkIsInputPasswordVisible() {
        checkElementDisplayed(inputPassword);
    }

    public void checkIsInputPasswordNotVisible() {
        checkElementNotDisplayed(inputPassword);
    }

    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementNotDisplayed(buttonSignIn);
    }

    public void checkIsMessageInvalidUsernameAndPasswordVisible() {
        checkElementDisplayed(messageInvalidUsernameAndPassword);
    }

}
