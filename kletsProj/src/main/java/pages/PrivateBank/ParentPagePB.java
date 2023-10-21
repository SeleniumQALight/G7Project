package pages.PrivateBank;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ActionsWithElements;

public class ParentPagePB extends ActionsWithElements {
    Logger logger = Logger.getLogger(getClass());

    final String MAIN_URL = "https://privatbank.ua";

    public ParentPagePB(WebDriver webDriver) {
        super(webDriver);
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
}
