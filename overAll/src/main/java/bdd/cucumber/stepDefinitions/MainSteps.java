package bdd.cucumber.stepDefinitions;

import bdd.cucumber.WebDriverHelper;
import pages.PageProvider;

public class MainSteps {
    TestUser testUser;
    WebDriverHelper webDriverHelper;
    PageProvider pageProvider ;


    public MainSteps(TestUser testUser, WebDriverHelper webDriverHelper) {
        this.testUser = testUser;
        this.webDriverHelper = webDriverHelper;
        pageProvider = new PageProvider(webDriverHelper.getWebDriver());
    }

}
