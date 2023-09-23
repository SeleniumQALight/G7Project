package bdd.stepDefinitions;

import api.ApiHelper;
import bdd.helper.WebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hook { // class for Cucumber Hooks
    WebDriverHelper webDriverHelper;
    ApiHelper apiHelper = new ApiHelper();

    public Hook(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
    }

    @Before(order = 0)
    public void setUp() {
        webDriverHelper.getWebDriver().manage().window().maximize();
    }

    @After(order = 100)
    public void tearDown() {
        webDriverHelper.quitDriver();
    }

    @Before(value = "@deleteAllPostsForDefaultUser", order = 50)
    @After(value = "@deleteAllPostsForDefaultUser", order = 50)
    public void deleteAllPostsForDefaultUser() {
        apiHelper.deletePostsTillPresent();
    }
}