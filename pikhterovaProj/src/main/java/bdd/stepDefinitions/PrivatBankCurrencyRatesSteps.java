package bdd.stepDefinitions;

import api.CurrencyApiHelper;
import api.dto.responseDto.CurrencyDto;
import bdd.helpers.WebDriverHelper;
import bdd.helpers.privatbank.CourseType;
import bdd.helpers.privatbank.CourseTypeProvider;
import bdd.helpers.privatbank.Currency;
import bdd.helpers.privatbank.CurrencyStorage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;

public class PrivatBankCurrencyRatesSteps extends MainSteps {

    private final Logger logger = Logger.getLogger(getClass());

    private final CourseTypeProvider courseTypeProvider = new CourseTypeProvider();
    private final CurrencyStorage currencyStorage = new CurrencyStorage();

    private  final CurrencyApiHelper currencyApiHelper = new CurrencyApiHelper();

    public PrivatBankCurrencyRatesSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open page with currency rates on PrivatBank site")
    public void iOpenPageWithCurrencyRatesOnPrivatBankSite() {
        pageProvider.getPrivatBankCurrencyRatesPage().openPrivatBankCurrencyRatesPage();
    }

    @When("I check currency rates for {string} on the site")
    public void iCheckCurrencyRatesForOnTheSite(String courseTypeName) {

        CourseType courseType = courseTypeProvider.getCourseTypeByName(courseTypeName);

        Currency[] siteCurrencies = pageProvider.getPrivatBankCurrencyRatesPage().getCurrencyRates(
                courseType.getMenuItemXpath(),
                courseType.getWidgetXpath()
        );

        for (Currency currency : siteCurrencies) {
            currencyStorage.addSiteCurrency(currency);
        }

    }

    @When("I check currency rates for {string} on API")
    public void iCheckCurrencyRatesForOnApi(String courseTypeName) {

        CourseType courseType = courseTypeProvider.getCourseTypeByName(courseTypeName);

        CurrencyDto[] apiCurrencies = currencyApiHelper.getCurrencies(courseType.getCourseId());

        for (CurrencyDto currencyDto : apiCurrencies) {

            Currency currency = new Currency(currencyDto.getCcy(), currencyDto.getBuy(), currencyDto.getSale());

            logger.info(String.format("API currency: %s", currency));

            currencyStorage.addApiCurrency(currency);

        }

    }

    @Then("Currency rates on the site match with API with accuracy {}")
    public void currencyRatesOnTheSiteMatchWithApi(Float accuracy) {
        currencyStorage.checkCurrencies(accuracy);
    }

}
