package bdd.stepDefinitions;

import data.TestData;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import privatBankApi.dto.pbResponseDto.ApiHelperPBExam;
import privatBankApi.dto.pbResponseDto.ExchangeRateDtoPBExam;

import java.text.DecimalFormat;

public class ApiStepsPBExam {

    ApiHelperPBExam apiHelperPrivatBank = new ApiHelperPBExam();
    Logger logger = Logger.getLogger(getClass());

    @Given("I save exchange rate for buy and sale for {string} from the PrivatBank API response")
    public void iSaveExchangeRateForBuyAndSaleForFromThePrivatBankApiResponse(String currencyName) {
        ExchangeRateDtoPBExam[] responseExchangeRateDtoExam = apiHelperPrivatBank.getCurrencyRateTestExam();
        for (ExchangeRateDtoPBExam exchangeRateDtoExam : responseExchangeRateDtoExam) {
            if (exchangeRateDtoExam.getCcy().equalsIgnoreCase(currencyName)) {
                TestData.rateBuyAPI = exchangeRateDtoExam.getBuy();
                TestData.rateSaleAPI = exchangeRateDtoExam.getSale();

                DecimalFormat decimalFormat = ApiHelperPBExam.getDecimalFormat();
                TestData.rateBuyAPI = decimalFormat.format(Double.parseDouble(TestData.rateBuyAPI));
                TestData.rateSaleAPI = decimalFormat.format(Double.parseDouble(TestData.rateSaleAPI));

                logger.info("rate Buy from API = " + TestData.rateBuyAPI);
                logger.info("rate Sale from API = " + TestData.rateSaleAPI);
            }
        }
    }
}