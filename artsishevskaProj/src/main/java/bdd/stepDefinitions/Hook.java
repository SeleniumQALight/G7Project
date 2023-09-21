package bdd.stepDefinitions;

import api.ApiHelper;
import bdd.helpers.WebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hook {
    WebDriverHelper webDriverHelper;
    ApiHelper apiHelper = new ApiHelper();

    public Hook(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
    }
    @Before(order=0)// імпортуємо з io.cucumber.java
    public void setUp(){

    }
    @After(order=100)
    public void tearDown(){
        webDriverHelper.quitDriver();
    }

    @Before(value="@deleteAllPostsForDefaultUser",order=50)
    @After(value="@deleteAllPostsForDefaultUser",order=50)
    public void deleteAllPostsForDefaultUser(){
       apiHelper.deletePostsTillPresent();
    }

}
