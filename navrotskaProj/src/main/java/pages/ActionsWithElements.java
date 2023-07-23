package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActionsWithElements {

    Logger logger = Logger.getLogger(getClass()); // create logger object
    protected WebDriver webDriver;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver; // initialize webDriver
        PageFactory.initElements(webDriver, this); // initialize all elements from this class will be initialized elements in FindBY
    }

    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputted into input");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {

            boolean state = element.isDisplayed();
            if (state) {
                logger.info("Element is displayed");
            } else {
                logger.info("Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not displayed");
            return false;
        }
    }

    public void checkElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(element));
    }

    public void checkElementNotDisplayed(WebElement element) {
        Assert.assertFalse("Element is displayed, but shouldn't", isElementDisplayed(element));
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e); // print message in report
        Assert.fail("Can not work with element " + e); // stop test and type in console that test was failed
    }

}