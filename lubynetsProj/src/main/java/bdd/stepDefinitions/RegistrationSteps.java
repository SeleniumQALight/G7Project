package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class RegistrationSteps extends MainSteps {
    public RegistrationSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open Login page")
    public void iOpenLoginPage() {
        pageProvider.getLoginPage().openLoginPage();
    }

    @When("I enter {string} into input in Login form in Registration form")
    public void iEnterIntoInputInLoginFormInRegistrationForm(String userName) {
        pageProvider.getLoginPage().enterTextIntoRegistrationUserName(userName);
    }

    @And("I enter {string} into input Email in Registration form")
    public void i_enter_into_input_email_in_registration_form(String email) {
        pageProvider.getLoginPage().enterTextIntoRegistrationEmail(email);
    }

    @And("I enter {string} into input Password in Registration form")
    public void i_enter_into_input_password_in_registration_form(String password) {
        pageProvider.getLoginPage().enterTextIntoRegistrationPassword(password);

    }

    @Then("I see {string} in Registration form")
    public void iSeeErrorMessageInRegistrationForm(String textOfMessage) {
        pageProvider.getLoginPage().checkErrorsMessages(textOfMessage);
    }


}




