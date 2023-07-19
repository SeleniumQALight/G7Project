package pages;

import org.openqa.selenium.WebDriver;

public class ParentPage extends ActionsWithElements{
    final String BASE_URL = "https://qa-complexapp.onrender.com";
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

}
