package bdd.stepDefinitions;

import bdd.helper.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends MainSteps {
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

    @When("I click on button SignIn in Login form")
    public void i_click_on_button_sign_in_in_login_form() {
        pageProvider.getLoginPage().clickOnButtonSignIn();
    }

    @Then("I see alert message with text {string}")
    public void i_see_alert_message_with_text(String textOfErrorMessage) {
        pageProvider.getLoginPage().checkIsErrorMessageVisible(textOfErrorMessage);
    }

    @When("I enter {string} into username field in Registration form")
    public void i_enter_into_username_field_in_registration_form(String username) {
        pageProvider.getLoginPage().enterTextIntoRegistrationUserNameField(username);
    }

    @When("I enter {string} into Email field in Registration form")
    public void i_enter_into_Email_field_in_registration_form(String email) {
        pageProvider.getLoginPage().enterTextIntoRegistrationEmailField(email);
    }

    @When("I enter {string} into password field in Registration form")
    public void i_enter_into_password_field_in_registration_form(String password) {
        pageProvider.getLoginPage().enterTextIntoRegistrationPasswordField(password);
    }


    @Then("I see the following error message {string}")
    public void i_see_the_following_error_message(String errorMessage) {
        pageProvider.getLoginPage().checkErrorsMessages(errorMessage);
    }

}



