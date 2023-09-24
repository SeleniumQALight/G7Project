package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.And;
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

    @When("I login with valid credentials")
    public void iEnterValidCredentials() {
        pageProvider.getLoginPage().enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
    }

    @When("I enter {string} into Login input in Login form")
    public void i_enter_into_login_input_in_login_form(String userName) {
        pageProvider.getLoginPage().enterTextIntoInputUserName(userName);
    }
    @When("I enter {string} into Password input in Login form")
    public void i_enter_into_password_input_in_login_form(String password) {
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
    }
    @When("I click the SignIn button in Login form")
    public void i_click_the_sign_in_button_in_login_form() {
        pageProvider.getLoginPage().clickOnButtonSignIn();
    }
    @Then("I see error message {string}")
    public void i_see_error_message(String expectedErrorMessageLogin) {
        pageProvider.getLoginPage().checkErrorMessageLogin(expectedErrorMessageLogin);
    }

    @When("I enter {string} into username input in Registration form")
    public void iEnterIntoUsernameInputInRegistrationForm(String username) {
        pageProvider.getLoginPage().enterTextIntoRegistrationUserName(username);
    }

    @And("I enter {string} into Email input in Registration form")
    public void iEnterIntoEmailInputInRegistrationForm(String email) {
        pageProvider.getLoginPage().enterTextIntoRegistrationEmail(email);
    }

    @And("I enter {string} into Password input in Registration form")
    public void iEnterIntoPasswordInputInRegistrationForm(String password) {
        pageProvider.getLoginPage().enterTextIntoRegistrationPassword(password);
    }

    @Then("I see the following error messages: {string}")
    public void iSeeErrorMessages(String errorMessages) {
        pageProvider.getLoginPage().checkErrorsMessages(errorMessages);
    }

}

