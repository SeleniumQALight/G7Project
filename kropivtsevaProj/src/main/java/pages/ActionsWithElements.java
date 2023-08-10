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
        PageFactory.initElements(webDriver, this);//инициализирует все элементы на странице @FindBy в LoginPage и ParentPage (все элементы, которые находятся в ActionsWithElements)
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

    public void checkElementDisplay(WebElement element) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(element));
    }

    public void checkElementNotDisplay(WebElement element) {
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

    public void selectTextInDropDownByUI(WebElement dropDown, String text) {
        try {
            clickOnElement(dropDown);
            clickOnElement(webDriver.findElement(By.xpath(String.format(".//option[text()='%s']", text))));
            logger.info(text + " was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void setCheckStatusToCheckBox(WebElement checkBox) {
        try {
            if (!checkBox.isSelected()) {
                clickOnElement(checkBox);

                logger.info("CheckBox was checked");
            } else {
                logger.info("CheckBox is already checked");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void setUncheckStatusToCheckBox(WebElement checkBox) {
        try {
            if (checkBox.isSelected()) {
                clickOnElement(checkBox);
                logger.info("CheckBox was unchecked");
            } else {
                logger.info("CheckBox is already unchecked");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void checkOrUncheckCheckBoxDependingOnText(WebElement checkBox, String text) {
        try {
            if (text.equalsIgnoreCase("check")) {
                setCheckStatusToCheckBox(checkBox);

            } else if (text.equalsIgnoreCase("uncheck")) {
                setUncheckStatusToCheckBox(checkBox);
            } else {
                logger.error("Text should be 'check' or 'uncheck'");
                Assert.fail("Text should be 'check' or 'uncheck'");
            }

        } catch (
                Exception e) {
            printErrorAndStopTest(e);
        }

    }


    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }
}