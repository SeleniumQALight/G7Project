package pages;

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
        PageFactory.initElements(webDriver, this);//инициализирует все элементы на странице @FindBy в LoginPage и ParentPage (все элементы, которые находятся в ActionsWithElements)
        webDriverWait10 = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriverWait15 = new WebDriverWait(webDriver, Duration.ofSeconds(15));
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

    public void checkOrUncheckCheckBoxDependingOnText(WebElement checkBox, String text) {
        try {
            if (text.equals("check")) {
                if (!checkBox.isSelected()) {
                    checkBox.click();
                    logger.info("CheckBox was checked");
                } else {
                    logger.info("CheckBox is already checked");
                }
            } else if (text.equals("uncheck")) {
                if (checkBox.isSelected()) {
                    checkBox.click();
                    logger.info("CheckBox was unchecked");
                } else {
                    logger.info("CheckBox is already unchecked");
                }
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }
}
//ДЗ №4:
//        1. Написати метод вибору значення в дроп дауні через UI (Знайти елемент, клікнути по ньому, знайти потрібний рядок по тексту(текст захардкодити в локаторі рядочка), і клікнути по ньому). Це повинени бути новий метод selectTextInDropDownByUI в ActionsWithElements (не пишіть код знову для кліка, а використовуйте вже існуючі методи)
//
//        2. Створити метод який буде робити чекбокс вибраним
//        3. Створити метод який буде робити чекбокс не вибраним
//        4.Створити метод встановлення заданого стану у чекбокс
//        - метод повинен приймати на вхід стрінговий стан (check or uncheck)
//        - в залежності від стану чекбокса і необхідного стану - клікати і виводити повідомлення в лог, чи не клікати і просто виводити повідомлення в лог.
//        - додати цей метод в наш тест по створенню поста (зі значенням check) і перевірку на наступному скріні
//
//        5. зробити перевірку на сторінці postPage що ми бачимо текст тайтла, боді - такіж, з якими ми створювали пост (порівняти текс з них з очикуваним, тим який передавали при створені). А також перевірити що бачите текст Note: This post was written for One Person і Is this post unique? : yes — це теж зробити простим порівнянням тексту з елементку з текстом переданим з тесткейсу..