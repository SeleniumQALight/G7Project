package privatbankApi;

import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import privatbankApi.responsDto.ActualCursPrivateDto;
import static io.restassured.RestAssured.given;

public class ApiHelper {
    Logger logger = Logger.getLogger(getClass());


    public ActualCursPrivateDto[] getAllActualCurrency(){
        final String coursid = "coursid=5";
        ActualCursPrivateDto[] responsAsDto =
                given()
                        .contentType(ContentType.JSON)
                        .log().all()
                        .when()
                        .given().queryParam("exchange", coursid)
                        .get(EndPoints.TODAY_EXCHANGE_BASE_URL)
                        .then()
                        .log().all()
                        .extract().body().as(ActualCursPrivateDto[].class);
        logger.info(responsAsDto.toString());
        return responsAsDto;
    }
}

