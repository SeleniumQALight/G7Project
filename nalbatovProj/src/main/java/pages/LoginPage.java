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
import java.util.Collection;
import java.util.List;

public class LoginPage extends ParentPage{
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;

    @FindBy(id = "username-register")
    private WebElement inputUserNameRegistration;

    @FindBy(id = "email-register")
    private WebElement inputEmailRegistration;

    @FindBy(id = "password-register")
    private WebElement inputPasswordRegistration;

    // the same as webDriver.findElements(By.xpath(".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']"));
    //  @FindBy(xpath = ".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']")
    //  private List<WebElement> listErrorsMessage;

    final String listErrorsMessagesLocator = ".//*[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }
    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public void openLoginPage() {
        openPage(BASE_URL);
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
        // error1:error2 -> [error1, error2]
        String[] errors = expectedMessages.split(";");
        //  wait until all number of  errors will be expected
        webDriverWait10.until((ExpectedConditions.numberOfElementsToBe(
                By.xpath(listErrorsMessagesLocator), errors.length)));
        Util.waitABit(1); // wait until EXTRA errors will be displayed

        Assert.assertEquals("Number of elements", errors.length,
                getListOfErrors().size());

        ArrayList actualTextFromErrors = new ArrayList();
        for (WebElement element : getListOfErrors()) {
            actualTextFromErrors.add(element.getText());
        }

        SoftAssertions softAssertions = new SoftAssertions();

        for (int i = 0; i < errors.length; i++) {
            softAssertions.assertThat(errors[i])
                    .as("Error " + i).isIn(actualTextFromErrors);

        }


        softAssertions.assertAll();// check all assertions




        return this;
    }

    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }
}
