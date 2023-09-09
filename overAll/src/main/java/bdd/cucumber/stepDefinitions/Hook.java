package bdd.cucumber.stepDefinitions;

import bdd.cucumber.WebDriverHelper;
import com.google.common.io.Files;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import java.io.File;
import java.io.IOException;

public class Hook {


    @Before
    public void setUp(){
        new WebDriverHelper();
        System.out.println("Browser started");
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()) {
            screenshot();
            try {
                // scenario.write("Current Page URL is " + WebDriverHelper.getWebDriver().getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) WebDriverHelper.getWebDriver()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,"image/png", "Screen after test " + scenario.getName());  // Stick it in the report
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.out.println(somePlatformsDontSupportScreenshots.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
        WebDriverHelper.closeDriver();
        System.out.println("browser closed");
    }


    @Attachment(type = "image/png")
    public static byte[] screenshot()/* throws IOException */ {
        try {
            File screen = ((TakesScreenshot) WebDriverHelper.getWebDriver()).getScreenshotAs(OutputType.FILE);
            return Files.toByteArray(screen);
        } catch (IOException e) {
            return null;
        }
    }


}
