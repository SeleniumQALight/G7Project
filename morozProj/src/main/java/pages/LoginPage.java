package pages;

import data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPageWithHeader {

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[text()='Invalid username / pasword']")
    private WebElement loginValidation;
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        openPage(BASE_URL);
    }

    public void enterTextIntoInputUsername(String username) {
        enterTextIntoInput(username, inputUsername);
    }

    public void enterTextIntoInputPassword(String password) {
        enterTextIntoInput(password, inputPassword);
    }

    public void clickOnSignInButton() {
        clickOnElement(signInButton);
    }


    public void loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUsername(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnSignInButton();
    }

    public void checkIsLoginValidationDisplayed(){
        checkElementDisplayed(loginValidation);
    }

    public void checkIsSignInButtonVisible(){
        checkElementDisplayed(signInButton);
    }


}
