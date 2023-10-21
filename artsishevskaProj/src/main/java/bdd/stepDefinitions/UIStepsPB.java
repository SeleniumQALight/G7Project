package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.formula.functions.T;
import org.assertj.core.api.SoftAssertions;

public class UIStepsPB extends MainSteps{
    public UIStepsPB(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }
    @When("I open the PrivatBank website")
    public void iOpenThePrivatBankWebsite() {
        pageProvider.getPrivatBankHomePage().openPBHomePage();
    }
    @When("I save exchange rate for buy and sale for {string} from UI")
    public void iSaveExchangeRateForBuyAndSaleForFromUi(String currencyName) {
        pageProvider.getPrivatBankHomePage().getBuyAndSaleRateFromUI(currencyName);
    }
    @Then("I compare the API exchange rate with the UI exchange rate")
    public void iCompareTheAPIExchangeRateWithTheUIExchangeRate() {
        double exchangeRateBuyUIDouble = Double.parseDouble(TestData.rateBuyUI);
        double exchangeRateSaleUIDouble = Double.parseDouble(TestData.rateSaleUI);
        double exchangeRateBuyAPIDouble = Double.parseDouble(TestData.rateBuyAPI);
        double exchangeRateSaleAPIDouble = Double.parseDouble(TestData.rateSaleAPI);
        SoftAssertions softAssertions = new SoftAssertions();
        softAssertions.assertThat(exchangeRateBuyUIDouble)
                .as("Курс продажу валюти" + TestData.rateBuyUI + " з сайту приватбанку не співпадає з курсом продажу валюти з API")
                .isEqualTo(exchangeRateBuyAPIDouble);
        softAssertions.assertThat(exchangeRateSaleUIDouble)
                .as("Курс купівлі валюти" + TestData.rateBuyAPI + " з сайту приватбанку не співпадає з курсом купівлі валюти з API")
                .isEqualTo(exchangeRateSaleAPIDouble);
        softAssertions.assertAll();

       // pageProvider.getPrivatBankHomePage().compareApiAndUiRates();
    }
}
