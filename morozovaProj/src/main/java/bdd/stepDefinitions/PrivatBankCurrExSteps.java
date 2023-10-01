package bdd.stepDefinitions;

import api.ApiHelperPrivatBankE;
import data.TestData;
import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PrivatBankCurrExSteps extends MainSteps {
    WebDriver webDriver;

    public PrivatBankCurrExSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I save currency {} rates with UI")
    public void iSaveCurrencyRatesWithUI(String currency) {
        pageProvider.getPrivatBankPage().openPrivatBankPageUI();
        pageProvider.getPrivatBankPage().saveCurrencyRatesWithUI(currency);
    }

    @Then("I get currency {} with API PB")
    public void iGetCurrencyWithAPIPB(String currency) {
        ApiHelperPrivatBankE apiHelperPrivatBankE = new ApiHelperPrivatBankE();
        apiHelperPrivatBankE.getCurrencyWithAPIPB(currency);

    }

    @When("I save currency rates with UI")
    public void iSaveCurrencyRatesWithUI() {
        pageProvider.getPrivatBankPage().openPrivatBankPageUI();

        List<String> currList = new ArrayList<>();

        WebElement element = webDriver.findElement(By.xpath("//*[@id='EUR_buy']"));
        // Получите текст из элемента
        String curr = element.getText();
        System.out.println("EUR_buy = " + curr);
        currList.add(curr);

        element = webDriver.findElement(By.xpath("//*[@id='EUR_sell']"));
        System.out.println("Username was inputted");
        // Получите текст из элемента
        curr = element.getText();
        System.out.println("EUR_sell = " + curr);
        currList.add(curr);

        element = webDriver.findElement(By.xpath("//*[@id='USD_buy']"));
        System.out.println("Username was inputted");
        // Получите текст из элемента
        curr = element.getText();
        System.out.println("USD_buy = " + curr);
        currList.add(curr);
    }

    @Then("I compare {} UI and API")
    public void iCompareUIAndAPI(String currency) {
        System.out.println("Порівнюємо курси для " + currency);

        // Преобразование строки в число с плавающей точкой
        double parsedDouble_buy_api = Double.parseDouble(TestData.curs_buy_api);
        double parsedDouble_sale_api = Double.parseDouble(TestData.curs_sale_api);

        double parsedDouble_buy_ui = Double.parseDouble(TestData.curs_buy_ui);
        double parsedDouble_sale_ui = Double.parseDouble(TestData.curs_sale_ui);

        // Порівняння чисел з плаваючою крапкою
        int comparisonResult_buy = Double.compare(parsedDouble_buy_api, parsedDouble_buy_ui);

        if (comparisonResult_buy == 0) {
            System.out.println("Курс купівлі однаковий.");
        } else {
            System.out.println("Курс купівлі не однаковий");
        }
        int comparisonResult_sale = Double.compare(parsedDouble_sale_api, parsedDouble_sale_ui);
        if (comparisonResult_sale == 0) {
            System.out.println("Курс продажу однаковий.");
        } else {
            System.out.println("Курс продажу не однаковий");
        }
    }
}