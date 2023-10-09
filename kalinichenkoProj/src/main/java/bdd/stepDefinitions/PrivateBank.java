package bdd.stepDefinitions;

import PrivatBank.HomePagePrivatBank;
import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import privatbankApi.ApiHelper;
import privatbankApi.responsDto.ActualCursPrivateDto;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;


public class PrivateBank extends MainSteps {
    public PrivateBank(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    final String buyApi = "buyApi";
    final String saleApi = "saleApi";
    final String saleSait = "saleSait";
    final String buySait = "buySait";
    Logger logger = Logger.getLogger(getClass());
    ApiHelper apiHelper = new ApiHelper();

    Map currencyRates = new HashMap();

    @Given("I get {string} rates via Private Bank API")
    public void iGetCurrencyRatesViaPrivateBankAPI(String currency) {
        ActualCursPrivateDto[] allCurrency = apiHelper.getAllActualCurrency();
        for (int i = 0; i < allCurrency.length; i++) {
            if (allCurrency[i].getCcy().equals(currency)) {
                Double buy_Api = Double.valueOf(allCurrency[i].getBuy());
                BigDecimal buy = BigDecimal.valueOf(buy_Api);
                Double sale_Api = Double.valueOf(allCurrency[i].getSale());
                BigDecimal sale = BigDecimal.valueOf(sale_Api);
                currencyRates.put(buyApi, buy.setScale(2, RoundingMode.valueOf(5)));
                currencyRates.put(saleApi, sale.setScale(2, RoundingMode.valueOf(5)));
                System.out.println(currencyRates);
            }
        }
        Assert.assertTrue("Currency not found", currencyRates.size() > 0);
        logger.info(currencyRates.get(buyApi));
        logger.info(currencyRates.get(saleApi));
    }

    @When("I get {string}  rates from Private Bank site")
    public void iGetCurrencyRatesFromPrivateBankSite(String currency) {
        HomePagePrivatBank homePagePrivatBank = pageProvider.getHomePagePrivatBank();
        if (currency.equals("USD")) {
            Double buy_site = Double.valueOf(homePagePrivatBank.openHomepagePrivatBank().getUsdBuy().getText());
            BigDecimal buy = BigDecimal.valueOf(buy_site);
            Double sale_site = Double.valueOf(homePagePrivatBank.openHomepagePrivatBank().getUsdSell().getText());
            BigDecimal sale = BigDecimal.valueOf(sale_site);
            currencyRates.put(buySait, buy.setScale(2, RoundingMode.valueOf(5)));
            currencyRates.put(saleSait, sale.setScale(2, RoundingMode.valueOf(5)));
        } else if (currency.equals("EUR")) {
            Double buy_site = Double.valueOf(homePagePrivatBank.openHomepagePrivatBank().getEurBuy().getText());
            BigDecimal buy = BigDecimal.valueOf(buy_site);
            Double sale_site = Double.valueOf(homePagePrivatBank.openHomepagePrivatBank().getEurSell().getText());
            BigDecimal sale = BigDecimal.valueOf(sale_site);

            currencyRates.put(buySait, buy.setScale(2, RoundingMode.valueOf(5)));
            currencyRates.put(saleSait, sale.setScale(2, RoundingMode.valueOf(5)));
        } else {
            Assert.fail("Currency can be only USD or EUR");
        }
        logger.info(currencyRates.get(buySait));
        logger.info(currencyRates.get(saleSait));
    }


    @Then("I compare rates from Private Bank API and rates from Private Bank site fore {string} currency")
    public void iCompareRatesFromPrivateBankAPIAndRatesFromPrivateBankSiteForeCurrency(String currency) {
        SoftAssertions softAssertions = new SoftAssertions();
        System.out.println(currencyRates);
        softAssertions.assertThat(currencyRates.get(buyApi)).isEqualTo(currencyRates.get(buySait));
        softAssertions.assertThat(currencyRates.get(saleApi)).isEqualTo(currencyRates.get(saleSait));
        softAssertions.assertAll();
    }
}
