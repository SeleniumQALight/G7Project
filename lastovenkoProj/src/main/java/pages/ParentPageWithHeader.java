package pages;

import element.Header;
import org.openqa.selenium.WebDriver;

public class ParentPageWithHeader extends ParentPage {
    Header header;
    public Header getHeader()
    { return  new Header(webDriver);
    }

    public ParentPageWithHeader(WebDriver webDriver) {
        super(webDriver);
    }
}
