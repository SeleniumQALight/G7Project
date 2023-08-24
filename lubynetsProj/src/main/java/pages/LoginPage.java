package pages;

import data.TestData;
import io.qameta.allure.Step;
import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class LoginPage extends ParentPage {
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[text()='Sign In']")
    private WebElement buttonSignIn;

    @FindBy(id = "username-register")
    private WebElement inputUserNameRegistration;

    @FindBy(id = "email-register")
    private WebElement inputEmailRegistration;

    @FindBy(id = "password-register")
    private WebElement inputPasswordRegistration;

    final String listErrorsMessagesLocator = ".//*[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    @Step
    public LoginPage openLoginPage() {
        openPage(BASE_URL);
        checkUrl();
        return this;
    }
    @Step
    public LoginPage enterTextIntoInputUserName(String userName) {
        enterTextIntoInput(inputUserName, userName);
        return this;
    }
    @Step
    public LoginPage enterTextIntoInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
        return this;
    }
    @Step
    public LoginPage clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
        return this;
    }
    @Step
    public LoginPage checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
        return this;
    }
    @Step
    public LoginPage checkIsButtonSignInNotVisible() {
        checkElementNotDisplayed(buttonSignIn);
        return this;
    }
    @Step
    public LoginPage checkIsInputUsernameVisible() {
        checkElementDisplayed(inputUserName);
        return this;
    }
    @Step
    public LoginPage checkIsInputUsernameNotVisible() {
        checkElementNotDisplayed(inputUserName);
        return this;
    }
    @Step
    public LoginPage checkIsInputPasswordVisible() {
        checkElementDisplayed(inputPassword);
        return this;
    }
    @Step
    public LoginPage checkIsInputPasswordNotVisible() {
        checkElementNotDisplayed(inputPassword);
        return this;
    }
    @Step
    public void loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUserName(TestData.LOGIN_DEFAULT1);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }
    @Step
    public LoginPage enterTextIntoRegistrationUserName(String userName) {
        enterTextIntoInput(inputUserNameRegistration, userName);
        return this;
    }
    @Step
    public LoginPage enterTextIntoRegistrationEmail(String email) {
        enterTextIntoInput(inputEmailRegistration, email);
        return this;
    }
    @Step
    public LoginPage enterTextIntoRegistrationPassword(String password) {
        enterTextIntoInput(inputPasswordRegistration, password);
        return this;
    }
    @Step
    public LoginPage checkErrorsMessages(String expectedMessages) {
        // error1;error2 -> [error1, error2]
        String[] errors = expectedMessages.split(";");
        // wait until numbers of errors messages will be expected
        webDriverWait10.until(ExpectedConditions.numberOfElementsToBe(
                By.xpath(listErrorsMessagesLocator), errors.length));
        Util.waitABit(1); // wait until Extra time will be displayed
        Assert.assertEquals("Number of elements", errors.length,
                getListOfErrors().size());

        ArrayList actualTextFromErrors = new ArrayList();
        for (WebElement element : getListOfErrors()) {
            actualTextFromErrors.add(element.getText());
        }
        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < errors.length; i++) {
            softAssertions.assertThat(errors[i])
                    .as("Error text")
                    .isIn(actualTextFromErrors);
        }
        softAssertions.assertAll(); // check all assertion
        return this;
    }

    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }

    public LoginPage waitForEmailInputClickable() {
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(inputEmailRegistration));
        return this;
    }

    public LoginPage waitForPasswordInputClickable() {
        webDriverWait10.until(ExpectedConditions.elementToBeClickable(inputPasswordRegistration));
        return this;
    }

    public LoginPage pressTabKeyEmail() {
        pressTabKey(inputEmailRegistration);
        return this;
    }

    public LoginPage pressTabKeyUserName() {
        pressTabKey(inputUserNameRegistration);
        return this;
    }
    public LoginPage pressTabKeyPassword() {
        pressTabKey(inputPasswordRegistration);
        return this;
    }

    public LoginPage pressEnterKeyPassword() {
        pressEnterKey(inputPasswordRegistration);
        return this;
    }

    public void loginWithTabAndEnter() {
        inputUserName.sendKeys(Keys.TAB);
        inputPassword.sendKeys(Keys.ENTER);
    }
}
