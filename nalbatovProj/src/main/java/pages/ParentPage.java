package pages;

import libs.ConfigProvider;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;

abstract public class ParentPage extends ActionsWithElements {
    String env = System.getProperty("env", "aqa");

    String BASE_URL;
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        BASE_URL = ConfigProvider.configProperties.base_url().replace("[env]", env);
        //BASE_URL = configProperties.base_url().replace("[env]", env);
    }
    public void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened " + url);
        } catch (Exception e) {
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }
    abstract protected String getRelativeUrl();

    //check url
    //https://aqa-complexapp.onrender.com/ == BASE_URL + "/" -> true
    protected void checkUrl(String relativeUrl) {
        Assert.assertEquals("Url is not expected", BASE_URL + relativeUrl, webDriver.getCurrentUrl());
    }

    protected void checkUrl() {
        checkUrl(getRelativeUrl());
    }

    //https://aqa-complexapp.onrender.com/post/5f9d4d3b1d5f1d0017f6b0e2
    // regex for post id 5f9d4d3b1d5f1d0017f6b0e2
    // [a-zA-Z0-9]{24}
    //https://aqa-complexapp.onrender.com/post/[a-zA-Z0-9]{24}

    protected void checkUrlWithPattern(String relativeUrl) {
        Assert.assertTrue("Url is not expected \n" +
                        "Expected result: " + BASE_URL + relativeUrl + "\n" +
                        "Actual result: " + webDriver.getCurrentUrl()
                , webDriver.getCurrentUrl().matches(BASE_URL + relativeUrl));
    }

    protected void checkUrlWithPattern() {
        checkUrlWithPattern(getRelativeUrl());
    }
}

