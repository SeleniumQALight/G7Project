package bdd.stepDefinitions;

import api.ApiHelperPb;
import bdd.helpers.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.log4j.Logger;

import static org.junit.Assert.assertEquals;

public class PbExamSteps extends MainSteps {

    Logger logger = Logger.getLogger(getClass());
    private ApiHelperPb apiHelper = new ApiHelperPb();

    public PbExamSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I send a GET request to the PrivatBank API for currency and remember exchange rates {string}")
    public void iSendAGetRequestToThePrivatBankAPIForCurrencyExchangeRates(String currency) {
        apiHelper.sendGetRequestForCurrencyExchangeRates();
        apiHelper.extractExchangeRatesForCurrency(currency);

    }

    @And("I open the PrivatBank website")
    public void iOpenThePrivatBankWebsite() {
        currencyPage.openPrivatBankWebsite();
    }

    @And("I retrieve the exchange rates for {string} from the website")
    public void iRetrieveTheExchangeRatesForFromTheWebsite(String currency) {
        String buyRate = currencyPage.getExchangeRateUI(currency, "buy", "Web_buy");
        String sellRate = currencyPage.getExchangeRateSellUI(currency, "sell", "Web_sell");
    }

    @Then("I compare the exchange rates from the API with the exchange rates from the website")
    public void iCompareTheExchangeRatesFromTheAPIWithTheExchangeRatesFromTheWebsite() {
        String apiExchangeRateBuy = TestData.getApiExchangeRateBuy();
        String apiExchangeRateSell = TestData.getApiExchangeRateSell();

        String webBuyRate = TestData.getWebExchangeRateBuy("Web_buy");
        String webSellRate = TestData.getWebExchangeRateSell("Web_sell");

        logger.info("API buy rate: " + apiExchangeRateBuy);
        logger.info("API sell rate: " + apiExchangeRateSell);
        logger.info("_________________________");
        logger.info("Web buy rate: " + webBuyRate);
        logger.info("Web sell rate: " + webSellRate);
        logger.info("_________________________");


        assertEquals("Buy exchange rates do not match", apiExchangeRateBuy, webBuyRate);
        assertEquals("Sell exchange rates do not match", apiExchangeRateSell, webSellRate);

        logger.info("Buy and sell exchange rates match");
        logger.info("API buy " + apiExchangeRateBuy + " = " + "Web buy " + webBuyRate);
        logger.info("API sell " + apiExchangeRateSell + " = " + "Web sell " + webSellRate);
    }

}