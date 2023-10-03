package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Registration extends MainSteps {

    public Registration(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }


    @When("I fill the registration form with {} userName, {} email, {} password")
    public void iFillTheRegistrationFormWithUserNameEmailPassword(String userName, String email, String password) {
        pageProvider.getLoginPage().enterTextIntoRegistrationUserNameField(userName);
        pageProvider.getLoginPage().enterTextIntoRegistrationEmailField(email);
        pageProvider.getLoginPage().enterTextIntoRegistrationPasswordField(password);
    }

    @Then("I should see the error message {}")
    public void iShouldSeeTheErrorMessage(String expectedErrorMessage) {
        pageProvider.getLoginPage().checkErrorsMessage(expectedErrorMessage);
    }
}

