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
import testData.TestData;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LoginPage extends ParentPage {
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;

    @FindBy( id="username-register")
    private WebElement inputUserNameRegistration;

    @FindBy( id="email-register")
    private WebElement inputEmailRegistration;

    @FindBy( id="password-register")
    private WebElement inputPasswordRegistration;

    // same as webDriver.findElements(By.xpath(".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']"));
    //@FindBy(xpath = ".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']")
    //private List<WebElement> alertDanger;

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
    public void enterTextIntoInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }

    @Step
    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }

    @Step
    public void loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
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
        String [] errors = expectedMessages.split(";");
        // wait until all errors are visible
        webDriverWait10.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.xpath(listErrorsMessagesLocator), errors.length));
        Util.waitABit(1);// wait until EXTRA errors will be displayed
        Assert.assertEquals(
                "Number of messages",
                errors.length,
                getListOfErrors().size());

        ArrayList ActualTextsFromErrors = new ArrayList();
        for (WebElement element : getListOfErrors()) {
        ActualTextsFromErrors.add(element.getText());
        }

        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < errors.length; i++) {
            softAssertions.assertThat(errors[i])
                    .as("Message #" + i + " ")
                    .isIn(ActualTextsFromErrors);

        }

        softAssertions.assertAll(); // check all soft assertions

        return this;
    }

    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }
}
