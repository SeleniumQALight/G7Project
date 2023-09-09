package bdd.cucumber.stepDefinitions;

import bdd.cucumber.WebDriverHelper;
import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;

public class Hook {
    WebDriverHelper webDriverHelper;

    public Hook(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
    }

    @Before(order = 0)
    @Step("Browser started")
    public void setUp(){
//        this.webDriverHelper = webDriverHelper;
//        webDriverHelper = new WebDriverHelper();
        System.out.println("Browser started");
    }


    @Before(value = "@secondAfter", order = 100)
    @After(value = "@secondAfter", order = 50)
    @Step("second after")
    public void tearDown1(){

        System.out.println("second after");
    }

    @After(order = 0)
    @Step("Browser closed")
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            screenshot();
            try {
                // scenario.write("Current Page URL is " + WebDriverHelper.getWebDriver().getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) webDriverHelper.getWebDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,"image/png", "Screen after test " + scenario.getName());  // Stick it in the report
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.out.println(somePlatformsDontSupportScreenshots.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
        webDriverHelper.closeDriver();
        System.out.println("browser closed");
    }


    @Attachment(type = "image/png")
    public byte[] screenshot()/* throws IOException */ {
        try {
            File screen = ((TakesScreenshot) webDriverHelper.getWebDriver()).getScreenshotAs(OutputType.FILE);
            return Files.toByteArray(screen);
        } catch (IOException e) {
            return null;
        }
    }


}
