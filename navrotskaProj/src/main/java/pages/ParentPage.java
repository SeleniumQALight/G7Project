package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract class ParentPage extends ActionsWithElements {
    final String BASE_URL = "https://aqa-complexapp.onrender.com";

     ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened with URL: " + url);
        } catch (Exception e) {
            logger.error("Can not open " + url); // print message in report
            Assert.fail("Can not open " + url); // stop test and type in console that test was failed
        }
    }

    abstract protected String getRelativeUrl();


    //check url
    // https://aqa-complexapp.onrender.com/ == BASE_URL + "/" => true
    protected void checkUrl(String relativeUrl) {
        Assert.assertEquals("Url is not expected", BASE_URL + relativeUrl, webDriver.getCurrentUrl());
    }

    protected void checkUrl() {
        checkUrl(getRelativeUrl());
    }

    //https://aqa-complexapp.onrender.com/post/64d21e84903640003414c338
    // regex for 64d21e84903640003414c338
    // [a-zA-Z0-9]{24}
    //https://aqa-complexapp.onrender.com/post/[a-zA-Z0-9]
    protected void checkUrlWithPattern(String relativeUrl) {
        Assert.assertTrue("Url is not expected \n"
                        + "Expected result: " + BASE_URL + relativeUrl + "\n"
                        + "Actual result: " + webDriver.getCurrentUrl(),
                webDriver.getCurrentUrl().matches(BASE_URL + relativeUrl));
    }

    protected void checkUrlWithPattern(){
        checkUrlWithPattern(getRelativeUrl());
    }
}