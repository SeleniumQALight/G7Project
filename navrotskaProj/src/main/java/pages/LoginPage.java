package pages;

import data.TestData;
import io.qameta.allure.Step;
import libs.DB_Util_seleniumUsers;
import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginPage extends ParentPage {

    @FindBy(xpath = ".//input[@placeholder='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;

    @FindBy(xpath = "//div[@class='alert alert-danger text-center']")
    private WebElement InvalidCredsError;

    @FindBy(id = "username-register")
    private WebElement inputUserNameRegistration;

    @FindBy(id = "email-register")
    private WebElement inputEmailRegistration;

    @FindBy(id = "password-register")
    private WebElement inputPasswordRegistration;

    //same as webDriver.findElements(By.xpath(".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']"));
    //  @FindBy(xpath = ".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']")
    //  private List<WebElement> alertDanger;

    final String listErrorsMessagesLocator = ".//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    @Step  //Allure
    public void openLoginPage() {
        openPage(BASE_URL);
        checkUrl();
    }
    @Step
    public void enterTextIntoInputUserName(String userName) {
        enterTextIntoInput(inputUserName, userName);
    }
    @Step
    public void checkIsInputUserNameNotVisible() {
        checkElementNotDisplayed(inputUserName);
    }
    @Step
    public void checkIsInputUserNameVisible() {
        checkElementDisplayed(inputUserName);
    }
    @Step
    public void enterTextIntoInputPassword(String password) {
        enterTextIntoInput(inputPassword, password);
    }
    @Step
    public void checkIsInputPasswordVisible() {
        checkElementDisplayed(inputPassword);
    }
    @Step
    public void checkIsInputPasswordNotVisible() {
        checkElementNotDisplayed(inputPassword);
    }
    @Step
    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }
    @Step
    public void checkIsButtonSignInVisible() {
        checkElementDisplayed(buttonSignIn);
    }
    @Step
    public void checkIsButtonSignInNotVisible() {
        checkElementNotDisplayed(buttonSignIn);
    }

    @Step
    public void isInvalidCredsErrorVisible() {
        checkElementDisplayed(InvalidCredsError);
    }
    @Step
    public void loginWithValidCreds() {
        openLoginPage();
        enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        clickOnButtonSignIn();
    }
    @Step
    public void loginWithValidCredsFromDB() throws SQLException, ClassNotFoundException  {
        openLoginPage();
        enterTextIntoInputUserName("newqaauto");
        enterTextIntoInputPassword(PasswordFromDB("newqaauto"));
        clickOnButtonSignIn();
    }
    @Step
    public String PasswordFromDB(String login) throws SQLException, ClassNotFoundException {
        DB_Util_seleniumUsers dbUtilSeleniumUsers = new DB_Util_seleniumUsers();
        String pass = dbUtilSeleniumUsers.getPassForLogin(login);
        return pass;
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
        // error1;error2 -> [error1, error2]
        String[] errors = expectedMessages.split(";");
        // wait until number of errors will be excepted
        webDriverWait10.until(
                ExpectedConditions.numberOfElementsToBe(
                        By.xpath(listErrorsMessagesLocator), errors.length));
        Util.waitABit(1); // wait until EXTRA errors will be displayed
        Assert.assertEquals("Number of elements ", errors.length,
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

        softAssertions.assertAll(); // check all soft assertions

        return this;
    }

    private List<WebElement> getListOfErrors() {
        return webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }
}




