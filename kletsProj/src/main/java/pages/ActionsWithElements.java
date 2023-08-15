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
        PageFactory.initElements(webDriver, this); // this - means all elements from this class will be initialized
        // element in Find by
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
    }

    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();// clear field
            input.sendKeys(text);//vvod s klaviaturi
            logger.info(text + " was inputted into " + getElementName(input));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            String elementName = getElementName(element);
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info (elementName +" Element was clicked");
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

    public void checkIsElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(element));
    }

    public void checkIsElementNotDisplayed(WebElement element) {
        logger.info("Checking if element is not displayed");
        Assert.assertFalse("Element is displayed", isElementDisplayed(element));
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


    protected void selectTextDropDownByUI(WebElement dropDown, String option) {
        try {
            clickOnElement(dropDown);
            clickOnElement(dropDown.findElement(org.openqa.selenium.By.xpath(".//option[text()='" + option + "']")));
            logger.info("Text was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    protected void selectCheckbox(WebElement checkBox) {
        if (checkBox.isSelected()) {
            logger.info("Checkbox is already selected");
        } else {
            checkBox.click();
            logger.info("Checkbox was selected");
        }
    }

    protected void deselectCheckbox(WebElement checkBox) {
        if (checkBox.isSelected()) {
            checkBox.click();
            logger.info("Checkbox was deselected");
        } else {
            logger.info("Checkbox is already deselected");
        }
    }

    public void markCheckBoxYes(WebElement checkBoxUniquePost) {
        try {
            if (!checkBoxUniquePost.isSelected()) {
                checkBoxUniquePost.click();
                logger.info("Checkbox was marked as Yes");
            } else {
                logger.info("Checkbox is already marked as Yes");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    public void markCheckBoxNo(WebElement checkBoxUniquePost) {
        try {
            if (checkBoxUniquePost.isSelected()) {
                checkBoxUniquePost.click();
                logger.info("Checkbox was marked as No");
            } else {
                logger.info("Checkbox is already marked as No");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }

    //check if status of the checkbox is displayed according to the state
    //@param state - expected state (check/uncheck)
    //@param checkBox - checkbox to check

    public void checkCheckBoxState(WebElement checkbox, String state) {
        try {
            if (state.equalsIgnoreCase("check")) {
                markCheckBoxYes(checkbox);
            } else if (state.equalsIgnoreCase("uncheck")) {
                markCheckBoxNo(checkbox);
            } else {
                logger.error("State should be check/uncheck");
                Assert.fail("State should be check/uncheck");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private String getElementName(WebElement element) {
        try {
            return element.getAccessibleName();
        } catch (Exception e) {
            return "";
        }
    }

    void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);//zupinit test
    }

}
