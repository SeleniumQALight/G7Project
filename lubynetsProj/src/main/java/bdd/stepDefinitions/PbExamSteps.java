package bdd.stepDefinitions;

import api.ApiHelperPb;
import bdd.helpers.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;


public class PbExamSteps extends MainSteps {

    private String apiExchangeRate;

    Logger logger = Logger.getLogger(getClass());
    private ApiHelperPb apiHelper = new ApiHelperPb();

    public PbExamSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I send a GET request to the PrivatBank API for currency exchange rates {string}")
    public void iSendAGetRequestToThePrivatBankAPIForCurrencyExchangeRates(String currency) {
        apiHelper.sendGetRequestForCurrencyExchangeRates();
        apiHelper.extractExchangeRateForCurrency(currency);
    }


    @When("I remember the exchange rate for {string} from the Example table for {string}")
    public void iRememberTheExchangeRateForFromTheExampleTable(String currency, String transaction) {
        apiExchangeRate = apiHelper.rememberExchangeRateForCurrency(currency, transaction);
    }


    @When("I open the PrivatBank website")
    public void iOpenThePrivatBankWebsite() {
        currencyPage.openPrivatBankWebsite();
    }

    @Then("I retrieve the exchange rate for {string} from the website for {string}")
    public void iRetrieveTheExchangeRateForFromTheWebsite(String currency, String transaction) {
        String webRate = currencyPage.getExchangeRateUI(currency, transaction, "Web_" + transaction);
        String sellRate = currencyPage.getExchangeRateSellUI(currency, "Web_sell");

    }

    @Then("I compare the {string} exchange rate from the API with the {string} exchange rate from the website")
    public void iCompareTheExchangeRates(String apiTransaction, String webTransaction) {
        String apiRate = apiExchangeRate;
        String webRate = TestData.getExchangeRate("Web_" + webTransaction);
        logger.info("API rate: " + apiRate);
        logger.info("Web rate: " + webRate);
        assertEquals("Exchange rates do not match", apiRate, webRate);
        logger.info("Exchange rates match");

    }

    @And("I compare sell {string} exchange rate from the API with the sell exchange rate from the website")
    public void iCompareSellExchangeRateFromTheAPIWithTheSellExchangeRateFromTheWebsite(String currency) {
        String apiSellRate = apiHelper.getApiExchangeRateSell();
        String webSellRate = currencyPage.getExchangeRateSell(currency);

        logger.info("API sell rate for " + currency + ": " + apiSellRate);
        logger.info("Web sell rate for " + currency + ": " + webSellRate);

        assertEquals("Sell exchange rates do not match", apiSellRate, webSellRate);
        logger.info("Sell exchange rates match");
    }

}
