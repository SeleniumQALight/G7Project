package api;

import data.TestData;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static org.junit.Assert.assertEquals;

public class ApiHelperPb {
    private Response apiResponse;

    public void sendGetRequestForCurrencyExchangeRates() {
        apiResponse = RestAssured
                .given()
                .queryParam("json", "")
                .queryParam("exchange", "")
                .queryParam("coursid", "5")
                .when()
                .get("https://api.privatbank.ua/p24api/pubinfo");
        apiResponse.then().statusCode(200);
        assertEquals("Response status code is not 200", 200, apiResponse.getStatusCode());
    }

    private DecimalFormat getDecimalFormat() {
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        decimalFormatSymbols.setDecimalSeparator('.');
        return new DecimalFormat("#.##", decimalFormatSymbols);
    }

    public void extractExchangeRatesForCurrency(String currency) {
        try {
            double buyValue = apiResponse.jsonPath().getDouble("find { it.ccy == '" + currency + "' }.buy");
            double sellValue = apiResponse.jsonPath().getDouble("find { it.ccy == '" + currency + "' }.sale");
            DecimalFormat decimalFormat = getDecimalFormat();

            TestData.setApiExchangeRateBuy(decimalFormat.format(buyValue));
            TestData.setApiExchangeRateSell(decimalFormat.format(sellValue));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}