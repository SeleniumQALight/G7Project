package pages;

import api.EndPoints;
import data.TestData;
import io.qameta.allure.Step;
import libs.Util;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class PrivatBankE extends ParentPage {
    public PrivatBankE(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(id = "EUR_buy")
    private WebElement EUR_buy;

//    @FindBy(id = "EUR_buy")
//    private WebElement EUR_buy;
//
//    @FindBy(id = "EUR_buy")
//    private WebElement EUR_buy;
//
//    @FindBy(id = "EUR_buy")
//    private WebElement EUR_buy;

//
//    @FindBy(id = "email-register")
//    private WebElement inputUserEmailRegistration;
//
//    @FindBy(id = "password-register")
//    private WebElement inputUserPasswordRegistration;
//
//    @FindBy(xpath = ".//input[@placeholder='Username']")
//    private WebElement inputUserName;
//
//    @FindBy(xpath = ".//input[@placeholder='Password']")
//    private WebElement inputPassword;
//
//    @FindBy(xpath = ".//button[text()='Sign In']")
//    private WebElement buttonSignIn;
//
//    @FindBy(xpath = "//div[@class='alert alert-danger text-center' and text() = 'Invalid username / pasword']")
//    private WebElement messageInvalidUsernameAndPassword;
//
//
//    @FindBy(xpath = "//div[@class='alert alert-danger text-center']")
//    private WebElement alertInCenter;
//
//    final String listErrorsMessagesLocator = "//div[@class='alert alert-danger small liveValidateMessage liveValidateMessage--visible']";
//    final String errorMessageLogin = "//div[@class='alert alert-danger text-center']";
//
//    public PrivatBankE(WebDriver webDriver) {
//        super(webDriver);
//    }
//
//    @Override
//    protected String getRelativeUrl() {
//        return "/";
//    }

    @Step //хочемо бачити в репорті
    public void openPrivatBankPage() {
        openPage(EndPoints.PRIVATBANK_URL);
        checkUrl();
    }

    @Override
    protected String getRelativeUrl() {
        return null;
    }
}
