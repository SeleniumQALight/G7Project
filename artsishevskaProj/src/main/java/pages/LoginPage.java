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

public class LoginPage extends ParentPage{
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUserName;
    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;
    @FindBy(xpath = ".//button[@class='btn btn-primary btn-sm']")
    private WebElement buttonSignIn;
    @FindBy(xpath = "//button[text() = 'Sign Out']")
    private WebElement buttonSignOut;

    @FindBy(xpath = "//div[@class='alert alert-danger text-center' and text() = 'Invalid username / pasword']")
    private WebElement messageInvalidUserNameOrPassword;

    @FindBy(id="username-register")
    private WebElement inputUserNameRegistration;

    @FindBy(id="email-register")
    private WebElement inputEmailRegistration;

    @FindBy(id="password-register")
    private WebElement inputPasswordRegistration;

    //це як варіант webDriver.findElement(By.xpath("//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']"));
    // @FindBy(xpath = "@FindBy(xpath = \"//div[@class='alert alert-danger text-center' and text() = 'Invalid username / pasword']\")\n" +
    // " private WebElement messageInvalidUsernameAndPassword;")
    // private List<WebElement> alertDanger;
    final String listErrorsMessagesLocator = "//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public void openLoginPage(){
        openPage(BASE_URL);
        checkUrl();
    }
    public void enterTextIntoInputUserName(String userName){
        enterTextIntoInput(inputUserName, userName);
    }
    public void enterTextIntoInputPassword(String password){
        enterTextIntoInput(inputPassword, password);
    }
    public void clickOnButtonSignIn(){
        clickOnElement(buttonSignIn);
    }
    public void clickOnButtonSignOut(){
        clickOnElement(buttonSignOut);
    }
    public void checkIsButtonSignInVisible(){
        checkElementDisplayed(buttonSignIn);
    }
    public void checkIsFieldLoginVisible(){
        checkElementDisplayed(inputUserName);
    }
    public void checkIsFieldPasswordVisible(){
        checkElementDisplayed(inputPassword);
    }
    public void checkNotIsButtonSignInVisible(){
        checkElementNotDisplayed(buttonSignIn);
    }
    public void checkNotIsFieldLoginVisible(){
        checkElementNotDisplayed(inputUserName);
    }
    public void checkNotIsFieldPasswordVisible(){
        checkElementNotDisplayed(inputPassword);
    }

    public LoginPage getLoginPage(){
        return new LoginPage(webDriver);
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
        String[] errors = expectedMessages.split(";");
        webDriverWait10.until(ExpectedConditions.numberOfElementsToBe(
                By.xpath(listErrorsMessagesLocator), errors.length));
        Util.waitABit(1);//стільки часу чекаємо, щоб відобразилися всі елементи
        Assert.assertEquals("Number of elements",errors.length,
                getListOfErrors().size());
        ArrayList actualTextFromErrors = new ArrayList();
        for (WebElement element:getListOfErrors()) {
            actualTextFromErrors.add(element.getText());
        }
        SoftAssertions softAssertions = new SoftAssertions();
        for (int i = 0; i < errors.length; i++) {
            softAssertions.assertThat(errors[i])
                    .as("Error text" +i)
                    .isIn(actualTextFromErrors.get(i).toString());

        }
        softAssertions.assertAll();
        return this;
    }

    private List<WebElement> getListOfErrors() {
        return  webDriver.findElements(By.xpath(listErrorsMessagesLocator));
    }
}
