package pages.elements;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPageWithHeader;

abstract public class commonCreatePostAndEditPost extends ParentPageWithHeader {
    public commonCreatePostAndEditPost(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(id = "post-title") // //*[@id='post-title'] - the same
    private WebElement inputTitle;

    @FindBy(name = "body") // //*[@name='body'] - the same
    private WebElement inputBody;

    @FindBy(tagName = "select") // dropdown
    private WebElement dropDownSelectValue;

    @FindBy(xpath = ".//input[@type='checkbox']")
    private WebElement checkBoxUniquePost;

    public void enterTextIntoInputTitle(String text) {
        enterTextIntoInput(inputTitle, text);
    }

    public void enterTextIntoInputBody(String text) {
        enterTextIntoInput(inputBody, text);
    }

    public void selectTextInDropDown(String text) {
        selectTextInDropDown(dropDownSelectValue, text);
    }

    public void checkStatusCheckBoxUniquePost(String status) {
        try {
            if (status.equals("check")) {
                setCheckboxState(checkBoxUniquePost);

            } else if (status.equals("uncheck")) {
                unsetCheckboxState(checkBoxUniquePost);
            } else {
                logger.error("Status should be 'check' or 'uncheck'");
                Assert.fail("Status should be 'check' or 'uncheck'");
            }
        } catch (Exception e) {
            logger.error("Can not work with checkbox");
            Assert.fail("Can not work with checkbox");
        }
    }
}
