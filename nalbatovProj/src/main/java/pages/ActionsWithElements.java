package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithElements {
    protected WebDriver webDriver;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            System.out.println("Page was opened " + url);
        } catch (Exception e) {
            System.out.println("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }


    public void enterTextIntoInput(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            System.out.println(text + " was inputted into input");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement element) {
        try {
            element.click();
            System.out.println("Element was clicked");
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

    private void printErrorAndStopTest(Exception e) {
        System.out.println("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }
}