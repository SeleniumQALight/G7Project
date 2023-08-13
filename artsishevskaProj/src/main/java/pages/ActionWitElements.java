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

public class ActionWitElements {
    Logger logger = Logger.getLogger(getClass());
    protected WebDriver webDriver;
    protected WebDriverWait webDriverWait10, webDriverWait15;
    public ActionWitElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);//this - означає, що ініціалізуємо елементи саме в цьому класі.описані за допомогою FindBy
    webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
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
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));

            element.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    public void clickOnElement(String locator){
        try{
            clickOnElement(webDriver.findElement(By.xpath(locator)));
        }catch (Exception e){
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
    public void selectTextInDropDown(WebElement dropDown, String text){
        try{
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in DropDown");
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    public void selectValueInDropDown(WebElement dropDown, String value){
        try{
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in DropDown");
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");

    }
    public void checkElementNotDisplayed(WebElement element){
        Assert.assertFalse("Element is displayed", isElementDisplayed(element));
    }
    public void selectTextInDropDownByUI(WebElement dropDown, String text){
        try{
            clickOnElement(dropDown);
            clickOnElement(dropDown.findElement(By.xpath(".//option[text()='" + text + "']")));
            logger.info(text + " was selected in DropDown");
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    public void setCheckBoxTrue(WebElement checkBox){
        try{
            if(!checkBox.isSelected()) {
                checkBox.click();
                logger.info("CheckBox was clicked");
            }else{
                logger.info("CheckBox is already selected");
            }

        }catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    public void setCheckBoxFalse(WebElement checkBox){
        try{
            if(checkBox.isSelected()) {
                checkBox.click();
                logger.info("CheckBox was clicked");
            }else{
                logger.info("CheckBox is already deselected");
            }

        }catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    public void setCheckBox(WebElement checkBox,String text){
        try {
            if (!checkBox.isSelected() && text.equals("check")) {
                setCheckBoxTrue(checkBox);
                logger.info("CheckBox is already selected");
            } else if (checkBox.isSelected() && text.equals("uncheck")) {
                setCheckBoxFalse(checkBox);
                logger.info("CheckBox is already deselected");
            } else {
                logger.info("CheckBox is already in the desired state");
            }
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }

    }
}