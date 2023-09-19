package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginPageSteps  extends MainSteps{
    public LoginPageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        pageProvider.getLoginPage().openLoginPage();
    }
    @When("I login with valid credentials")
    public void i_enter_valid_credentials() {
    pageProvider.getLoginPage().enterTextIntoInputUserName(TestData.LOGIN_DEFAULT1);
    pageProvider.getLoginPage().enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
    pageProvider.getLoginPage().clickOnButtonSignIn();
    }
}
