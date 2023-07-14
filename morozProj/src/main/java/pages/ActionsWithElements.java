package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithElements {
    WebDriver webDriver;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            System.out.println("Page was opened");
        } catch (Exception e) {
            System.out.println("Page can not be opened");
            Assert.fail("Page can not be opened");
        }
    }

    public void enterTextIntoInput(String text, WebElement input){
        try {
            input.clear();
            input.sendKeys(text);
            System.out.println(text + " was inputted");
        } catch (Exception e) {
           printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement element){
        try {
            element.click();
            System.out.println("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement element){
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    private void printErrorAndStopTest(Exception e) {
        System.out.println("Cannot work with element " + e);
        Assert.fail("Cannot work with element " + e);
    }
}
