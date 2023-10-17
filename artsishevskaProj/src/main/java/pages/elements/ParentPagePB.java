package pages.elements;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ActionWitElements;



abstract public class ParentPagePB extends ActionWitElements {
    Logger logger = Logger.getLogger(getClass());
    String BASE_URL_EXAM_PB = "https://privatbank.ua";
    public ParentPagePB(WebDriver webDriver) {
        super(webDriver);
    }
    public void openPage(String url){
        try{
            webDriver.get(url);
            logger.info("Page was opened " + url);
        }catch (Exception e){
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }
    abstract protected String getRelativeUrl();
    protected void checkUrlWithPattern(String relativeUrl){
        Assert.assertTrue("Url is not expected \n" + "Expected result:" + BASE_URL_EXAM_PB + relativeUrl + "\n" +
                "Actual result:" + webDriver.getCurrentUrl(),webDriver.getCurrentUrl().matches(BASE_URL_EXAM_PB + relativeUrl ));
    }
    protected  void checkUrlWithPattern(){
        checkUrlWithPattern(getRelativeUrl());
    }
}
