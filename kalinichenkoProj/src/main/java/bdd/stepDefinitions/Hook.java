package bdd.stepDefinitions;

import api.ApiHelper;
import bdd.helpers.WebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {
    WebDriverHelper webDriverHelper;
    ApiHelper apiHelper = new ApiHelper();

    public Hook(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
    }

    @Before (order = 0)// cucumber.api.java.Before
    public void setUp(){

    }

    @After(order = 100)
    public void tearDown(){
        webDriverHelper.quitDriver();
    }

    @Before(value = "@deleteAllPostsForDefaultApiUser", order = 50)
    @After(value = "@deleteAllPostsForDefaultApiUser", order = 50)
    public void deleteAllPostsForDefaultApiUser() {
        apiHelper.deletePostTillPresent();
    }
}
