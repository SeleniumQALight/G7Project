package bdd.stepDefinitions;

import api.ApiHelper;
import bdd.helpers.WebDriverHelper;
import data.TestData;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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


    @io.cucumber.java.en.When("I getting a course {string} the site")
    public void iGettingACourseTheSite(String currency) {
        pageProvider.getPBpage().getExchangeRateBuyOnTheWeb1(currency);
        pageProvider.getPBpage().getExchangeRateSaleOnTheWeb(currency);
    }

    @And("I getting a course {string} via API")
    public void iGettingACourseViaAPI(String currency) {
        ApiHelper.getCurseViaApi(currency);

    }

    @Then("I compare course {string} via API and site")
    public void i_compare_course_via_api_and_site(String currency) {
        SoftAssertions softAssertions = new SoftAssertions();

        // Порівнюємо курс продажу
        if (!TestData.exchangeRateBuy.equals(TestData.cursViaApiBui)) {
            System.out.println("     Курси продажу валюти " + currency + " на сайті і отриманного через АРІ  НЕ співпадають");
            softAssertions.assertThat(TestData.exchangeRateBuy)
                    .isEqualTo(TestData.cursViaApiBui);
        } else {
            System.out.println("     Курс продажу валюти " + currency + " на сайті і отриманного через АРІ співпадають");
        }

        // Порівнюємо курс купівлі
        if (!TestData.exchangeRateSale.equals(TestData.cursViaApiSale)) {
            System.out.println("     Курс купівлі валюти " + currency + " на сайті і отриманного через АРІ  НЕ співпадає.");
            softAssertions.assertThat(TestData.exchangeRateSale)
                    .isEqualTo(TestData.cursViaApiSale);
        } else {
            System.out.println("     Курс купівлі валюти " + currency + " на сайті і отриманного через АРІ співпадають");
        }

        softAssertions.assertAll();
    }


}

