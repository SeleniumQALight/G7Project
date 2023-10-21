package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import org.apache.log4j.Logger;
import org.junit.Assert;
import privatbankApi.ApiHelper;
import privatbankApi.responsDto.ActualCursPrivateDto;
import test_data.PrivatTestData;
import java.math.BigDecimal;
import java.math.RoundingMode;




public class PrivateBankApi extends MainSteps {
    public PrivateBankApi(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    Logger logger = Logger.getLogger(getClass());
    ApiHelper apiHelper = new ApiHelper();
    PrivatTestData privatTestData = new PrivatTestData();


    @Given("I get {string} rates via Private Bank API")
    public void iGetCurrencyRatesViaPrivateBankAPI(String currency) {
        ActualCursPrivateDto[] allCurrency = apiHelper.getAllActualCurrency();
        logger.info(currency);
        for (int i = 0; i < allCurrency.length; i++) {
            if (allCurrency[i].getCcy().equals(currency)) {
                Double buy_Api = Double.valueOf(allCurrency[i].getBuy());
                BigDecimal buy = BigDecimal.valueOf(buy_Api);
                Double sale_Api = Double.valueOf(allCurrency[i].getSale());
                BigDecimal sale = BigDecimal.valueOf(sale_Api);
                privatTestData.currencyRates.put(privatTestData.buyApi, buy.setScale(2, RoundingMode.valueOf(5)));
                privatTestData.currencyRates.put(privatTestData.saleApi, sale.setScale(2, RoundingMode.valueOf(5)));
                System.out.println(privatTestData.currencyRates);
            }
        }
        Assert.assertTrue("Currency " + currency + " not found", privatTestData.currencyRates.size() > 0);
        logger.info(privatTestData.currencyRates.get(privatTestData.buyApi));
        logger.info(privatTestData.currencyRates.get(privatTestData.saleApi));
    }
}


