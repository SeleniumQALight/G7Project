package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hook {// зберігає та @Before  @After секції
WebDriverHelper webDriverHelper;

    public Hook(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
    }
    @Before //імпорт io.cucumber.java
     public void setUp(){}
    @After
    public void tearDown(){
        webDriverHelper.quitDriver();
    }
}
