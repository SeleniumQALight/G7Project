package bdd.stepDefinitions;

import api.ApiHelper;
import bdd.helpers.WebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook { // вцьому класі зберігається все, що відбуватиметься до та після тесту. Cucumber іде в цей клас автоматично
    WebDriverHelper webDriverHelper;
    ApiHelper apiHelper = new ApiHelper();

    public Hook(WebDriverHelper webDriverHelper) { //механізм, який запустить браузер
        this.webDriverHelper = webDriverHelper;
    }

    @Before(order = 0)
    public void setUp(){
    }

    @After(order = 100) // спочатку запускається той order, де менше число
    public void tearDown(){
        webDriverHelper.quitWebDriver();
    }

    @Before(value = "@deleteAllPostsForDefaultUser", order = 50) // цей метод буде виконуватися тільки для сценаріїв з тегом @deleteAllPostsForDefaultUser
    @After(value = "@deleteAllPostsForDefaultUser", order = 50) // цей метод буде виконуватися тільки для сценаріїв з тегом @deleteAllPostsForDefaultUser
    public void deleteAllPostsForDefaultUser() {
        apiHelper.deletePostsTillPresent();
    }
}
