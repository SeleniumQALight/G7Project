package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import testData.TestData;

public class LoginPageSteps extends MainSteps{
    public LoginPageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open Login page")
    public void iOpenLoginPage() {
       pageProvider.getloginPage().openLoginPage();
    }
    @When("I login with valid cred")
    public void i_enter_valid_cred() {
        pageProvider.getloginPage().enterTextIntoInputUserName(TestData.LOGIN_DEFAULT);
        pageProvider.getloginPage().enterTextIntoInputPassword(TestData.PASSWORD_DEFAULT);
        pageProvider.getloginPage().clickOnButtonSignIn();
    }
}
