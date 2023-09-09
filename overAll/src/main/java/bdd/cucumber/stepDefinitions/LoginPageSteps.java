package bdd.cucumber.stepDefinitions;

import bdd.cucumber.WebDriverHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;



public class LoginPageSteps extends MainSteps{


    public LoginPageSteps(TestUser testUser, WebDriverHelper webDriverHelper) {
        super(testUser, webDriverHelper);
    }


    @Then("I should see error message")
    @Step("I should see error message")
    public void iEnterValidLoginCredentials() {
        pageProvider.getLoginPage().checkIsButtonSignInDisplayed();

    }

    @Given("I open Login page")
    public void iOpenLoginPage() {
        pageProvider.getLoginPage().openLoginPage();
    }

    @When("I enter {string} and {string} into inputs")
    public void iEnterAndIntoInputs(String login, String password) {
        pageProvider.getLoginPage().enterTextIntoInputUserName(login);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
    }

    @And("I click Login button")
    public void iClickLoginButton() {
        pageProvider.getLoginPage().clickOnButtonSignIn();
    }
}
