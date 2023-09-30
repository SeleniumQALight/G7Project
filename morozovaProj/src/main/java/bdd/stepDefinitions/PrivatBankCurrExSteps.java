package bdd.stepDefinitions;

import api.EndPoints;
import api.dto.responseDto.PrivatGET;
import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class PrivatBankCurrExSteps extends MainSteps {
    WebDriver webDriver;
    public PrivatBankCurrExSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I get currency with API PB")
    public void iGetCurrencyWithAPIPB() {
        Logger logger = Logger.getLogger(getClass());
            PrivatGET[] response = given()
                    .filter(new AllureRestAssured())//для виводу в звіт
                    .contentType(ContentType.JSON)//додали хедер аплікейшина
                    .log().all()//виводимо в колсоль весь запит
                    .when()// дія
                    .get(EndPoints.PRIVATBANK_URL)
                    .then()
                    .statusCode(200)//перевір, що повернуло потрібний статус
                    .log().all()//виводимо в колсоль весь респонс
                    .extract().as(PrivatGET[].class);
        }

    @Given("I open PrivatBank page")
    public void iOpenPrivatBankPage() {
       // pageProvider.getPrivatBankPage().openPrivatBankPage();
        WebDriverManager.edgedriver().setup();//maven run edqedriver
        webDriver = new EdgeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was opened");
        webDriver.get("https://privatbank.ua/");
        System.out.println("Site was opened");
        }

    @When("I save currency rates")
    public List iSaveCurrencyRates() {
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

        element = webDriver.findElement(By.xpath("//*[@id='USD_sell']"));
        System.out.println("Username was inputted");
        // Получите текст из элемента
        curr = element.getText();
        System.out.println("USD_sell = " + curr);
        currList.add(curr);

        System.out.println("Username was inputted" + currList.toString());
        return currList;
    }

    @Then("I close browser")
    public void iCloseBrowser() {
        webDriver.quit();
        System.out.println("Browser was closed");
    }
}

