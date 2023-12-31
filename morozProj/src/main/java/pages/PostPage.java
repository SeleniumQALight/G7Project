package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeader{

    @FindBy(xpath = "//*[@class='delete-post-button text-danger']")
    private WebElement deleteButton;

    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;

    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PostPage checkIsRedirectToPostPage(){
        //TODO check url
        //TODO unique elements

        return this;
    }

    public PostPage checkIsSuccessMessageDisplayed(){
        checkElementDisplayed(successMessageElement);
        return this;
    }

    public PostPage checkTextInSuccessMessage(String text){
        Assert.assertEquals("Text in message", text, successMessageElement.getText());
        return this;
    }

    public MyProfilePage clickOnDeleteButton(){
        clickOnElement(deleteButton);
        return new MyProfilePage(webDriver);
    }
}
