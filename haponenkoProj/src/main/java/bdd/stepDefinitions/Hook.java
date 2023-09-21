package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook { // вцьому класі зберігається все, що відбуватиметься до та після тесту. Cucumber іде в цей клас автоматично
    WebDriverHelper webDriverHelper;

    public Hook(WebDriverHelper webDriverHelper) { //механізм, який запустить браузер
        this.webDriverHelper = webDriverHelper;
    }

    @Before
    public void setUp(){
    }

    @After
    public void tearDown(){
        webDriverHelper.quitWebDriver();
    }
}
