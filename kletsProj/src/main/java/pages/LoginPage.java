package pages;

import data.TestData;
import io.qameta.allure.Step;
import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

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

    @FindBy(id = "username-register")
    private WebElement inputUserNameRegistration;

    @FindBy(id = "email-register")
    private WebElement inputEmailRegistration;

    @FindBy(id = "password-register")
    private WebElement inputPasswordRegistration;

    //same as webDriver.findElements(By.xpath("//div[@class ='alert alert-danger small liveValidateMessage liveValidateMessage--visible']"));
//    @FindBy(xpath = "//div[@class ='alert alert-danger small liveValidateMessage liveValidateMessage--visible']")
//    private List<WebElement> alertDanger;

    final String listErrorsMessagesLocator = "//div[@class ='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    @Step
    public void openLoginPage() {
        openPage(BASE_URL);
        checkUrl();
    }

    @Step
    public void enterTextInputUserName(String userName) {
        enterTextIntoInput(inputUsername, userName);
    }
    @Step
    public void enterTextInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }
    @Step
    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }
    @Step
    public void checkButtonSignInDisplayed() {
        checkIsElementDisplayed(buttonSignIn);
    }
    @Step
    public void checkErrorMessageIsDisplayed() {
        checkIsElementDisplayed(errorMessage);
    }
    @Step
    public void checkIsInputUsernameLoginVisible() {
        checkIsElementDisplayed(inputUsername);
    }
    @Step
    public void checkIsInputPasswordLoginVisible() {
        checkIsElementDisplayed(inputPassword);
    }
    @Step
    public void checkIsButtonSignInVisible() {
        checkIsElementDisplayed(buttonSignIn);
    }
    @Step
    public void checkIsButtonSignInNotVisible() {
        checkIsElementNotDisplayed(buttonSignIn);
    }
    @Step
    public void checkIsInputUsernameLoginNotVisible() {
        checkIsElementNotDisplayed(inputUsername);
    }
    @Step
    public void checkIsInputPasswordLoginNotVisible() {
        checkIsElementNotDisplayed(inputPassword);
    }

    public void checkIsErrorMessageNotVisible() {
        checkIsElementNotDisplayed(errorMessage);
    }
    @Step
    public void loginWithValidCreds() {
        openLoginPage();
        enterTextInputUserName(TestData.LOGIN_DEFAULT);
        enterTextInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }
    @Step
    public LoginPage enterTextIntoRegistrationUserNameField(String userName) {
        enterTextIntoInput(inputUserNameRegistration, userName);
        return this;
    }
    @Step
    public LoginPage enterTextIntoRegistrationEmailField(String email) {
        enterTextIntoInput(inputEmailRegistration, email);
        return this;
    }
    @Step
    public LoginPage enterTextIntoRegistrationPasswordField(String password) {
        enterTextIntoInput(inputPasswordRegistration, password);
        return this;
    }
    @Step
    public LoginPage checkErrorsMessages(String expectedMessages) {
        // error1;error2; - > [error1, error2]
        String[] errors = expectedMessages.split(";");
        // wait util number of  error messages will be expected
        webDriverWait10.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.xpath(listErrorsMessagesLocator), errors.length));
        Util.waitABit(1); // wait until EXTRA error messages will be DISPLAYED
        Assert.assertEquals("Number of error messages", errors.length,
                getListOfErrors().size());

        ArrayList actualTextFromErrors = new ArrayList();
        for (WebElement element : getListOfErrors()) {
            actualTextFromErrors.add(element.getText());
        }

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < errors.length; i++) {
            softAssertions.assertThat(errors[i])
                    .as("Error " + i)
                    .isIn(actualTextFromErrors);
        }
        softAssertions.assertAll(); // check all soft assertion

        return this;
    }

    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }
}

