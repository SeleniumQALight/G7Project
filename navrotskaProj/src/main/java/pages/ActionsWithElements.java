package pages;

import libs.ConfigProvider;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionsWithElements {

    Logger logger = Logger.getLogger(getClass()); // create logger object
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait10, webDriverWait15;


    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver; // initialize webDriver
        PageFactory.initElements(webDriver, this); // initialize all elements from this class will be initialized elements in FindBY
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
    }

    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            logger.info(text + " was inputted into input" + getElementName(input));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info(getElementName(element) + " Element was clicked");
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

    public void selectTextInDropDownByUI(WebElement dropDown, WebElement dropDownOption) {
        try {
            clickOnElement(dropDown);
            logger.info("Element was clicked");
            clickOnElement(dropDownOption);
            logger.info("Dropdown element was clicked");
            checkElementDisplayed(dropDownOption);
            logger.info("Dropdown element is displayed");

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectCheckBox(WebElement checkBox) {
        try {
            if (!checkBox.isSelected()) {
                clickOnElement(checkBox);
                logger.info("Checkbox was just selected.");
            } else {
                logger.info("Checkbox was already selected");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void deselectCheckBox(WebElement checkbox) {
        try {
            if (checkbox.isSelected()) {
                clickOnElement(checkbox);
                logger.info("Checkbox was just deselected ");
            } else {
                logger.info("Checkbox was already deselected");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void setCheckboxState(WebElement checkbox, String checkboxState) {
        boolean isStateCheck = checkboxState.toLowerCase().equals("check");
        boolean isStateUncheck = checkboxState.toLowerCase().equals("uncheck");
        try {
            if (isStateCheck || isStateUncheck) {
                if ((!checkbox.isSelected() && isStateCheck) || (checkbox.isSelected() && isStateCheck)) {
                    selectCheckBox(checkbox);
                } else if ((checkbox.isSelected() && isStateUncheck) || (!checkbox.isSelected() && isStateUncheck)) {
                    deselectCheckBox(checkbox);
                }
            } else {
                logger.error("State should be 'check' or 'uncheck'");
                Assert.fail("State should be 'check' or 'uncheck'");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    private String getElementName(WebElement element){
        try{
           return element.getAccessibleName();
        }catch (Exception e){
            return "";
        }
    }


    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e); // print message in report
        Assert.fail("Can not work with element " + e); // stop test and type in console that test was failed
    }

}