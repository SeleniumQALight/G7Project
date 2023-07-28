package pages;

import data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = "//input[@placeholder ='Username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@placeholder ='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class ='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[@class ='alert alert-danger text-center' and text()='Invalid username / pasword']")
    private WebElement errorMessage;

    @FindBy(xpath = "//button[text()='Sign Out']")
    private WebElement buttonSignOut;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        openPage(BASE_URL);
    }

    public void enterTextInputUserName(String userName) {
        enterTextIntoInput(inputUsername, userName);
    }

    public void enterTextInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    public void checkButtonSignInDisplayed() {
        checkIsElementDisplayed(buttonSignIn);
    }

    public void checkErrorMessageIsDisplayed() {
        checkIsElementDisplayed(errorMessage);
    }

    public void checkIsInputUsernameLoginVisible() {
        checkIsElementDisplayed(inputUsername);
    }

    public void checkIsInputPasswordLoginVisible() {
        checkIsElementDisplayed(inputPassword);
    }

    public void checkIsButtonSignInVisible() {
        checkIsElementDisplayed(buttonSignIn);
    }

    public void checkIsButtonSignInNotVisible() {
        checkIsElementNotDisplayed(buttonSignIn);
    }

    public void checkIsInputUsernameLoginNotVisible() {
        checkIsElementNotDisplayed(inputUsername);
    }

    public void checkIsInputPasswordLoginNotVisible() {
        checkIsElementNotDisplayed(inputPassword);
    }

    public void checkIsErrorMessageNotVisible() {
        checkIsElementNotDisplayed(errorMessage);
    }

    public void loginWithValidCreds() {
        openLoginPage();
        enterTextInputUserName(TestData.LOGIN_DEFAULT);
        enterTextInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }
}
