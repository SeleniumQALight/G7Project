package postTests;

import baseTest.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class EditPostTitle extends BaseTest {
    @FindBy(xpath = "//a[@class='list-group-item list-group-item-action']")
    private List<WebElement> postList;
    String postTitle;

    @Before
    public void createAndCheckPost() {
        postTitle = pageProvider.getLoginPage().createValidPostAndCheckIfExist();
    }

    @Test
    public void searchAndEditTitle() {
        pageProvider.getHomePage()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .clickOnPostFromTheList(postTitle)
                .checkIsRedirectToPostPage()
                .clickOnEditButton()
                .checkIsRedirectToEditPostPage()
                .editPostTitle(postTitle + "test")
                .saveEditPostChanges()
                .getHeader()
                .clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .checkPostWithTitleIsPresent(postTitle + "test");
    }

    @After
    public void deletePost() {
        pageProvider.getHomePage()
                .openHomePageAndLoginIfNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostWithOneNameOrAnother(postTitle, postTitle + "test");
    }
}
