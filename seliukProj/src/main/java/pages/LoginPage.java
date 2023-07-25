package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = "//input[@name='username' and @class='form-control form-control-sm input-dark']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@name='password' and @class='form-control form-control-sm input-dark']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[@class='alert alert-danger text-center' and text() = 'Invalid username / pasword']")
    private WebElement messageInvalidUsernameAndPassword;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    //actions
    public void openLoginPage() {
        openPage(BASE_URL);
    }

    public void enterUserName(String userName) {
        enterTextIntoInput(inputUserName, userName);
    }

    public void enterPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    //checks
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