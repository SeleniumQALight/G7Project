package pages;

import org.openqa.selenium.WebDriver;
import pages.elements.Header;

abstract public class ParentPageWithHeder extends ParentPage {
    Header header;
    public ParentPageWithHeder(WebDriver webDriver) { // конструктор
        super(webDriver);

    }
    public Header getHeader() { // метод для створення об'єкту Header
        return new Header(webDriver);
    }
}