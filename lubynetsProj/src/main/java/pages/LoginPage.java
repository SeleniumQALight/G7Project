package pages;

import data.TestData;
import io.qameta.allure.Step;
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

    @FindBy(xpath = ".//div[@class='alert alert-danger text-center']")
    private WebElement messageInvalidUsernameAndPassword;

    @FindBy(xpath = "//button[@class=\"py-3 mt-4 btn btn-lg btn-success btn-block\"]")
    private WebElement buttonRegistration;


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
        String[] errors = expectedMessages.split(";");
        webDriverWait10.until(ExpectedConditions.numberOfElementsToBe(By.xpath(listErrorsMessagesLocator), errors.length));
        ArrayList<String> actualTextFromErrors = new ArrayList<>();
        List<WebElement> errorElements = getListOfErrors();

        for (int i = 0; i < errorElements.size(); i++) {
            actualTextFromErrors.add(errorElements.get(i).getText());
        }

        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < errors.length; i++) {
            String error = errors[i];
            String errorMessage = actualTextFromErrors.get(i);
            softAssertions.assertThat(error).as("Error " + i).isIn(errorMessage);
        }
        softAssertions.assertAll();

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

    public LoginPage checkIsErrorMessageVisible(String textOfMessage) {
        Assert.assertEquals("Message in alert ", textOfMessage, messageInvalidUsernameAndPassword.getText());

        return this;
    }
}
