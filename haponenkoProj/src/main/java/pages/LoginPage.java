package pages;

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

import static data.TestData.LOGIN_DEFAULT;
import static data.TestData.PASSWORD_DEFAULT;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[contains (text(),'Invalid username / pasword')]")
    private WebElement errorMessage;

    @FindBy(id = "username-register")
    private WebElement inputUserNameRegistration;

    @FindBy(id = "email-register")
    private WebElement inputEmailRegistration;

    @FindBy(id = "password-register")
    private WebElement inputPasswordRegistration;

//    @FindBy(xpath = "//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']")
//    private List<WebElement> alertDanger; same as  listErrorsMessagesLocator

    final String listErrorsMessagesLocator = "//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";

    final String errorMessageLoginLocator = "//div[@class='alert alert-danger text-center']";
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
    public void enterTextIntoInputUserName(String userName) {
        enterTextIntoInput(inputUserName, userName);
    }

    @Step
    public void enterTextIntoInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    @Step
    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    @Step
    public void checkIsButtonSignInVisible() {
        checkElementIsDisplayed(buttonSignIn);
    }


    public void checkIsErrorMessageVisible() {
        checkElementIsDisplayed(errorMessage);
    }

    @Step
    public void checkIsInputUserNameVisible() {
        checkElementIsDisplayed(inputUserName);
    }

    @Step
    public void checkIsInputPasswordVisible() {
        checkElementIsDisplayed(inputPassword);
    }

    @Step
    public void checkIsButtonSignInNotVisible() {
        checkElementIsNotDisplayed(buttonSignIn);
    }

    @Step
    public void checkIsInputUserNameNotVisible() {
        checkElementIsNotDisplayed(inputUserName);
    }

    @Step
    public void checkIsInputPasswordNotVisible() {
        checkElementIsNotDisplayed(inputPassword);
    }

    @Step
    public void loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUserName(LOGIN_DEFAULT);
        enterTextIntoInputPassword(PASSWORD_DEFAULT);
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

    public LoginPage checkErrorsMessages(String expectedErrorMessages) {
        //error1; error2 -> [error1, error2]
        String[] errors = expectedErrorMessages.split(";");
        //wait until number of errors will be equal to expected
        webDriverWait10.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.xpath(listErrorsMessagesLocator), errors.length));
        Util.waitABit(1); //чекаємо 1 секунду, щоб впевнитись, що всі зайві еррори вже відобразилися
        Assert.assertEquals("Number of error messages", errors.length,
                getListOfErrors().size());

        ArrayList actualTextFromErrors = new ArrayList();
        for (WebElement element : getListOfErrors()) {
            actualTextFromErrors.add(element.getText());
        }

        SoftAssertions softAssertions = new SoftAssertions(); //обʼєкт, що додали з бібліотеки. Буде вміти накоплювати перевірки (всі тексти еррора) і казати що там не так
        for (int i = 0; i < errors.length; i++) {
            softAssertions.assertThat(errors[i])
                    .as("Error " + i)
                    .isIn(actualTextFromErrors.get(i).toString());
        }
        softAssertions.assertAll();
        return this;
    }

    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }

    public LoginPage checkErrorMessageLogin(String expectedErrorMessageLogin) {
        // Wait until the error message is visible
        webDriverWait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessageLoginLocator)));
        Util.waitABit(1);

        // Check that there is exactly one error message
        Assert.assertEquals("Number of error messages", 1, getErrorLogin().size());

        // Get the actual error message text
        String actualErrorMessage = getErrorLogin().get(0).getText();

        // Compare the expected and actual error messages
        Assert.assertEquals("Error message", expectedErrorMessageLogin, actualErrorMessage);

        return this;
    }

    private List<WebElement> getErrorLogin() {
        return webDriver.findElements(By.xpath(errorMessageLoginLocator));
    }
}
