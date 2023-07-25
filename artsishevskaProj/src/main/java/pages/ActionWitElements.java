package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActionWitElements {
    Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;
    public ActionWitElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);//this - означає, що ініціалізуємо елементи саме в цьому класі.описані за допомогою FindBy
    }


    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputted into input");
        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
    public  void clickOnElement(WebElement element) {
        try {
            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    public boolean isElementDisplayed(WebElement element){
        try{

            boolean state = element.isDisplayed();
            if (state){
                logger.info("Element is displayed");
            }else {
                logger.info("Element is not displayed");
            }
            return state;
        }catch (Exception e){
            logger.info("Element is not displayed");
            return false;
        }

    }
    public void checkElementDisplayed(WebElement element){
        Assert.assertTrue("Element is not displayed", isElementDisplayed(element));
    }
    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");

    }
    public void checkElementNotDisplayed(WebElement element){
        Assert.assertFalse("Element is displayed", isElementDisplayed(element));
    }
}