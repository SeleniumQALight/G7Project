package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static test_data.TestData.*;

public class LoginPageSteps extends MainSteps {
    public LoginPageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open login page")
    public void iOpenLoginPage() {
        pageProvider.getLoginPage().openLoginPage();
    }

    @When("I login with valid cred")
    public void i_login_with_valid_cred() {
        pageProvider.getLoginPage().enterTextIntoInputUserName(LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
    }

    @When("I enter {string} into login field in login form")
    public void i_enter_into_login_field_in_login_form(String username) {
        pageProvider.getLoginPage().enterTextIntoInputUserName(username);
    }

    @When("I enter {string} into password field in login form")
    public void i_enter_into_password_field_in_login_form(String password) {
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
    }

    @When("I click on SignIn button in login form")
    public void i_click_button_in_login_form() {
        pageProvider.getLoginPage().clickOnButtonSignIn();
    }

    @Then("I see alert message with text {string}")
    public void i_see_alert_message_with_text(String textOfAlertMessage) {
        pageProvider.getLoginPage().checkIsErrorMassageVisible(textOfAlertMessage);
    }
}
