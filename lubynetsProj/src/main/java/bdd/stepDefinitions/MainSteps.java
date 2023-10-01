package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import pages.PageProvider;
import pages.PrivatBankCurrencyPage;

public class MainSteps {

    protected WebDriverHelper webDriverHelper;
    protected PageProvider pageProvider;
    protected PrivatBankCurrencyPage currencyPage;

    public MainSteps(WebDriverHelper webDriverHelper) {
        this.webDriverHelper = webDriverHelper;
        pageProvider = new PageProvider(webDriverHelper.getWebDriver());
        currencyPage = new PrivatBankCurrencyPage(webDriverHelper.getWebDriver());
    }
}