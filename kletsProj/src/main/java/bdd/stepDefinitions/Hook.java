package bdd.stepDefinitions;

import bdd.helper.WebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hook { // class for Cucumber Hooks
    WebDriverHelper webDriverHelper;

    public Hook(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
    }

    @Before
    public void setUp() {
        webDriverHelper.getWebDriver().manage().window().maximize();
    }

    @After
    public void tearDown() {
        webDriverHelper.quitDriver();
    }
}