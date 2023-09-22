package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps extends MainSteps{
    public LoginPageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        pageProvider.getLoginPage().openLoginPage();
    }

    @When("I login with valid cred")
    public void i_enter_valid_cred() {
        pageProvider.getLoginPage().enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        pageProvider.getLoginPage().clickOnButtonSignIn();
    }

    @When("I enter {string} in to input Login in Login form")
    public void iEnterInToInputLoginInLoginForm(String username) {
        pageProvider.getLoginPage().enterTextIntoInputUserName(username);

    }

    @When("I enter {string} in to input Password in Login form")
    public void iEnterInToInputPasswordInLoginForm(String password) {
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
    }


    @When("I click on the button SignIn in Login form")
    public void iClickOnTheButtonSignInInLoginForm() {
        pageProvider.getLoginPage().clickOnButtonSignIn();

    }

    @Then("I see alert message with text {string}")
    public void iSeeAlertMessageWithTextInvalidUsernamePassword(String textOfMessage) {
        pageProvider.getLoginPage().checkIsErrorMessageVisible(textOfMessage);
    }
}
