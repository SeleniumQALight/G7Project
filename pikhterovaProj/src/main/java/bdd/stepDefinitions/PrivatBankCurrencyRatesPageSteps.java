package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import bdd.helpers.privatbank.CourseType;
import bdd.helpers.privatbank.Currency;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import testData.PrivatBankTestData;


public class PrivatBankCurrencyRatesPageSteps extends MainSteps {

    public PrivatBankCurrencyRatesPageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open page with currency rates on PrivatBank site")
    public void iOpenPageWithCurrencyRatesOnPrivatBankSite() {
        pageProvider.getPrivatBankCurrencyRatesPage().openPrivatBankCurrencyRatesPage();
    }

    @When("I check currency rates for {string} on the site")
    public void iCheckCurrencyRatesForOnTheSite(String courseTypeName) {

        CourseType courseType = PrivatBankTestData.courseTypeProvider.getCourseTypeByName(courseTypeName);

        Currency[] siteCurrencies = pageProvider.getPrivatBankCurrencyRatesPage().getCurrencyRates(
                courseType.getMenuItemXpath(),
                courseType.getWidgetXpath()
        );

        for (Currency currency : siteCurrencies) {
            PrivatBankTestData.currencyStorage.addSiteCurrency(currency);
        }

    }

    @Then("Currency rates on the site match with API with accuracy {}")
    public void currencyRatesOnTheSiteMatchWithApi(Float accuracy) {
        PrivatBankTestData.currencyStorage.checkCurrencies(accuracy);
    }

}
