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
import pages.elements.Header;

import java.util.ArrayList;
import java.util.List;

import static data.TestData.*;

public class LoginPage extends ParentPage {
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;
    @FindBy(xpath = ".//*[text()='Sign In']")
    private WebElement buttonSignIn;
    @FindBy(xpath = "//div[text()='Invalid username / pasword']")
    private WebElement invalidLoginMessage;
    @FindBy(id = "username-register")
    private WebElement inputUserNameRegistration;
    @FindBy(id = "email-register")
    private WebElement inputEmailRegistration;
    @FindBy(id = "password-register")
    private WebElement inputPasswordRegistration;
    //    @FindBy(xpath = "//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']")
//    private List<WebElement> alertDanger;
    final String listErrorsMessagesLocator = "//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";

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
    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
    }
    @Step
    public void checkIsButtonSignInNotVisible() {
        checkElementIsNotDisplayed(buttonSignIn);
    }
    @Step
    public void checkIsUserNameInputDisplayed() {
        checkElementDisplayed(inputUserName);
    }
    @Step
    public void checkIsPasswordInputDisplayed() {
        checkElementDisplayed(inputPassword);
    }
    @Step
    public void checkIsInvalidLoginMessageDisplayed() {
        checkElementDisplayed(invalidLoginMessage);
    }
    @Step
    public void loginWithValidCred() {
        openLoginPage();
        enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }
    @Step
    public String createValidPostAndCheckIfExist() {
        loginWithValidCred();
        Header header = new Header(webDriver);
        header.clickOnButtonCreatePost()
                .checkIsRedirectToCreatePostPage()
                .enterTextIntoInputTitle(POST_TITLE)
                .enterTextIntoInputBody(POST_BODY)
                .selectTextInDropDownByUI()
                .workWithCheckBox(CHECK_CHECKBOX)
                .clickOnButtonSaveNewPost();
        header.clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(POST_TITLE);
        return POST_TITLE;
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
        String[] errors = expectedMessages.split(";");
        //wait until number of errors will be equal to expected
        webDriverWait_10.until(ExpectedConditions.numberOfElementsToBe(By.xpath(listErrorsMessagesLocator), errors.length));
        Util.waitABit(1); //wait until EXTRA errors will be displayed
        Assert.assertEquals("Number of elements", errors.length, getListOfErrors().size());
        ArrayList actualTextFromErrors = new ArrayList();
        for (WebElement element : getListOfErrors()) {
            actualTextFromErrors.add(element.getText());
        }
        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < errors.length; i++) {
            softAssertions.assertThat(errors[i]).as("Error " + i).isIn(actualTextFromErrors);
        }

        softAssertions.assertAll(); // this is needed to show all errors in report


        return this;
    }
    @Step
    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }
}

