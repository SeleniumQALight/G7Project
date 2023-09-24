package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testData.TestData;

public class LoginPageSteps extends MainSteps{
    public LoginPageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open Login page")
    public void iOpenLoginPage() {
       pageProvider.getloginPage().openLoginPage();
    }
    @When("I login with valid cred")
    public void i_enter_valid_cred() {
        pageProvider.getloginPage().enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn();
    }


    @When("I enter {string} into input Login in Login form")
    public void i_enter_into_input_login_in_login_form(String username) {
        pageProvider.getloginPage().enterTextIntoInputUserName(username);
       // throw new io.cucumber.java.PendingException();
    }
    @When("I enter {string} into input Password in Login form")
    public void i_enter_into_input_password_in_login_form(String password) {
        pageProvider.getloginPage().enterTextIntoInputPassword(password);
       // throw new io.cucumber.java.PendingException();
    }
    @When("I click on button SignIn in Login form")
    public void i_click_on_button_sign_in_in_login_form() {
        pageProvider.getloginPage().clickOnButtonSignIn();
       // throw new io.cucumber.java.PendingException();
    }
    @Then("I see alert message with text {string}")
    public void i_see_alert_message_with_text(String textOfMessage) {
        pageProvider.getloginPage().checkIsErrorMessageVisible(textOfMessage);

    }
}
