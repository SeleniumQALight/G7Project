package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ParentPage extends ActionsWithElements{
    final String BASE_URL = "https://qa-complexapp.onrender.com/";
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }
}
