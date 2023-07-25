package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionWitElements;

public class Header extends ActionWitElements {
    @FindBy(xpath = "//button[text() = 'Sign Out']")
    public WebElement buttonSignOut;

    @FindBy(xpath = "//*[@class='text-white mr-2 header-search-icon']//*[@class='svg-inline--fa fa-search fa-w-16']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//*[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;

    @FindBy(xpath = "//*[@data-original-title='My Profile']")
   private WebElement byttonMyProfile;

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-comment fa-w-16']//*[@fill='currentColor']")
    private WebElement buttonChat;



   // @FindBy(xpath = "//*[@class='btn btn-sm btn-outline-secondary']")
    public Header(WebDriver webDriver) {
        super(webDriver);
    }
    public void checkIsButtonSignOutVisible(){
        checkElementDisplayed(buttonSignOut);
    }

    public void checkIsButtonSearchVisible(){
        checkElementDisplayed(buttonSearch);
    }
    public void checkIsButtonCreatePostVisible(){
        checkElementDisplayed(buttonCreatePost);
    }
    public void checkIsButtonMyProfileVisible(){
        checkElementDisplayed(byttonMyProfile);
    }
    public void checkIsButtonChatVisible(){
        checkElementDisplayed(buttonChat);
    }
    public void checkNotIsButtonSignOutVisible(){
        checkElementNotDisplayed(buttonSignOut);
    }
    public  void checkNotIsButtonSearchVisible(){
        checkElementNotDisplayed(buttonSearch);
    }
    public  void checkNotIsButtonCreatePostVisible(){
        checkElementNotDisplayed(buttonCreatePost);
    }
    public  void checkNotIsButtonMyProfileVisible(){
        checkElementNotDisplayed(byttonMyProfile);
    }
    public  void checkNotIsButtonChatVisible(){
        checkElementNotDisplayed(buttonChat);
    }


}
