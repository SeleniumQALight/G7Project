package pages;

import data.TestData;
import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends ParentPageWithHeader {

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement signInButton;

    @FindBy(xpath = "//div[text()='Invalid username / pasword']")
    private WebElement loginValidation;
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(id = "username-register")
    private WebElement inputUserNameRegistration;
    
    @FindBy(id = "email-register")
    private WebElement inputEmailRegistation;

    @FindBy(id = "password-register")
    private WebElement inputPasswordRegistation;

    final String listErrorsMessagesLocator = ".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";

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


    public HomePage loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUsername(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnSignInButton();
        return new HomePage(webDriver);
    }

    public void checkIsLoginValidationDisplayed(){
        checkElementDisplayed(loginValidation);
    }


    public void checkIsSignInButtonVisible(){
        checkElementDisplayed(signInButton);
    }

    public void checkIsInputUsernameVisible(){
        checkElementDisplayed(inputUsername);
    }

    public void checkIsInputUserNameNotVisible(){
        checkElementNotDisplayed(inputUsername);
    }

    public void checkIsInputPasswordVisible(){
        checkElementDisplayed(inputPassword);
    }

    public void checkIsInputPasswordNotVisible(){
        checkElementNotDisplayed(inputPassword);
    }

    public void checkisSignInButtonNotVisible(){
        checkElementNotDisplayed(signInButton);
    }

    public void checkIsRedirectToLoginPage(){
        getHeader().checkSearchButtonNotVisible();
        getHeader().checkChatButtonNotVisible();
        getHeader().checkProfileButtonNotVisible();
        getHeader().checkButtonCreatePostNotVisible();
        getHeader().checkIsSignOutButtonNotVisible();
        checkIsInputUsernameVisible();
        checkIsInputPasswordVisible();
        checkIsSignInButtonVisible();
    }


    public LoginPage enterTextIntoRegistrationUserName(String userName) {
        enterTextIntoInput(userName, inputUserNameRegistration);
        return this;
    }
    


    public LoginPage enterTextIntoRegistrationEmail(String email) {
        enterTextIntoInput(email, inputEmailRegistation);
        return this;
    }


    public LoginPage enterTextIntoRegistrationPassword(String password) {
        enterTextIntoInput(password, inputPasswordRegistation);
        return this;
    }

    public LoginPage checkErrorsMessages(String expectedMessages) {
        String[] errors = expectedMessages.split(";");
        webDriverWait10.until(ExpectedConditions.numberOfElementsToBe(By.xpath(listErrorsMessagesLocator), errors.length));
        Util.waitABit(1); // wait until Extra errors will be displayed
        Assert.assertEquals("Number of elements ", errors.length, getListOfErrors().size());
        ArrayList actualTextFromErrors = new ArrayList<>();
        for (WebElement element: getListOfErrors()) {
            actualTextFromErrors.add(element.getText());
        }

        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < errors.length; i++){
            softAssertions.assertThat(errors[i]).as("Error " + i).isIn(actualTextFromErrors);
        }

        softAssertions.assertAll(); // check all soft assertions
        return this;
    }

    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }
}
