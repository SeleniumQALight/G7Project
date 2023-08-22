package pages;

import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsWithElements {
    Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait10, webDriverWait15;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); // this - means all elements from this class will be initialized (elements in @FindBy)
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
    }

    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputted into input " + getElementName(input));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            String elementName = getElementName(element);
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info(elementName + " element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(String locator) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            boolean state = element.isDisplayed();
            if (state) {
                logger.info(getElementName(element) + " element is displayed");
            } else {
                logger.info(getElementName(element) + " element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info(getElementName(element) + " element is not displayed");
            return false;
        }
    }

    public void checkElementIsDisplayed(WebElement element) {
        Assert.assertTrue(getElementName(element) + " element is not displayed", isElementDisplayed(element));
    }

    public void checkElementIsNotDisplayed(WebElement element) {
        Assert.assertFalse(getElementName(element) + " element is displayed", isElementDisplayed(element));
    }

    public void selectTextInDropDown(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in DropDown " + getElementName(dropDown));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectValueInDropDown(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in DropDown" + getElementName(dropDown));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectTextInDropDownByUI(WebElement dropDown, String text) {
        try {
            clickOnElement(dropDown);
            clickOnElement(dropDown.findElement(By.xpath("//select[@id = 'select1']//*[contains(text(),'Загальнодоступне')]")));
            logger.info(text + " was selected in DropDown " + getElementName(dropDown));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void markCheckboxYes(WebElement checkboxUniquePost) {
        try {
            if (!checkboxUniquePost.isSelected()) {
                clickOnElement(checkboxUniquePost);
                logger.info(getElementName(checkboxUniquePost) + " checkbox was marked 'Yes'");
            } else {
                logger.info(getElementName(checkboxUniquePost) + " checkbox is already marked 'Yes'");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void markCheckboxNo(WebElement checkboxUniquePost) {
        try {
            if (checkboxUniquePost.isSelected()) {
                clickOnElement(checkboxUniquePost);
                logger.info("Checkbox was marked 'No'");
            } else {
                logger.info("Checkbox is already marked 'No'");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

//    check checkbox according to state

    /**
     * You shoud use this method if you want to check or uncheck checkbox
     * @param checkbox
     * @param state (only "check" or "uncheck")
     */
    public void checkCheckboxState(WebElement checkbox, String state) {
        try {
            if (state.equalsIgnoreCase("check")) {
                markCheckboxYes(checkbox);
            } else if (state.equalsIgnoreCase("uncheck")) {
                markCheckboxNo(checkbox);
            } else {
                logger.error("State should be 'check' or 'uncheck'");
                Assert.fail("State should be 'check' or 'uncheck'");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private String getElementName (WebElement element) {
        try{
           return element.getAccessibleName();
        }catch (Exception e){
            return "";
        }
    }
    private void printErrorAndStopTest(Exception e) {
        logger.error("Can't work with element " + e);
        Assert.fail("Can't work with element " + e);
    }
}
