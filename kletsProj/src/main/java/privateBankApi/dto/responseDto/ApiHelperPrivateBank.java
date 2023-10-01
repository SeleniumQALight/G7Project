package privateBankApi.dto.responseDto;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.SoftAssertions;
import privateBankApi.PrivateBankEndPoints;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiHelperPrivateBank {
    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public PubInfoAllCurrencyDto[] getAllInfo() {
        SoftAssertions softAssertions = new SoftAssertions();

       PubInfoAllCurrencyDto[] responseDto =

                given()
                        .spec(requestSpecification)
                        .when()
                        .get(PrivateBankEndPoints.PUBINFO)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response()
                        .getBody().as(PubInfoAllCurrencyDto[].class);

        List<PubInfoDto> pubInfoDtoList = new ArrayList<>();

        for (PubInfoDto pubInfoDto : pubInfoDtoList) {
            softAssertions.assertThat(pubInfoDto.getCcy()).isNotEmpty();
            softAssertions.assertThat(pubInfoDto.getBase_ccy()).isNotEmpty();
            softAssertions.assertThat(pubInfoDto.getBuy()).isNotEmpty();
            softAssertions.assertThat(pubInfoDto.getSale()).isNotEmpty();
        }
        softAssertions.assertAll();
        return responseDto;

    }

}
