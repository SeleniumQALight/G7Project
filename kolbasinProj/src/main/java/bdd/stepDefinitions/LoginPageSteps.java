package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends MainSteps{
    public LoginPageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open Login page")
    public void iOpenLoginPage() {
        pageProvider.getLoginPage().openLoginPage();
    }

    @When("I login with valid cred")
    public void i_login_with_valid_cred() {
        pageProvider.getLoginPage().enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
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
    @When("I click on button in Login form")
    public void i_click_on_button_in_login_form() {
        pageProvider.getLoginPage().clickOnButtonSignIn();
    }
    @Then("I see alert message with text {string}")
    public void i_see_alert_message_with_text(String textOfMessage) {
        pageProvider.getLoginPage().checkIsErrorMessageVisible(textOfMessage);
    }

}
