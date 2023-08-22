package pages;


import libs.ConfigProvider;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends ActionsWithElements {
    String env = System.getProperty("env", "aqa");

     String baseUrl ;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        baseUrl = ConfigProvider.configProperties.base_url().replace("[env]", env);
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

    //check url
    // https://aqa-complexapp.onrender.com/ == BASE_URL+ "/"-> true
    protected void checkCurrentUrl(String relativeUrl) {
        Assert.assertEquals("Url is not expected", baseUrl + relativeUrl, webDriver.getCurrentUrl());
    }

    protected void checkUrl() {
        checkCurrentUrl(getRelativeUrl());
    }

    ////https://aqa-complexapp.onrender.com/post/64d21e84903640003414c338
    //regex for 64d21e84903640003414c338
    //[a-zA-Z0-9]{24}
    ////https://aqa-complexapp.onrender.com/post/[a-zA-Z0-9]{24}
    protected void checkUrlWithPattern(String relativeUrl) {
        Assert.assertTrue("Url is not expected \n"
                        + "Expected result: " + baseUrl + relativeUrl + "\n"
                        + "Actual result: " + webDriver.getCurrentUrl()
                , webDriver.getCurrentUrl().matches(baseUrl + relativeUrl));
    }

     protected void checkUrlWithPattern() {
        checkUrlWithPattern(getRelativeUrl());
    }
}
