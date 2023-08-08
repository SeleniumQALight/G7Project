package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

abstract public class ParentPage extends ActionsWithElements {
    final String BASE_URL = "https://aqa-complexapp.onrender.com";
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
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

    // check url
    // https://aqa-complexapp.onrender.com/ == BASE_URL + "/" -> true
    protected void checkUrl(String relativeURL){
            Assert.assertEquals("Url is not expected", BASE_URL + relativeURL, webDriver.getCurrentUrl());
    }

    protected void checkUrl(){
        checkUrl(getRelativeUrl());
    }

     //https://aga-complexapp.onrender.com/post/5f9b1d3b9d6b280004a0e8b2
    // regex for 5f9b1d3b9d6b280004a0e8b2
    // [a-zA-Z0-9]{24}
    // https://aga-complexapp.onrender.com/post/[a-zA-Z0-9]

    protected void checkUrlWithPattern(String relativeURL){
        Assert.assertTrue("Url is not expected \n"
                + "Expected result: " + BASE_URL + relativeURL + "\n"
                + "Actual result: " + webDriver.getCurrentUrl()
                ,webDriver.getCurrentUrl().matches(BASE_URL + relativeURL));
    }
    protected void checkUrlWithPattern(){
        checkUrlWithPattern(getRelativeUrl());
    }
}

