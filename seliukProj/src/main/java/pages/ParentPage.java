package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends ActionsWithElements {
    final String BASE_URL = "https://aqa-complexapp.onrender.com"; //https://qa-complexapp.onrender.com

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened " + url);
        } catch (Exception e) {
            logger.error("Can not open URL " + url);
            Assert.fail("Can not open URL " + url);
        }
    }

    abstract protected String getRelativeUrl();

    //check URL
    //https://aqa-complexapp.onrender.com/ == BASE_URL + "/" -> true
    protected void checkUrl(String relativeUrl) {
        Assert.assertEquals("Url is not expected", BASE_URL + relativeUrl, webDriver.getCurrentUrl());
    }

    protected void checkUrl() {
        checkUrl(getRelativeUrl());
    }




    //https://aqa-complexapp.onrender.com/post/64dac18b2eafa800337c3b25
    //regex on 64dac18b2eafa800337c3b25
    //[a-z0-9]{24}
    //https://aqa-complexapp.onrender.com/post/[a-z0-9]
    protected void checkUrlWithPattern(String relativeUrl) {
        Assert.assertTrue("Url is not expected \n"
                + "Expected result: " + BASE_URL + relativeUrl + "\n"
                + "Actual result: " + webDriver.getCurrentUrl()
                , webDriver.getCurrentUrl().matches(BASE_URL + relativeUrl));
    }

    protected void checkUrlWithPattern() {
        checkUrlWithPattern(getRelativeUrl());
    }



}