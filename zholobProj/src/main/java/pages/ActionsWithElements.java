package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActionsWithElements {

    Logger logger = Logger.getLogger(getClass()); //

    protected WebDriver webDriver;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); //initialization of elements
// element in @FindBy
    }

    /**
     * @param url
     */


    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }

    public void clickOnElement(WebElement element) { //method for clicking on element
        try {
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void enterTextIntoInput(WebElement element, String text) { //method for inputting text
        try {
            element.clear();
            element.sendKeys(text);
           logger.info(text + " was inputted into element");
        } catch (Exception e) {


            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {

            boolean state = element.isDisplayed();
            if (state) {
                logger.info("Element is displaed");
            } else {
                logger.info("Element is not displaed");

            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not displaed");
            return false;
        }

    }

    public void checkElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is not displaed", isElementDisplayed(element));
    }
}




