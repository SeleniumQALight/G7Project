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

    public ActionsWithElements(WebDriver webDriver) {//constructor
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); //initialization of elements
        // element in @FindBy
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));

    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }

    public void clickOnElement(WebElement element) { //method for clicking on element
        try {
            webDriverWait10.until(ExpectedConditions.elementToBeClickable(element));//вона перестрибне на інший коли буде клікабельний
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
            logger.info(text + " was inputted");
        } catch (Exception e) {
// System.out.println("Can not work with element" + e);
// Assert.fail("Can not work with element" + e);
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
        Assert.assertTrue("Element is not displaed", isElementDisplayed(element));
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

    //swich to new tab
//    public void switchToNewTab() {
//        try {
//            String winHandleBefore = webDriver.getWindowHandle();
//            for (String winHandle : webDriver.getWindowHandles()) {
//                webDriver.switchTo().window(winHandle);
//            }
//            logger.info("Switch to new tab");
//        } catch (Exception e) {
//            printErrorAndStopTest(e);
//        }
//    }

    public void selectValueInDropDown(WebElement dropDown, String value) {
        try {
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    //HW4 1. метод вибору значення з дропдауну
    public void selectTextInDropDownByUI(WebElement dropDown, String text) {
        try {
            clickOnElement(dropDown);
            clickOnElement(dropDown.findElement(By.xpath("//*[contains(text(),'" + text + "')]")));
            logger.info(text + " was selected in DropDown");
        } catch (Exception e) { // якщо в дропдауні немає вибраного значення
            printErrorAndStopTest(e);
        }
    }
    public void toMarkCheckBox(WebElement element) { //2. метод для вибору чекбокса
        try {
            if (!element.isSelected()) { // якщо чекбокс не вибраний
                element.click(); // вибрати чекбокс
                logger.info("Checkbox was marked 'Yes'");
            } else { logger.info("Checkbox is already marked 'Yes'");}
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
    public void toUnMarkCheckBox(WebElement element) { // 3. метод для зняття чекбокса
        try {
            if (element.isSelected()) { // якщо чекбокс вибраний
                element.click(); // зняти чекбокс
                logger.info("Checkbox was unmarked");
            } else { logger.info("Checkbox is already unmarked");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

     /*
     4. Створити метод встановлення заданого стану у чекбокс
     - метод повинен приймати на вхід стрінговий стан (check or uncheck)
     - в залежності від стану чекбокса і необхідного стану - клікати і виводити повідомлення в лог, чи не клікати і просто виводити повідомлення в лог.
     - додати цей метод в наш тест по створенню поста (зі значенням check) і перевірку на наступному скріні
     */
    public void checkCheckboxState(WebElement checkbox, String state) {
        try {
            if (state.equalsIgnoreCase("check")) {
                toMarkCheckBox(checkbox);
            } else if (state.equalsIgnoreCase("uncheck")) {
                toUnMarkCheckBox(checkbox);
            } else {
                logger.error("State should be 'check' or 'uncheck'");
                Assert.fail("State should be 'check' or 'uncheck'");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
}


