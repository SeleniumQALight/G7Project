package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.Given;
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
}
