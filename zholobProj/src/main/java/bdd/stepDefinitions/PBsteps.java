package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import libs.Util;

public class PBsteps extends MainSteps{
    private org.openqa.selenium.WebDriver WebDriver;

    public PBsteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open page PB")
    public void iOpenPagePB() {
        pageProvider.getPBpage().openPBpage();
        Util.waitABit(2);
        pageProvider.getPBpage().checkIsTitleExchangeRatesVisible();
        Util.waitABit(2);
    }

    @Then("I compare course {string} via API and site")
    public void i_compare_course_via_api_and_site(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @io.cucumber.java.en.When("I getting a course {string} the site")
    public void iGettingACourseTheSite(String currency) {
        pageProvider.getPBpage().getExchangeRateBuyOnTheWeb1(currency);
        pageProvider.getPBpage().getExchangeRateSaleOnTheWeb(currency);
    }

    @And("I getting a course {string} via API")
    public void iGettingACourseViaAPI(String currency) {
    }
}
