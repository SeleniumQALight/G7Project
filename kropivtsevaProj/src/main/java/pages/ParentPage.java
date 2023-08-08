package pages;

import libs.ConfigProperties;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public abstract class ParentPage extends ActionsWithElements {
    String env = System.getProperty("env", "aqa");
    public static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseUrl;

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        baseUrl = configProperties.base_url().replace("[env]", env);
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            logger.info("Page was opened " + url);//
        } catch (Exception e) {
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);

        }
    }

    abstract protected String getRelativeUrl();


    //check Url
    // https://aqa-complexapp.onrender.com/ == baseUrl + "/" --> true

    public void checkUrl(String relativeUrl) {
        Assert.assertEquals("Url is not expected", baseUrl + relativeUrl, webDriver.getCurrentUrl());
    }

    public void checkUrl() {
        checkUrl(getRelativeUrl());
    }

    //https://aqa-complexapp.onrender.com/post/64c93aa211e802003266e585
    //regex for 64c93aa211e802003266e585
    //[a-z0-9]{24}
    //https://aqa-complexapp.onrender.com/post/[a-zA-Z0-9]{24}
    protected void checkUrlWithPattern(String relativeUrl) {
        Assert.assertTrue("Url is not expected \n" + "Expected result: " + baseUrl + relativeUrl + "\n" + "Actual result: " + webDriver.getCurrentUrl(), webDriver.getCurrentUrl().matches(baseUrl + relativeUrl));
    }

    protected void checkUrlWithPattern() {
        checkUrlWithPattern(getRelativeUrl());
    }
}
