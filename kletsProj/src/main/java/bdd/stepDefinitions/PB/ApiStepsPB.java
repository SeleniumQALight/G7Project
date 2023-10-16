package bdd.stepDefinitions.PB;

import data.TestData;
import io.cucumber.java.en.Given;
import privateBankApi.dto.responseDto.ApiHelperPrivateBank;
import privateBankApi.dto.responseDto.PubInfoDto;

import java.text.DecimalFormat;
import java.util.logging.Logger;

public class ApiStepsPB {

    Logger logger = Logger.getLogger(getClass().getName());
    ApiHelperPrivateBank apiHelperPrivateBank = new ApiHelperPrivateBank();

    @Given("I remember the exchange rate for buy and sell for {string} from the API response")
    public void i_remember_the_exchange_rate_for_buy_and_sell_for_from_the_api_response(String expectedCurrency) {
        PubInfoDto[] rateFromApi = apiHelperPrivateBank.getAllInfo();
        for (PubInfoDto pubInfoDto : rateFromApi) {
            if (pubInfoDto.getCcy().equals(expectedCurrency)) {
                TestData.rate_buy_api = pubInfoDto.getBuy();
                TestData.rate_sell_api = pubInfoDto.getSale();

                DecimalFormat decimalFormat = ApiHelperPrivateBank.getDecimalFormat();
                TestData.rate_buy_api = decimalFormat.format(Double.parseDouble(TestData.rate_buy_api));
                TestData.rate_sell_api = decimalFormat.format(Double.parseDouble(TestData.rate_sell_api));

                logger.info("Rate from API: " + " " + TestData.rate_buy_api + " " + TestData.rate_sell_api);

            }

        }
    }

}
