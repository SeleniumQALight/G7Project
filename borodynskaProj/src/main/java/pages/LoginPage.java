package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputPassWord;

    @FindBy(xpath = ".//button[text()='Sign In']")
    private WebElement buttonSignIn;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        openPage(BASE_URL);
    }

    public void enterTextInToInputUserName(String userName) {
        enterTextIntoInput(inputUserName, userName);
    }

    public void enterTextInToInputPassWord(String passWord) {
        enterTextIntoInput(inputPassWord, passWord);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    public void loginWithValidCreds() {
        openLoginPage();
        enterTextInToInputUserName(LOGIN_DEFAULT);
        enterTextInToInputPassWord(PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }

    public void checkIsInputUserNameNotVisible() {
        checkElementNotDisplayed(inputUserName);
    }

    public void checkIsInputPasswordNotVisible() {
        checkElementNotDisplayed(inputPassWord);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementNotDisplayed(buttonSignIn);
    }

    public void checkIsInputUserNameVisible() {
        checkElementDisplayed(inputUserName);
    }

    public void checkIsInputPasswordVisible() {
        checkElementDisplayed(inputPassWord);
    }

    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
    }



}
