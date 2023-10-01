package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;


public class RegistrationErrorMsSteps extends MainSteps {
    public RegistrationErrorMsSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @When("I enter {string} into input Login in Registration form")
    public void iEnterIntoInputLoginInRegistrationForm(String userName) {
        pageProvider.getLoginPage().enterTextIntoRegistrationUserNameField(userName);
    }

    @When("I enter {string} into input Email in Registration form")
    public void iEnterIntoInputEmailInRegistrationForm(String email) {
        pageProvider.getLoginPage().enterTextIntoRegistrationEmailField(email);
    }

    @When("I enter {string} into input Password in Registration form")
    public void iEnterIntoInputPasswordInRegistrationForm(String password) {
        pageProvider.getLoginPage().enterTextIntoRegistrationPasswordField(password);
    }

    @Then("I see {string} in Registration form")
    public void iSeeErrorMessageInRegistrationForm(String textOfMessage) {
        pageProvider.getLoginPage().checkErrorsMessages(textOfMessage);
    }
}
