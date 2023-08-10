package pages;

import data.TestData;
import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='Username']")

    private WebElement inputUserName;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[text()='Invalid username / pasword']")
    private WebElement errorMessageInvalidUsernamePassword;
    @FindBy(id="username-register")
    private WebElement inputUserNameRegistration;

    @FindBy(id="email-register")
    private WebElement inputEmailRegistration;

    @FindBy(id="password-register")
    private WebElement inputPasswordRegistration;

    final String listErrorsMessagesLocator = "//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";

    final String loginErrorLocator =  "//div[text()='Invalid username / pasword']";


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        openPage(BASE_URL);
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

    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
    }

    public void checkIsInputUserNameDisplayed() {
        checkElementDisplayed(inputUserName);
    }

    public void checkIsInputPasswordDisplayed() {
        checkElementDisplayed(inputPassword);
    }

    public void checkIsButtonSignInNotVisible() {
        checkElementNotDisplayed(buttonSignIn);
    }

    public void checkIsInputUserNameIsNotDisplayed() {
        checkElementNotDisplayed(inputUserName);
    }

    public void checkIsInputPasswordIsNotDisplayed() {
        checkElementNotDisplayed(inputPassword);
    }

    public void checkIsErrorMessageInvalidUsernamePasswordDisplayed() {
        checkElementDisplayed(errorMessageInvalidUsernamePassword);
    }

    public void loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
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

    public LoginPage checkErrorsMessages(String expectedMessages) {
        // error1;error2 -> [error1, error2]
        String[] errors = expectedMessages.split(";");
        // wait until number of errors will be expected
        webDriverWait10.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.xpath(listErrorsMessagesLocator), errors.length));
        Util.waitABit(1); // wait until all errors will be visible
        Assert.assertEquals("Number of elements ", errors.length, getListOfErrors().size());

        ArrayList actualTextFromErrors = new ArrayList();
        for (WebElement element : getListOfErrors()) {
            actualTextFromErrors.add(element.getText());

        }

        SoftAssertions softAssertions = new SoftAssertions(); // об'єкт для накоплювальоних перевірок
        for (int i = 0; i < errors.length; i++) {

            softAssertions.assertThat(errors[i])
                    .as("Error " + i)
                    .isIn(actualTextFromErrors);

        }


        softAssertions.assertAll(); // перевірка всіх накоплювальних перевірок


        return this;
    }

    private List<WebElement> getListOfErrors() {
                return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }



    public LoginPage checkLoginErrors(String expectedMessages) {
                String[] errors = expectedMessages.split(";");
                webDriverWait10.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.xpath(loginErrorLocator), errors.length));
        Util.waitABit(1);
        Assert.assertEquals("Number of elements ", errors.length, getLoginErrors().size());

        ArrayList actualTextFromErrors = new ArrayList();
        for (WebElement element : getLoginErrors()) {
            actualTextFromErrors.add(element.getText());

        }

        SoftAssertions softAssertions = new SoftAssertions(); // об'єкт для накоплювальоних перевірок
        for (int i = 0; i < errors.length; i++) {

            softAssertions.assertThat(errors[i])
                    .as("Error " + i)
                    .isIn(actualTextFromErrors);

        }


        softAssertions.assertAll(); // перевірка всіх накоплювальних перевірок


        return this;
    }

    private List<WebElement> getLoginErrors() {
        return webDriver.findElements(By.xpath(loginErrorLocator));
    }



}

