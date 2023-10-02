package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import bdd.helpers.privatbank.CourseTypeProvider;
import bdd.helpers.privatbank.Currency;
import bdd.helpers.privatbank.CurrencyStorage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class PrivatBankCurrencyRatesSteps extends MainSteps {

    private final CourseTypeProvider courseTypeProvider = new CourseTypeProvider();
    private final CurrencyStorage currencyStorage = new CurrencyStorage();

    public PrivatBankCurrencyRatesSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open page with currency rates on PrivatBank site")
    public void iOpenPageWithCurrencyRatesOnPrivatBankSite() {
        pageProvider.getPrivatBankCurrencyRatesPage().openPrivatBankCurrencyRatesPage();
    }

    @When("I check currency rates for {string} on the site")
    public void iCheckCurrencyRatesForOnTheSite(String courseTypeName) {

        Currency[] siteCurrencies = pageProvider.getPrivatBankCurrencyRatesPage().getCurrencyRates(courseTypeProvider.getCourseTypeByName(courseTypeName).getXpath());

    }

}
