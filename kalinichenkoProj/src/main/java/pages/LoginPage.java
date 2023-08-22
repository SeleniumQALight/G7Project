package pages;

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
    @FindBy(id = "username-register")
    private WebElement inputUserNameRegistration;

    @FindBy(id = "email-register")
    private WebElement inputEmailRegistration;

    @FindBy(id = "password-register")
    private WebElement inputPasswordRegistration;

    // the same as webDriver.findElements(By.xpath(".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']"));
    //  @FindBy(xpath = ".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']")
    //  private List<WebElement> listErrorsMessage;

    final String listErrorsMessageLocator = ".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }
    public void openLoginPage() {
        openPage(baseUrl);
        checkUrl();
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

    public LoginPage enterTextIntoRegistrationUserNameField(String userName) {
        enterTextIntoInput(inputUserNameRegistration, userName);
        return this;
    }

    public LoginPage enterTextIntoRegistrationEmailField(String email) {
        enterTextIntoInput(inputEmailRegistration, email);
        return this;
    }

    public LoginPage enterTextIntoRegistrationPasswordField(String password) {
        enterTextIntoInput(inputPasswordRegistration, password);
        return this;
    }

    public LoginPage checkErrorsMessage(String expectedMessage) {
        String[] errors = expectedMessage.split(";");
        // wait until number of errors will be expected
        webDriverWait10.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.xpath(listErrorsMessageLocator), errors.length));
        Util.waitABit(1); // wait until EXTRA errors will be visible
        // check every error text
        Assert.assertEquals("Number of messages", errors.length,
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
        softAssertions.assertAll(); // check all messages
        return this;
    }

    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(By.xpath(listErrorsMessageLocator));
    }
}
