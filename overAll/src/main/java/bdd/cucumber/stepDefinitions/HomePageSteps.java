package bdd.cucumber.stepDefinitions;

import bdd.cucumber.WebDriverHelper;
import io.cucumber.java.en.Then;

public class HomePageSteps extends MainSteps{
    public HomePageSteps(TestUser testUser, WebDriverHelper webDriverHelper) {
        super(testUser, webDriverHelper);
    }

    @Then("I see Home page")
    public void iSeeHomePage() {
        pageProvider.getHomePage().checkIsRedirectToHomePage();

    }
}
