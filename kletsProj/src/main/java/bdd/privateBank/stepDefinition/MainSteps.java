package bdd.privateBank.stepDefinition;

import bdd.helper.WebDriverHelper;
import pages.PageProvider;

public class MainSteps {
    protected WebDriverHelper webDriverHelper;
    protected PageProvider pageProvider;

    public MainSteps(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
        pageProvider = new PageProvider(webDriverHelper.getWebDriver());
    }
}
