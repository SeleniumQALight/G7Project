package bdd.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import privatBankApi.PrivatBankEndpoints;
import privatBankApi.dto.ExamCurrencyDetails;

import static data.TestData.*;
import static io.restassured.RestAssured.given;

public class PrivatDefinitions {
    WebDriver webDriver;

    @When("I find out exchange rates from API")
    public void iFindOutExchangeRatesFromAPI() {
        ExamCurrencyDetails[] examPrivat = given()
                .contentType(ContentType.JSON)
                .log().all()
                .get(PrivatBankEndpoints.EXAM_URL)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().body().as(ExamCurrencyDetails[].class);
        for (ExamCurrencyDetails examCurrencyDetails : examPrivat) {
            apiCurrencyBuyRates.replace(examCurrencyDetails.getCcy(), examCurrencyDetails.getBuy());
        }
        System.out.println(apiCurrencyBuyRates);
    }

    @And("I find out exchange rates from UI")
    public void iFindOutExchangeRatesFromUI() {
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://privatbank.ua/");
        System.out.println(uiCurrencyBuyRates);
        for (int i = 0; i < webDriver.findElements(By.xpath("//div[@class='wr_inner course_type_container']//tbody//tr")).size(); i++) {
            uiCurrencyBuyRates.put(webDriver.findElement(By.xpath("//div[@class='wr_inner course_type_container']//tbody//tr[" + (i + 1) + "]//td[1]")).getText(),
                    Double.valueOf(webDriver.findElement(By.xpath("//div[@class='wr_inner course_type_container']//tbody//tr[" + (i + 1) + "]//td[3]")).getText()));
        }
        System.out.println(uiCurrencyBuyRates);
        webDriver.quit();
    }

    @Then("I compare results from API and UI")
    public void iCompareResultsFromAPIAndUI() {
        for (int i = 0; i < uiCurrencyBuyRates.size(); i++) {
            for (int j = 0; j < apiCurrencyBuyRates.size(); j++) {
                if (uiCurrencyBuyRates.keySet().toArray()[i].equals(apiCurrencyBuyRates.keySet().toArray()[j])) {
                    Assert.assertEquals("", apiCurrencyBuyRates.values().toArray()[i], uiCurrencyBuyRates.values().toArray()[j]);
                    System.out.println("Currency - " + apiCurrencyBuyRates.keySet().toArray()[j]
                            + ", it's exchange rate that we get from API (" + apiCurrencyBuyRates.values().toArray()[i]
                            + ") is equal to " + "exchange rate form UI ( " + uiCurrencyBuyRates.values().toArray()[j] + ")");
                    break;
            }
        }
    }
}
    }

