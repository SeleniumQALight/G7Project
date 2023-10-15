package api;

import api.dto.responseDto.CurrencyDto;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

public class CurrencyApiHelper {

    Logger logger = Logger.getLogger(getClass());

    private String url;
    private final boolean withParams;

    public CurrencyApiHelper() {

        this.url = EndPoints.CURRENCY_RATES_API_ENDPOINT;
        this.withParams = false;

    }

    public CurrencyApiHelper(String queryParams) {

        this.url = EndPoints.CURRENCY_RATES_API_ENDPOINT + "?" + queryParams.replace(", ", "&");
        this.withParams = true;

    }

    public CurrencyDto[] getCurrencies(int courseId) {

        if (withParams) {
            url += String.format("&coursid=%s", courseId);
        } else {
            url += String.format("?coursid=%s", courseId);
        }

        CurrencyDto[] responseBody =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .when()
                        .get(url)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response().as(CurrencyDto[].class);

        for (int i = 0; i < responseBody.length; i++) {
            logger.info(
                    String.format("Currency %s buy %s sale %s",
                            responseBody[i].getCcy(),
                            responseBody[i].getBuy(),
                            responseBody[i].getSale())
            );
        }

        return responseBody;

    }

}
