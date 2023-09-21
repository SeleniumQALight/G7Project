package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hook {
    WebDriverHelper webDriverHelper;

    public Hook(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
    }
    @Before// імпортуємо з io.cucumber.java
    public void setUp(){

    }
    @After
    public void tearDown(){
        webDriverHelper.quitDriver();
    }

}
