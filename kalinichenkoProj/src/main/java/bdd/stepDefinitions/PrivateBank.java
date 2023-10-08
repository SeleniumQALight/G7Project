package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;
import privatbankApi.ApiHelper;
import privatbankApi.responsDto.ActualCursPrivateDto;

import java.util.HashMap;
import java.util.Map;


public class PrivateBank extends MainSteps {
    public PrivateBank(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    Logger logger = Logger.getLogger(getClass());
    ApiHelper apiHelper = new ApiHelper();


    @Given("I get {string} rates via Private Bank API")
    public Map iGetCurrencyRatesViaPrivateBankAPI(String currency) {
        Map currencyRates = new HashMap();
        ActualCursPrivateDto[] allCurrency = apiHelper.getAllActualCurrency();
        for (int i = 0; i < allCurrency.length; i++) {
            if (allCurrency[i].getCcy().equals(currency)) {
                currencyRates.put("buy", allCurrency[i].getBuy());
                currencyRates.put("sale", allCurrency[i].getSale());
            }
        }
        Assert.assertTrue("Currency not found", currencyRates.size() > 0);
        logger.info(currencyRates.get("buy"));
        logger.info(currencyRates.get("sale"));
        return currencyRates;
    }

    @When("I get {string}  rates from Private Bank site")
    public void iGetCurrencyRatesFromPrivateBankSite(String currency) {
    }


    @Then("I compare rates from Private Bank API and rates from Private Bank site fore {string} currency")
    public void iCompareRatesFromPrivateBankAPIAndRatesFromPrivateBankSiteForeCurrency(String currency) {

    }
}
