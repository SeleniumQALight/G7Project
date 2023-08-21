package pages;

import libs.ConfigProvider;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class ActionsWithElements {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait_10, webDriverWait_15;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);// this - means all elements from this class will be initialized
        //elements in FindBy
        webDriverWait_10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait_15 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            System.out.println("Page was opened");
        } catch (Exception e) {
            System.out.println("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
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
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(element));
            element.click();
            logger.info(elementName + " Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(String locator){
        try {
            clickOnElement(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void checkElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(element));
    }

    public void checkElementIsNotDisplayed(WebElement element) {
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

    public void selectTextInDropDownByUI(WebElement dropDown, WebElement dropDownValue) {
        try {
            clickOnElement(dropDown);
            if (isElementDisplayed(dropDownValue)) {
                clickOnElement(dropDownValue);
                logger.info("DropDown value with text 'Приватне повідомлення' is clicked");
            } else {
                logger.error("DropDown value with text 'Приватне повідомлення' is not displayed");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void checkCheckbox(WebElement element) {
        try {
            if (!element.isSelected()) {
                clickOnElement(element);
                logger.info("Checkbox was checked");
            } else {
                logger.info("Checkbox has alreaddy been checked");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void uncheckCheckBox(WebElement element) {
        try {
            if (element.isSelected()) {
                clickOnElement(element);
                logger.info("Checkbox was unchecked");
            } else {
                logger.info("Checkbox has alreaddy been unchecked");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void checkOrUncheckCheckBoxDependingOnText(WebElement element, String text) {
        try {
            if (text.equals("check")) {
                if (!element.isSelected()) {
                    clickOnElement(element);
                    logger.info("Checkbox was checked");
                } else {
                    logger.info("Checkbox has alreaddy been checked");
                }
            } else if (text.equals("uncheck")) {
                if (element.isSelected()) {
                    clickOnElement(element);
                    logger.info("Checkbox was unchecked");
                } else {
                    logger.info("Checkbox has alreaddy been unchecked");
                }
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private String getElementName(WebElement element){
        try{
            return element.getAccessibleName();
        } catch (Exception e){
            return "";
        }
    }

    private void printErrorAndStopTest(Exception e) {
        System.out.println("Can not work with element");
        Assert.fail("Can not work with element");
    }
}
