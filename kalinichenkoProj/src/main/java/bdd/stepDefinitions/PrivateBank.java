package bdd.stepDefinitions;

import PrivatBank.HomePagePrivatBank;
import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import test_data.PrivatTestData;

import java.math.BigDecimal;
import java.math.RoundingMode;


public class PrivateBank extends MainSteps {
    public PrivateBank(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }


    Logger logger = Logger.getLogger(getClass());
    PrivatTestData privatTestData = new PrivatTestData();

    @When("I get {string}  rates from Private Bank site")
    public void iGetCurrencyRatesFromPrivateBankSite(String currency) {
        HomePagePrivatBank homePagePrivatBank = pageProvider.getHomePagePrivatBank();
        logger.info(privatTestData.currencyRates);
        Double buy_site = Double.valueOf(homePagePrivatBank.openHomepagePrivatBank().getCurrencyBuy(currency).getText());
        BigDecimal buy = BigDecimal.valueOf(buy_site);
        Double sale_site = Double.valueOf(homePagePrivatBank.openHomepagePrivatBank().getCurrencySell(currency).getText());
        BigDecimal sale = BigDecimal.valueOf(sale_site);
        privatTestData.currencyRates.put(privatTestData.buySait, buy.setScale(2, RoundingMode.valueOf(5)));
        privatTestData.currencyRates.put(privatTestData.saleSait, sale.setScale(2, RoundingMode.valueOf(5)));
        logger.info(privatTestData.currencyRates.get(privatTestData.buySait));
        logger.info(privatTestData.currencyRates.get(privatTestData.saleSait));
        logger.info(privatTestData.currencyRates);

    }


    @Then("I compare rates from Private Bank API and rates from Private Bank site fore {string} currency")
    public void iCompareRatesFromPrivateBankAPIAndRatesFromPrivateBankSiteForeCurrency(String currency) {
        SoftAssertions softAssertions = new SoftAssertions();
        System.out.println(privatTestData.currencyRates);
        softAssertions.assertThat(privatTestData.currencyRates.get(privatTestData.buyApi)).isEqualTo(privatTestData.currencyRates.get(privatTestData.buySait));
        softAssertions.assertThat(privatTestData.currencyRates.get(privatTestData.saleApi)).isEqualTo(privatTestData.currencyRates.get(privatTestData.saleSait));
        softAssertions.assertAll();
    }
}
