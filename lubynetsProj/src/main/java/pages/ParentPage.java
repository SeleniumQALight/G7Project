package pages;

import org.openqa.selenium.WebDriver;

public class ParentPage extends ActionWithElements {
    final String BASE_URL = "https://qa-complexapp.onrender.com/";

    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }
}
