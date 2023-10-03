package bdd.stepDefinitions;

import api.APIHelper;
import bdd.helpers.WebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    WebDriverHelper webDriverHelper;
    APIHelper apiHelper = new APIHelper();

    public Hook(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
    }

    @Before(order = 0)
    public void setUp() {

    }


    @After(order = 100)
    public void tearDown() {
        webDriverHelper.quitDriver();
    }

    @Before(value = "@deleteAllPostsForDefaultUser", order = 50)
    @After(value = "@deleteAllPostsForDefaultUser", order = 50)
    public void deleteAllPostsForDefaultUser(){
        apiHelper.deletePostsTillPresent();
    }

}

