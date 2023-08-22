package pages;

import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginPage extends ParentPage {
    @FindBy(xpath = "//input[@name='username' and @class='form-control form-control-sm input-dark']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@name='password' and @class='form-control form-control-sm input-dark']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[@class='alert alert-danger text-center' and text() = 'Invalid username / pasword']")
    private WebElement messageInvalidUsernameAndPassword;

    @FindBy(id = "username-register")
    private WebElement inputUserNameRegistration;

    @FindBy(id = "email-register")
    private WebElement inputEmailRegistration;

    @FindBy(id = "password-register")
    private WebElement inputPasswordRegistration;

    //the same as webDriver.findElements(By.xpath(".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']"));
    //@FindBy(xpath = ".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']")
    //private WebElement alertDanger;

    final String listErrorsMessagesLocator = ".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    //actions
    public void openLoginPage() {
        openPage(BASE_URL);
        checkUrl();
    }

    public void enterUserName(String userName) {
        enterTextIntoInput(inputUserName, userName);
    }

    public void enterPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    public void loginWithValidCredentials() {
        openLoginPage();
        enterUserName(LOGIN_DEFAULT);
        enterPassword(PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }

    public LoginPage enterTextInroRegistrationUserNameField(String userName) {
        enterTextIntoInput(inputUserNameRegistration, userName);
        return this;
    }

    public LoginPage enterTextInroRegistrationEmailField(String email) {
        enterTextIntoInput(inputEmailRegistration, email);
        return this;
    }

    public LoginPage enterTextInroRegistrationPasswordField(String password) {
        enterTextIntoInput(inputPasswordRegistration, password);
        return this;
    }

    //checks
    public void checkIsInputUserNameVisible() {
        checkElementDisplayed(inputUserName);
    }

    public void checkIsInputUserNameNotVisible() {
        checkElementNotDisplayed(inputUserName);
    }

    public void checkIsInputPasswordVisible() {
        checkElementDisplayed(inputPassword);
    }

    public void checkIsInputPasswordNotVisible() {
        checkElementNotDisplayed(inputPassword);
    }

    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementNotDisplayed(buttonSignIn);
    }

    public void checkIsMessageInvalidUsernameAndPasswordVisible() {
        checkElementDisplayed(messageInvalidUsernameAndPassword);
    }

    public LoginPage checkErrorsMessages(String expectedMessages) {
        //error1;error2 -> [error1, error2]
        String[] errors = expectedMessages.split(";");
        //wait until number of errors will be expected
        webDriverWait10.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.xpath(listErrorsMessagesLocator), errors.length

                )
        );
        Util.waitABit(1);
        Assert.assertEquals("Number of elements ", errors.length,
                getListOfErrors().size());

        ArrayList<String> actualTextFromErrors = new ArrayList();
        for (WebElement element : getListOfErrors()) {
            actualTextFromErrors.add(element.getText());
        }

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertAll(); //check all soft assertions
        for (int i = 0; i < errors.length; i++) {
            softAssertions.assertThat(errors[i])
                    .as("Error " + i)
                    .isEqualToIgnoringCase(actualTextFromErrors.get(i));
        }

        return this;
    }

    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }
}