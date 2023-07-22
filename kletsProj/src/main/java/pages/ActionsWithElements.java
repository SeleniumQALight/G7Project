package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActionsWithElements {

    Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); // this - means all elements from this class will be initialized
        // element in Find by
    }

    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();// clear field
            input.sendKeys(text);//vvod s klaviaturi
            logger.info(text + " was inputted");
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

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);//zupinit test
    }


    public void checkTextInElement(WebElement element, String text) {
        try {
            String elementText = element.getText();
            if (elementText.equals(text)) {
                logger.info("Text in element is correct");
            } else {
                logger.error("Text in element is not correct");
                Assert.fail("Text in element is not correct");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

}
