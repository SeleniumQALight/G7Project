package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static test_data.TestData.*;

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

    public void checkButtonSignInVisible() {
        checkElementDisplay(buttonSignIn);
    }

    public void checkButtonSignInNotVisible() {
        checkElementNotDisplay(buttonSignIn);
    }

    public void checkInputUserNameNotVisible() {
        checkElementNotDisplay(inputUserName);
    }

    public void checkInputUserNameVisible() {
        checkElementDisplay(inputUserName);
    }

    public void checkInputPasswordNotVisible() {
        checkElementNotDisplay(inputPassword);
    }

    public void checkInputPasswordVisible() {
        checkElementDisplay(inputPassword);
    }

    public void checkAlertMessageWrongLoginOrPasswordVisible() {
        checkElementDisplay(alertMessageWrongLoginOrPassword);
    }

    public void loinWithValidCred() {
        openLoginPage();
        enterTextIntoInputUserName(LOGIN_DEFAULT);
        enterTextIntoInputPassword(PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }
}
