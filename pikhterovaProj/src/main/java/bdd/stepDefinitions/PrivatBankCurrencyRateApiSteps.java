package bdd.stepDefinitions;

import api.CurrencyApiHelper;
import api.dto.responseDto.CurrencyDto;
import bdd.helpers.privatbank.CourseType;
import bdd.helpers.privatbank.Currency;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import testData.PrivatBankTestData;


public class PrivatBankCurrencyRateApiSteps {

    private CurrencyApiHelper currencyApiHelper;

    @Given("I call API for currency rates with query parameters {string}")
    public void iCallApiForCurrencyRatesWithQueryParameters(String queryParams) {
        currencyApiHelper = new CurrencyApiHelper(queryParams);
    }

    @When("I check currency rates for {string} on API")
    public void iCheckCurrencyRatesForOnApi(String courseTypeName) {

        CourseType courseType = PrivatBankTestData.courseTypeProvider.getCourseTypeByName(courseTypeName);

        CurrencyDto[] apiCurrencies = currencyApiHelper.getCurrencies(courseType.getCourseId());

        for (CurrencyDto currencyDto : apiCurrencies) {

            Currency currency = new Currency(currencyDto.getCcy(), currencyDto.getBuy(), currencyDto.getSale());

            PrivatBankTestData.logger.info(String.format("API currency: %s", currency));

            PrivatBankTestData.currencyStorage.addApiCurrency(currency);

        }

    }
}
