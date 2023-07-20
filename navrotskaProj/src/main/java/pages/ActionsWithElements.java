package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ActionsWithElements {
    protected WebDriver webDriver;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver; // initialize webDriver
        PageFactory.initElements(webDriver, this); // initialize all elements from this class will be initialized elements in FindBY
    }

    public void openPage(String url) {
        try {
            webDriver.get(url);
            System.out.println("Page was opened with URL: " + url);
        } catch (Exception e) {
            System.out.println("Can not open " + url); // print message in report
            Assert.fail("Can not open " + url); // stop test and type in console that test was failed
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

    public void checkElementDisplayed(WebElement element) {
        Assert.assertTrue("Element is not displayed", isElementDisplayed(element));
    }


    private void printErrorAndStopTest(Exception e) {
        System.out.println("Can not work with element " + e); // print message in report
        Assert.fail("Can not work with element " + e); // stop test and type in console that test was failed
    }

}
