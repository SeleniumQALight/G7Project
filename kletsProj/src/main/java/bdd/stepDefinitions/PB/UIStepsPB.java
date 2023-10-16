package bdd.stepDefinitions.PB;

import bdd.helper.WebDriverHelper;
import bdd.stepDefinitions.MainSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class UIStepsPB extends MainSteps {


    public UIStepsPB(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @When("I open the PrivateBank website")
    public void i_open_the_private_bank_website() {
        pageProvider.getPrivateBankPage().openPrivateBankPage();
    }

    @When("I retrieve the exchange rate for buy and sell for {string} from the website")
    public void i_retrieve_the_exchange_rate_for_buy_and_sell_for_from_the_website(String expectedCurrency) {
        pageProvider.getPrivateBankPage().getBuyAnaSellRateFromUi(expectedCurrency);
    }

    @Then("I compare the exchange rate from the API with the website for {string}")
    public void i_compare_the_exchange_rate_from_the_api_with_the_website_for(String string) {
        pageProvider.getPrivateBankPage().compareRates();
    }
}