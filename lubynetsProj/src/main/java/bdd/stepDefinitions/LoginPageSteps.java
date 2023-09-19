package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps  extends MainSteps{
    public LoginPageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        pageProvider.getLoginPage().openLoginPage();
    }
    @When("I login with valid credentials")
    public void i_enter_valid_credentials() {
    pageProvider.getLoginPage().enterTextIntoInputUserName(TestData.LOGIN_DEFAULT1);
    pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
    pageProvider.getLoginPage().clickOnButtonSignIn();
    }

    @When("I enter {string} into input Login in Login form")
    public void i_enter_into_input_login_in_login_form(String username) {
        pageProvider.getLoginPage().enterTextIntoInputUserName(username);
    }

    @When("I enter {string} into input Password in Login form")
    public void i_enter_into_input_password_in_login_form(String password) {
      pageProvider.getLoginPage().enterTextIntoInputPassword(password);
    }

    @When("I click on button SignIn in Login form")
    public void i_click_on_button_sign_in_in_login_form() {
        pageProvider.getLoginPage().clickOnButtonSignIn();
    }

    @Then("I see alert message with text {string}")
    public void i_see_alert_message_with_text(String textOfMessage) {
        pageProvider.getLoginPage().checkIsErrorMessageVisible(textOfMessage);
    }

}
