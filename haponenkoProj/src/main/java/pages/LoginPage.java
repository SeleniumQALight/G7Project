package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.elements.Header;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[contains (text(),'Invalid username / pasword')]")
    private WebElement errorMessage;

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
        checkElementIsDisplayed(buttonSignIn);
    }


    public void checkIsErrorMessageVisible() {
        checkElementIsDisplayed(errorMessage);
    }

    public void checkIsInputUserNameVisible() {
        checkElementIsDisplayed(inputUserName);
    }

    public void checkIsInputPasswordVisible() {
        checkElementIsDisplayed(inputPassword);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementIsNotDisplayed(buttonSignIn);
    }

    public void checkIsInputUserNameNotVisible() {
        checkElementIsNotDisplayed(inputUserName);
    }

    public void checkIsInputPasswordNotVisible() {
        checkElementIsNotDisplayed(inputPassword);
    }

    public void loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUserName(LOGIN_DEFAULT);
        enterTextIntoInputPassword(PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }
}
