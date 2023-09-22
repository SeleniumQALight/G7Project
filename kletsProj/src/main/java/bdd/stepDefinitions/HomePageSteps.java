package bdd.stepDefinitions;

import bdd.helper.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps extends MainSteps {
    final String DEFAULT = "default"; // default username

    public HomePageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Then("I see avatar on Home page")
    public void iSeeAvatarOnHomePage() {
        pageProvider.getHomePage().getHeader().checkIsLinkAvatarVisible();
    }


    @Given("I open Home page as {string} user with {string} password")
    public void iOpenHomePage(String userName, String password) {
        if (DEFAULT.equalsIgnoreCase(userName)) { // if username is default
            userName = TestData.LOGIN_API_DEFAULT; // set default username
        }

        if (DEFAULT.equalsIgnoreCase(password)) { // if password is default
            password = TestData.PASSWORD_API_DEFAULT; // set default password
        }

        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(userName);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().checkIsRedirectToHomePage();
    }

    @When("I click on MyProfile button")
    public void iClickOnMyProfileButton() {
        pageProvider.getHomePage().getHeader().clickOnMyProfileButton();
    }


}
