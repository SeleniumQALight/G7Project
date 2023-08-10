package pages;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ParentPage extends ActionWithElements {
    private Actions actions;
    final String BASE_URL = "https://aqa-complexapp.onrender.com/";

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
        actions = new Actions(webDriver);
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

    public void pressTabKey(WebElement element) {
        actions.sendKeys(element, Keys.TAB).perform();
    }

    public void pressEnterKey(WebElement element) {
        actions.sendKeys(element, Keys.ENTER).perform();
    }
}
