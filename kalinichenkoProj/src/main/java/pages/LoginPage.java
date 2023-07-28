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

    @FindBy(xpath = ".//div[@class='alert alert-danger text-center']")
    private WebElement alertMessageWrongLoginOrPassword;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        openPage(baseUrl);
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

    public void isButtonSignInVisible() {
        checkElementDisplay(buttonSignIn);
    }

    public void isButtonSignInNotVisible() {
        checkElementNotDisplay(buttonSignIn);
    }

    public void isInputUserNameNotVisible() {
        checkElementNotDisplay(inputUserName);
    }

    public void isInputUserNameVisible() {
        checkElementDisplay(inputUserName);
    }

    public void isInputPasswordNotVisible() {
        checkElementNotDisplay(inputPassword);
    }

    public void isInputPasswordVisible() {
        checkElementDisplay(inputPassword);
    }

    public void isAlertMessageWrongLoginOrPasswordVisible() {
        checkElementDisplay(alertMessageWrongLoginOrPassword);
    }

}
