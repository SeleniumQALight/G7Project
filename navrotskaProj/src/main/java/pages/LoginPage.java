package pages;

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

    @FindBy(xpath = "//div[@class='alert alert-danger text-center']")
    private WebElement InvalidCredsError;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        openPage(BASE_URL);
    }

    public void enterTextIntoInputUserName(String userName) {
        enterTextIntoInput(inputUserName, userName);
    }

    public void checkIsInputUserNameNotVisible() {
        checkElementNotDisplayed(inputUserName);
    }

    public void checkIsInputUserNameVisible() {
        checkElementDisplayed(inputUserName);
    }

    public void enterTextIntoInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    public void checkIsInputPasswordVisible() {
        checkElementDisplayed(inputPassword);
    }

    public void checkIsInputPasswordNotVisible() {
        checkElementNotDisplayed(inputPassword);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementNotDisplayed(buttonSignIn);
    }

    public void isInvalidCredsErrorVisible() {
        checkElementDisplayed(InvalidCredsError);
    }


}


