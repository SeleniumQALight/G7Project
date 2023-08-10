package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

 abstract public class ParentPage extends ActionsWithElements {
    String env = System.getProperty("env", "aqa");
     final String BASE_URL = String.format("https://%s-complexapp.onrender.com", env);

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("The site was opened " + url);
        } catch (Exception e) {
            logger.error("Can't open " + url);
            Assert.fail("Can't open " + url);
        }
    }

    abstract protected String getRelativeUrl();

    //check URL
    // https://aqa-complexapp.onrender.com/ == BASE_URL + "/" -> true
    protected void checkUrl(String relativeUrl) {
        Assert.assertEquals("Url is not expected", BASE_URL + relativeUrl, webDriver.getCurrentUrl());
    }

     protected void checkUrl() {
         checkUrl(getRelativeUrl());
     }

    //https://aqa-complexapp.onrender.com/post/64d21e84903640003414c338
    // regex for 64d21e84903640003414c338
    // [a-zA-Z0-9]{24}
    ////https://aqa-complexapp.onrender.com/post/[a-zA-Z0-9] регулярний вираз або паттерн для порівняння

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
