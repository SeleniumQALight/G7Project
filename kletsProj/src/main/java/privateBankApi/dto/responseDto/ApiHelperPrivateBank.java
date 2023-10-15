package privateBankApi.dto.responseDto;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.SoftAssertions;
import privateBankApi.PrivateBankEndPoints;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import static io.restassured.RestAssured.given;

public class ApiHelperPrivateBank {
    RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .log(LogDetail.ALL)
            .build();

    public PubInfoDto[] getAllInfo() {
        SoftAssertions softAssertions = new SoftAssertions();

        PubInfoDto[] responseDto =

                given()
                        .spec(requestSpecification)
                        .queryParam("json", "")
                        .queryParam("exchange", "")
                        .queryParam("coursid", "5")
                        .when()
                        .get(PrivateBankEndPoints.PUBINFO)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response()
                        .getBody().as(PubInfoDto[].class);


        for (PubInfoDto pubInfoDto : responseDto) {
            softAssertions.assertThat(pubInfoDto.getCcy()).isNotEmpty();
            softAssertions.assertThat(pubInfoDto.getBase_ccy()).isNotEmpty();
            softAssertions.assertThat(pubInfoDto.getBuy()).isNotEmpty();
            softAssertions.assertThat(pubInfoDto.getSale()).isNotEmpty();
        }
        softAssertions.assertAll();
        return responseDto;

    }

    public static DecimalFormat getDecimalFormat() { // method for formatting double values
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.US);
        decimalFormatSymbols.setDecimalSeparator('.');
        return new DecimalFormat("#.##", decimalFormatSymbols);
    }


}
