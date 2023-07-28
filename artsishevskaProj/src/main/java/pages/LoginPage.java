package pages;

import data.TestData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage{
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;
    @FindBy(xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;
    @FindBy(xpath = "//button[text() = 'Sign Out']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//div[@class='alert alert-danger text-center' and text() = 'Invalid username / pasword']")
    private WebElement messageInvalidUserNameOrPassword;
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void openLoginPage(){
        openPage(BASE_URL);
    }
    public void enterTextIntoInputUserName(String userName){
        enterTextIntoInput(inputUserName, userName);
    }
    public void enterTextIntoInputPassword(String password){
        enterTextIntoInput(inputPassword, password);
    }
    public void clickOnButtonSignIn(){
        clickOnElement(buttonSignIn);
    }
    public void clickOnButtonSignOut(){
        clickOnElement(buttonSignOut);
    }
    public void checkIsButtonSignInVisible(){
        checkElementDisplayed(buttonSignIn);
    }
    public void checkIsFieldLoginVisible(){
        checkElementDisplayed(inputUserName);
    }
    public void checkIsFieldPasswordVisible(){
        checkElementDisplayed(inputPassword);
    }
    public void checkNotIsButtonSignInVisible(){
        checkElementNotDisplayed(buttonSignIn);
    }
    public void checkNotIsFieldLoginVisible(){
        checkElementNotDisplayed(inputUserName);
    }
    public void checkNotIsFieldPasswordVisible(){
        checkElementNotDisplayed(inputPassword);
    }

    public LoginPage getLoginPage(){
        return new LoginPage(webDriver);
    }

    public void loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }
}
