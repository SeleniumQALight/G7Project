package pages;

import org.openqa.selenium.WebDriver;
import pages.elements.Header;

abstract public class ParentPageWithHeder extends ParentPage {
    Header header;

    public ParentPageWithHeder(WebDriver webDriver) {
        super(webDriver);
    }

    public Header getHeader() {
        return new Header(webDriver);
    }
}