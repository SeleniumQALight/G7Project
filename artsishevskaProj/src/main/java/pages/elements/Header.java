package pages.elements;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ActionWitElements;
import pages.CreatePostPage;
import pages.MyProfilePage;

public class Header extends ActionWitElements {
    @FindBy(xpath = "//button[text() = 'Sign Out']")
    public WebElement buttonSignOut;

    @FindBy(xpath = "//*[@class='text-white mr-2 header-search-icon']//*[@class='svg-inline--fa fa-search fa-w-16']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//*[@class='btn btn-sm btn-success mr-2']")
    private WebElement buttonCreatePost;

    @FindBy(xpath = "//*[@data-original-title='My Profile']")
   private WebElement buttonMyProfile;

    @FindBy(xpath = "//*[@class='svg-inline--fa fa-comment fa-w-16']//*[@fill='currentColor']")
    private WebElement buttonChat;



   // @FindBy(xpath = "//*[@class='btn btn-sm btn-outline-secondary']")
    public Header(WebDriver webDriver) {
        super(webDriver);
    }
    @Step
    public void checkIsButtonSignOutVisible(){
        checkElementDisplayed(buttonSignOut);
    }
    @Step

    public void checkIsButtonSearchVisible(){
        checkElementDisplayed(buttonSearch);
    }
    public void checkIsButtonCreatePostVisible(){
        checkElementDisplayed(buttonCreatePost);
    }
    public void checkIsButtonMyProfileVisible(){
        checkElementDisplayed(buttonMyProfile);
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
        checkElementNotDisplayed(buttonMyProfile);
    }
    public  void checkNotIsButtonChatVisible(){
        checkElementNotDisplayed(buttonChat);
    }
    public CreatePostPage clickOnButtonCreatePost(){
        clickOnElement(buttonCreatePost);
        return new CreatePostPage(webDriver);
    }


    public MyProfilePage clickOnMyProfileButton() {
        clickOnElement(buttonMyProfile);
        return new MyProfilePage(webDriver);
    }
    @Step

    public boolean isButtonSignOutVisible() {
        return isElementDisplayed(buttonSignOut);
    }
}
