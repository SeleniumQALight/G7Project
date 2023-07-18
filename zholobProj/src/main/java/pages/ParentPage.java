package pages;

import org.openqa.selenium.WebDriver;

public class ParentPage extends ActionsWithElements{
    final String BASE_URL = "https://qa-complexapp.onrender.com"; // final - це константа, яку не можна змінити
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }
}
