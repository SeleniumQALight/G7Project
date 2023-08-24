package pages;

import io.qameta.allure.Step;
import junit.framework.Assert;
import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static data.TestData.LOGIN_DEFOULT;
import static data.TestData.PASSWORD_DEFOULT;

public class LoginPage extends ParentPage {
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputUserPassword;

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;

    @FindBy(xpath = ".//button[@class='btn btn-danger btn-sm']")
    private WebElement buttonSignOut;

    @FindBy(xpath = ".//*[text()='Invalid username / pasword']")
    private WebElement messageInvalidUsernamePassword;

    @FindBy(id = "username-register")
    private WebElement inputUserNameRegistration;

    @FindBy(id = "email-register")
    private WebElement inputEmailRegistration;

    @FindBy(id = "password-register")
    private WebElement inputPasswordRegistration;

    final String listErrorsMessagesLocator = ".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";


    public LoginPage(WebDriver webDriver) {

        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    @Step
    public void openLoginPage() {
        openPage(baseUrl);
        checkUrl();
    }

    @Step
    public void enterTextIntoInputUserName(String userName) {
        enterTextIntoInput(inputUserName, userName);
    }

    @Step
    public void enterTextIntoInputUserPassword(String userPassword) {
        enterTextIntoInput(inputUserPassword, userPassword);
    }

    @Step
    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    @Step
    public void checkMessageInvalidUsernamePasswordIsDisplayed() {
        checkElementDisplay(messageInvalidUsernamePassword);
    }

    @Step
    public void checkIsButtonSignInVisible() {
        checkElementDisplay(buttonSignIn);
    }

    @Step
    public void checkIsButtonSignInNotVisible() {
        checkElementNotDisplay(buttonSignOut);
    }

    @Step
    public void checkIsInputUserNameVisible() {
        checkElementDisplay(inputUserName);
    }

    @Step
    public void checkIsInputUserNameNotVisible() {
        checkElementNotDisplay(inputUserName);
    }

    @Step
    public void checkIsInputUserPasswordVisible() {
        checkElementDisplay(inputUserPassword);
    }

    @Step
    public void checkIsInputUserPasswordNotVisible() {
        checkElementNotDisplay(inputUserPassword);
    }

    @Step
    public void loginWithValidCred() {
        openLoginPage();
        enterTextIntoInputUserName(LOGIN_DEFOULT);
        enterTextIntoInputUserPassword(PASSWORD_DEFOULT);
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
        // error1:error2 -> [error1, error2]
        String[] errors = expectedMessages.split(";");
        // wait until number of errors will be expected
        webDriverWait10.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.xpath(listErrorsMessagesLocator), errors.length)
        );
        Util.waitABit(1); // wait until all errors will be displayed
        Assert.assertEquals("Number of messages", errors.length,
                getListOfErrors().size());

        ArrayList actualListFromErrors = new ArrayList();
        for (WebElement element : getListOfErrors()) {
            actualListFromErrors.add(element.getText());
        }

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < errors.length; i++) {
            softAssertions.assertThat(errors[i])
                    .as("Errors" + i)
                    .isIn(actualListFromErrors);
        }

        softAssertions.assertAll(); // check all soft assertions

        return this;
    }

    @Step
    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(
                By.xpath(listErrorsMessagesLocator));
    }
}
