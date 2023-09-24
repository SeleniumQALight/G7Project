package bdd.stepDefinitions;

import api.ApiHelper;
import bdd.helpers.WebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hook {

    WebDriverHelper webDriverHelper ;
    ApiHelper apiHelper = new ApiHelper();

    public Hook(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
    }
    @Before(order = 0)
    public void setUp() {

    }

    @After(order = 100)
    public void tearDown() {
        webDriverHelper.quitWebDriver();
    }

    @Before(value = "@DeleteAllPostsForDefaultUser", order = 50)
    @After(value = "@DeleteAllPostsForDefaultUser", order = 50)

    public void deleteAllPostsForDefaultUser() {
        apiHelper.deletePostTillPresent();
        // TODO implement
    }
}
