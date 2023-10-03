package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import libs.Util;

public class RegistrationStepdefs extends MainSteps{
    public RegistrationStepdefs(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }//конструктор

    @When("I enter {string} into input in Login formin Registration form")
    public void iEnterIntoInputInLoginForminRegistrationForm(String userName) {
        Util.waitABit(2);
        pageProvider.getloginPage().enterTextIntoRegistrationUserNameField(userName);
    }

    @When("I enter {string} into input Email in Registration form")
    public void i_enter_into_input_email_in_registration_form(String email) {
        Util.waitABit(2);
        pageProvider.getloginPage().enterTextIntoRegistrationEmailField(email);
    }

    @When("I enter {string} into input Password in Registration form")
    public void i_enter_into_input_password_in_registration_form(String password) {
        Util.waitABit(2);
        pageProvider.getloginPage().enterTextIntoRegistrationPasswordField(password);

    }
    @Then("I see {string} in Registration form")
    public void iSeeErrorMessageInRegistrationForm(String textOfMessage) {
        Util.waitABit(2);
        pageProvider.getloginPage().checErrorsMessages(textOfMessage);
    }
}
