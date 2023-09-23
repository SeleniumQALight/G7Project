package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageSteps extends MainSteps {
    final String DEFAULT = "default";

    public HomePageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Then("I see avatar Home page")
    public void iSeeAvatarHomePage() {
        pageProvider.getHomePage().getHeader().checkIsButtonMyProfileVisible();
    }

    @Given("I open Home page as {string} user with {string} password")
    public void iOpenHomePage(String userName, String password) {
        if (DEFAULT.equalsIgnoreCase(userName)) {
            userName = TestData.LOGIN_API_DEFAULT;

        }
        if (DEFAULT.equalsIgnoreCase(password)) {
            password = TestData.PASSWORD_API_DEFAULT;
        }
        pageProvider.getLoginPage().openLoginPage();
        pageProvider.getLoginPage().enterTextIntoInputUserName(userName);
        pageProvider.getLoginPage().enterTextIntoInputPassword(password);
        pageProvider.getLoginPage().clickOnButtonSignIn();
        pageProvider.getHomePage().checkIsRedirectToHomePage();
    }

    //    @When("I click on MyProfile button")
//    public void iClickOnMyProfile() {
    @When("I click on MyProfile")
    public void i_click_on_my_profile() {

        pageProvider.getHomePage().getHeader().clickOnMyProfileButton();
    }
}
