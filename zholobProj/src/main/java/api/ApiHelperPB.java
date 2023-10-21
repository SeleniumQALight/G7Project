package api;

import api.dto.responsDto.ResponsDtoPB;
import data.TestData;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;

import static io.restassured.RestAssured.given;

public class ApiHelperPB {
    Logger logger = Logger.getLogger(getClass());

    //метод отримання курсів валют з API PB для порівняння
    public static ResponsDtoPB[] getCurseViaApi(String currency) {
        Logger loger = Logger.getLogger(ApiHelperPB.class);
        ResponsDtoPB[] responsDtoPB = given()
                .contentType(ContentType.JSON)
                .queryParam("json")
                .queryParam("exchange")
                .queryParam("coursid", 5)
                .when()
                .get(EndPoints.URL_PB)
                .then()
                .statusCode(200)
                .extract().as(ResponsDtoPB[].class);
        for (int i = 0; i < responsDtoPB.length; i++) {
            if (responsDtoPB[i].getCcy().equalsIgnoreCase(currency)) { //перевірка чи валюта відповідає валюті з параметра
                TestData.cursViaApiBui = responsDtoPB[i].getBuy(); //записуємо в статичну змінну курс купівлі
                TestData.cursViaApiSale = responsDtoPB[i].getSale(); //з

                loger.info("currency buying rate (API) for " + currency + " is: " + TestData.cursViaApiBui);
                loger.info("currency selling rate (API) for " + currency + " is: " + TestData.cursViaApiSale);
            }
        }
        return responsDtoPB;

    }

}

