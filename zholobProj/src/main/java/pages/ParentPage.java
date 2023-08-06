package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPage extends ActionsWithElements{
    final String BASE_URL = "https://aqa-complexapp.onrender.com"; // final - це константа, яку не можна змінити
    public ParentPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openPage(String url) { // метод для відкриття сторінки
        try {
            webDriver.get(url);
            logger.info("Page was opened " + url);
        } catch (Exception e) {
            logger.error("Can not open " + url);
            Assert.fail("Can not open " + url);
        }
    }
}
