package privatbankApi;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import privatbankApi.responsDto.ActualCursPrivateDto;
import static io.restassured.RestAssured.given;

public class ApiHelper {
    Logger logger = Logger.getLogger(getClass());


    public ActualCursPrivateDto[] getAllActualCurrency(){
                ActualCursPrivateDto[] responsAsDto =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .when()
                        .given().queryParam("json")
                        .queryParam("exchange")
                        .queryParam("coursid" , "5")
                        .get(EndPoints.TODAY_EXCHANGE_BASE_URL)
                        .then()
                        .log().all()
                        .extract().body().as(ActualCursPrivateDto[].class);
        logger.info(responsAsDto.toString());
        return responsAsDto;
    }
}

