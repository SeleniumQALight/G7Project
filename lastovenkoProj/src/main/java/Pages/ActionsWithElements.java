package Pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithElements {
    protected WebDriver webDriver;

    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    //    public void enterTextInToInput(WebElement input, String text)
    public void openPage(String url) {
        try {
            webDriver.get(url);
            System.out.println("Page was opened" + url);
        } catch (Exception e) {
            System.out.println("Can not open" + url);
            Assert.fail("Can not open" + url);
        }
    }

    public void enterText(WebElement input, String text) {
        try {
            input.clear();
            input.sendKeys(text);
            System.out.println(text + "was inputted");
        } catch (Exception e) {
            //System.out.println("Can not work with element" + e);
            // Assert.fail("Can not work with element" + e);
        }
    }

    private void clickOnElement(WebElement element) {
        try {
            element.click();
            System.out.println("Element was clicked");
        } catch (Exception e) {
            System.out.println("Can not work with element" + e);
            Assert.fail("Can not work with element" + e);
        }
    }
    public boolean isElementDisplayed(WebElement element) {
        try {
            boolean state = element.isDisplayed();
            System.out.println("Element is displayed");
            return state;
        } catch (Exception e) {
            System.out.println("Element is not displayed" + e);
            return false;
        }
    }

}


