package bdd.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import privatBankApi.PrivatBankEndpoints;
import privatBankApi.dto.ExamPrivat;

import static io.restassured.RestAssured.given;

public class PrivatDefinitions {
    @When("I find out exchange rates from API")
    public void iFindOutExchangeRatesFromAPI() {
        ExamPrivat examPrivat = given()
                .contentType(ContentType.JSON)
                .log().all()
                .get(PrivatBankEndpoints.EXAM_URL)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().body().as(ExamPrivat.class);
    }

    @And("I find out exchange rates from UI")
    public void iFindOutExchangeRatesFromUI() {
    }

    @Then("I compare results from API and UI")
    public void iCompareResultsFromAPIAndUI() {
    }
}
