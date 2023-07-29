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

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[text()='Invalid username / pasword']")
    private WebElement errorMessageInvalidUsernamePassword;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
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

    public void checkIsInputUserNameDisplayed() {
        checkElementDisplayed(inputUserName);
    }

    public void checkIsInputPasswordDisplayed() {
        checkElementDisplayed(inputPassword);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementNotDisplayed(buttonSignIn);
    }

    public void checkIsInputUserNameIsNotDisplayed() {
        checkElementNotDisplayed(inputUserName);
    }

    public void checkIsInputPasswordIsNotDisplayed() {
        checkElementNotDisplayed(inputPassword);
    }

    public void checkIsErrorMessageInvalidUsernamePasswordDisplayed() {
        checkElementDisplayed(errorMessageInvalidUsernamePassword);
    }

    public void loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnButtonSignIn();

    }
}

