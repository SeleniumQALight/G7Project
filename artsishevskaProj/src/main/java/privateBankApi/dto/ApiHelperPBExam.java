package privateBankApi.dto;

import io.restassured.http.ContentType;

import java.text.DecimalFormat;

import static io.restassured.RestAssured.given;

public class ApiHelperPBExam {
    public ExchangeRateDtoPBExam[] getCurrencyRateTestExam() {
        ExchangeRateDtoPBExam[] responseExchangeRateDtoExam = given()
                .contentType(ContentType.JSON)
                .queryParam("json", "")
                .queryParam("exchange", "")
                .queryParam("coursid", "5")
                .log().all()
                .when()
                .get(PrivateBankEndPoints.CURRENCY_RATE_EXAM)
                .then()
                .statusCode(200)
                .log().all()
                .assertThat()
                .extract().body().as(ExchangeRateDtoPBExam[].class);
        return responseExchangeRateDtoExam;
    }
    public static DecimalFormat getDecimalFormat(){
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setMaximumFractionDigits(2);
        decimalFormat.setMinimumFractionDigits(2);
        return decimalFormat;
    }
}
