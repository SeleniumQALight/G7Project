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

    protected Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait10, webDriverWait15;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); // this - means all elements from this class will be initialized elements in FindBy
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
            logger.info(elementName + "Element was clicked" );
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
                logger.info(getElementName(element) + "Element is displayed");
            } else {
                logger.info(getElementName(element) + "Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info(getElementName(element) + " Element is not displayed");
            return false;
        }
    }

    public void checkElementDisplay(WebElement element) {
        Assert.assertTrue(getElementName(element) + "Element is not displayed ", isElementDisplayed(element));
    }

    public void selectTextInDropDown(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectValueInDropDown(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void checkElementNotDisplay(WebElement element) {
        Assert.assertFalse(getElementName(element) + "Element is displayed ", isElementDisplayed(element));
    }

    public void selectTextInDropDownByUI(WebElement dropDown, String text) {
        try {
            clickOnElement(dropDown);
            clickOnElement(dropDown.findElement(org.openqa.selenium.By.xpath(".//option[text()=" + text + ']')));
            logger.info(text + " was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean setCheckboxState(WebElement element) {
        try {
            if (!element.isSelected()) {
                element.click();
                logger.info(getElementName(element) +"Checkbox state was changed to set");
                return true;
            } else {
                logger.info(getElementName(element) + "Checkbox state was not changed it is already set");
                return false;
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
            return false;
        }
    }

    public boolean unsetCheckboxState(WebElement element) {
        try {
            if (element.isSelected()) {
                element.click();
                logger.info(getElementName(element) + "Checkbox state was changed to unset");
                return true;
            } else {
                logger.info(getElementName(element) + "Checkbox state was not changed it is already unset");
                return false;
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
            return false;
        }
    }


    public void clickOnLocatorText(String title) {
        String locator = "//*[text()='%s']";
        clickOnElement(String.format(locator, title));
    }

    private String getElementName (WebElement element) {
        try {
            return element.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }

}
