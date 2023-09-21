package bdd.stepDefinitions;

import bdd.helper.WebDriverHelper;
import pages.PageProvider;

public class MainSteps { // class for Cucumber Steps
    protected WebDriverHelper webDriverHelper;
    protected PageProvider pageProvider;

    public MainSteps(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
        pageProvider = new PageProvider(webDriverHelper.getWebDriver());

    }
}
