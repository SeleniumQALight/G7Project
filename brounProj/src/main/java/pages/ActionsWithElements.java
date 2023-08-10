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

    Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait10, webDriverWait15;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); // this means that all elements will be initialized in this class by FindBy annotation

        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
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
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));
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
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }

    public void checkElementNotDisplayed(WebElement element) {
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


    public void selectTextInDropDownByUI(WebElement dropDown, WebElement optionToSelect) {
        try {

            clickOnElement(dropDown);
            clickOnElement(optionToSelect);

            logger.info(optionToSelect.getText() + " was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    public void setCheckboxActive(WebElement checkbox) {

        if (!checkbox.isSelected()) {
            clickOnElement(checkbox);
            logger.info("Checkbox is checked");
        } else {
            logger.info("Checkbox is already checked");
        }

    }


    public void setCheckboxInactive(WebElement checkbox) {

        if (checkbox.isSelected()) {
            clickOnElement(checkbox);
            logger.info("Checkbox is unchecked");
        } else {
            logger.info("Checkbox is already unchecked");
        }
    }


    public void selectValueInCheckbox(WebElement checkbox, String value) {

        if (value.equalsIgnoreCase("Check")) {
            setCheckboxActive(checkbox);

        } else if (value.equalsIgnoreCase("Uncheck")) {
            setCheckboxInactive(checkbox);
        } else {
            logger.error("Value should be 'Check' or 'Uncheck'");
            Assert.fail("Value should be 'Check' or 'Uncheck'");
        }

    }

}