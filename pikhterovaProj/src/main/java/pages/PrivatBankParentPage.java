package pages;

import libs.ConfigProvider;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class PrivatBankParentPage extends ActionsWithElements {

    String baseUrl;

    public PrivatBankParentPage(WebDriver webDriver) {

        super(webDriver);

        baseUrl = ConfigProvider.configProperties.PRIVAT_BANK_BASE_URL();

    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Page " + url + " was opened");
        } catch (Exception e) {
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }

    abstract protected String getRelativeUrl();

    protected void checkCurrentUrl(String relativeUrl) {
        Assert.assertEquals("Url is not expected", baseUrl + relativeUrl, webDriver.getCurrentUrl());
    }

    protected void checkUrl() {
        checkCurrentUrl(getRelativeUrl());
    }

}
