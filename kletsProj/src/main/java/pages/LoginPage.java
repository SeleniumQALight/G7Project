package pages;

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
        checkElementDisplayed(buttonSignIn);
    }

    public void checkErrorMessageIsDisplayed() {
        checkElementDisplayed(errorMessage);
    }

    public void checkIsInputUsernameLoginVisible() {
        checkElementDisplayed(inputUsername);
    }

    public void checkIsInputPasswordLoginVisible() {
        checkElementDisplayed(inputPassword);
    }

    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementNotDisplayed(buttonSignIn);
    }

    public void checkIsInputUsernameLoginNotVisible() {
        checkElementNotDisplayed(inputUsername);
    }

    public void checkIsInputPasswordLoginNotVisible() {
        checkElementNotDisplayed(inputPassword);
    }

    public void checkIsErrorMessageNotVisible() {
        checkElementNotDisplayed(errorMessage);
    }

}
