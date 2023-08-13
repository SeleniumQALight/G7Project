package workWithBrowser;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import pages.ActionsWithElements;

import java.util.Set;

public class WorkWithBrowser extends ActionsWithElements {
    public WorkWithBrowser(WebDriver webDriver) {
        super(webDriver);
    }

    // how to add new window in browser and switch to it
    public void addNewWindow() {
        ((JavascriptExecutor) webDriver).executeScript("window.open()");
        Set<String> handles = webDriver.getWindowHandles();
        String currentHandle = webDriver.getWindowHandle();
        handles.remove(currentHandle);
        String nextHandle = handles.iterator().next();
        webDriver.switchTo().window(nextHandle);
    }

    // how to switch to previous window
    public void switchToPreviousWindow() {
        Set<String> handles = webDriver.getWindowHandles();
        String currentHandle = webDriver.getWindowHandle();
        handles.remove(currentHandle);
        String nextHandle = handles.iterator().next();
        webDriver.switchTo().window(nextHandle);
    }

    //how to refresh page
    public void refreshPage() {
        webDriver.navigate().refresh();
    }

    //how to switch to next field in form
    public void switchToNextField() {
        webDriver.switchTo().activeElement().sendKeys("\t");
    }

    public void enterTextIntoInput(String text) {
        try {
            webDriver.switchTo().activeElement().clear();
            webDriver.switchTo().activeElement().sendKeys(text);
            logger.info(text + " was inputted into input");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }



    // how to press enter
    public void pressEnter() {
        webDriver.switchTo().activeElement().sendKeys("\n");
    }

}
