package pages;

import api.EndPoints;
import data.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PrivatBankE extends ParentPage {
    public PrivatBankE(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    @Step //хочемо бачити в репорті
    public PrivatBankE openPrivatBankPageUI() {
//         openPage(EndPoints.PRIVATBANK_UIURL+ "/");
//        WebDriverManager.edgedriver().setup();//maven run edqedriver
//        webDriver = new EdgeDriver();
//        webDriver.manage().window().maximize();
        // webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        System.out.println("Browser was opened");
        webDriver.get(EndPoints.PRIVATBANK_UIURL + "/");
        System.out.println("Site was opened " + EndPoints.PRIVATBANK_UIURL + "/");
        checkUrl();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return this;
    }

    protected void checkUrl(String relativeUrl) {
        Assert.assertEquals("Url is not expected", EndPoints.PRIVATBANK_UIURL + relativeUrl, webDriver.getCurrentUrl());// порівнюємо поточний url з тим, який ми передали в параметрі
    }

    public void saveCurrencyRatesWithUI(String currency) {
        String locator_buy = String.format(".//*[@id='%s_buy']", currency);
        String locator_sale = String.format(".//*[@id='%s_sell']", currency);
        System.out.println("Отримуємо курси з UI для "+ currency);

        WebElement element_buy = webDriver.findElement(By.xpath(locator_buy));
        WebElement element_sale = webDriver.findElement(By.xpath(locator_sale));

        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Получите строку из элемента
        TestData.curs_buy_ui = element_buy.getText();
        TestData.curs_sale_ui = element_sale.getText();
        System.out.println("Buy and Sell = " + TestData.curs_buy_ui +" "+ TestData.curs_sale_ui);
    }
}