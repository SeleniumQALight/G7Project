package bdd.stepDefinitions;

import api.ApiHelperPB;
import bdd.helpers.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import libs.Util;
import org.assertj.core.api.SoftAssertions;
//import org.apache.log4j.Logger;

public class PBsteps extends MainSteps {
    private org.openqa.selenium.WebDriver WebDriver;
    //   private api.ApiHelper ApiHelper;

    public PBsteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I open page PB")
    public void iOpenPagePB() {
        pageProvider.getPBpage().openPBpage();
        Util.waitABit(1);
        pageProvider.getPBpage().checkIsTitleExchangeRatesVisible();
        Util.waitABit(1);
    }


    @When("I getting a course {string} the site")
    public void iGettingACourseTheSite(String currency) {
        pageProvider.getPBpage().getExchangeRateBuyOnTheWeb1(currency);
        pageProvider.getPBpage().getExchangeRateSaleOnTheWeb(currency);
    }

    @And("I getting a course {string} via API")
    public void iGettingACourseViaAPI(String currency) {
        ApiHelperPB.getCurseViaApi(currency);

    }

    @Then("I compare course {string} via API and site")
    public void i_compare_course_via_api_and_site(String currency) {
        //з стрінги в дабл
     double exchangeRateBuyDouble = Double.parseDouble(TestData.exchangeRateBuy);
     double exchangeRateSaleDouble = Double.parseDouble(TestData.exchangeRateSale);
     double cursViaApiSaleDouble = Double.parseDouble(TestData.cursViaApiSale);
     double cursViaApiBuiDouble = Double.parseDouble(TestData.cursViaApiBui);

        SoftAssertions softAssertions = new SoftAssertions();


        softAssertions.assertThat(exchangeRateBuyDouble)
                .as("Курс продажу валюти " + currency + " на сайті і отриманого через API не співпадають")
                .isEqualTo(cursViaApiBuiDouble);

        // Порівнюємо курс купівлі
        softAssertions.assertThat(exchangeRateSaleDouble)
                .as("Курс купівлі валюти " + currency + " на сайті і отриманого через API не співпадають")
                .isEqualTo(cursViaApiSaleDouble);

        softAssertions.assertAll();
    }


        // Порівнюємо курс продажу

//        if (exchangeRateBuyDouble != cursViaApiBuiDouble) {
//            System.out.println("     Курси продажу валюти " + currency + " на сайті і отриманного через АРІ  НЕ співпадають");
//            softAssertions.assertThat(exchangeRateBuyDouble)
//                    .isEqualTo(cursViaApiBuiDouble);
//        } else {
//            System.out.println("     Курс продажу валюти " + currency + " на сайті і отриманного через АРІ співпадають");
//        }
//
//        // Порівнюємо курс купівлі
//        if (exchangeRateSaleDouble != cursViaApiSaleDouble) {
//            System.out.println("     Курс купівлі валюти " + currency + " на сайті і отриманного через АРІ  НЕ співпадає.");
//            softAssertions.assertThat(exchangeRateSaleDouble)
//                    .isEqualTo(cursViaApiSaleDouble);
//        } else {
//            System.out.println("     Курс купівлі валюти " + currency + " на сайті і отриманного через АРІ співпадають");
//        }
//
//        softAssertions.assertAll();
//    }


    }

