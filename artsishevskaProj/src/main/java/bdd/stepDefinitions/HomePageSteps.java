package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.Then;

public class HomePageSteps extends MainSteps{
    public HomePageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Then("I see avatar Home page")
    public void iSeeAvatarHomePage() {
        pageProvider.getHomePage().getHeader().checkIsButtonMyProfileVisible();
    }
}
