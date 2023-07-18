package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithElements {
    protected WebDriver webDriver;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * @param url
     */
    public void openPage(String url) {
        try {
            webDriver.get(url);
            System.out.println("Page was opened " + url);
        } catch (Exception e) {
            System.out.println("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }
    private void printErrorAndStopTest(Exception e) {
        System.out.println("Can not work with element" + e);
        Assert.fail("Can not work with element" + e);
    }
    public void clickOnElement(WebElement element) { //method for clicking on element
        try {
            element.click();
            System.out.println("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void enterTextInput(WebElement element, String text) { //method for inputting text
        try {
            element.clear();
            element.sendKeys(text);
            System.out.println(text + " was inputted");
        } catch (Exception e) {
// System.out.println("Can not work with element" + e);
// Assert.fail("Can not work with element" + e);
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
}
