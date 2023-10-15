package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.Assert;
import privatBankApi.PrivatBankEndpoints;
import privatBankApi.dto.ExamCurrencyDetails;

import static data.TestData.*;
import static io.restassured.RestAssured.given;

public class PrivatDefinitions extends MainSteps {

    public PrivatDefinitions(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @When("I find out exchange rates for {} from API")
    public void iFindOutExchangeRatesForFromAPI(String currency) {
        ExamCurrencyDetails[] examPrivat = given()
                .contentType(ContentType.JSON)
                .log().all()
                .get(PrivatBankEndpoints.EXAM_URL)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().body().as(ExamCurrencyDetails[].class);
        for (int i = 0; i < examPrivat.length; i++) {
            if (examPrivat[i].getCcy().equals(currency)) {
                apiCurrencyBuySaleRates[0] = examPrivat[i].getBuy();
                apiCurrencyBuySaleRates[1] = examPrivat[i].getSale();
            }
        }
    }

    @And("I find out exchange rates for {} from UI")
    public void iFindOutExchangeRatesForFromUI(String currency) {
        pageProvider.getMainPrivatPage().openMainPage().discoverUiCurrencyBuySaleRate(currency);
    }

    @Then("I compare results for {} from API and UI")
    public void iCompareResultsForFromAPIAndUI(String currency) {
        Assert.assertEquals("buy rates isn't equal", apiCurrencyBuySaleRates[0], uiCurrencyBuySaleRates[0]);
        Assert.assertEquals("sell rates isn't equal", apiCurrencyBuySaleRates[1], uiCurrencyBuySaleRates[1]);
    }
}

