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

    @FindBy(xpath = ".//button[@class ='btn btn-sm btn-secondary']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//div[@class ='alert alert-danger text-center' and text()='Invalid username / pasword']")
    private WebElement errorMessage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        openPage(BASE_URL);
    }

    public void enterTextInputUserName(String userName) {
        enterTextIntoInput(inputUsername, userName);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    public void enterTextInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    public void isButtonSignOutDisplayed() {
        isElementDisplayed(buttonSignOut);
    }

    public void isButtonSignInDisplayed() {
        isElementDisplayed(buttonSignIn);
    }

    public void checkErrorMessageIsDisplayed() {
        checkElementDisplayed(errorMessage);
    }

    public void checkTextInErrorMessage(String text) {
        checkTextInElement(errorMessage, text);
    }

    public void checkTextInElement(WebElement errorMessage, String text) {
        String errorMessageText = errorMessage.getText();
        if (errorMessageText.equals(text)) {
            logger.info("Text in error message is correct");
        } else {
            logger.error("Text in error message is not correct");
        }

    }


}
