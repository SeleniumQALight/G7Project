package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyProfilePage extends ParentPageWithHeader {
    @FindBy (xpath = ".//a[@class='list-group-item list-group-item-action']")
    private List<WebElement> postsList;

    private String postTitleLocator = ".//*[text()='%s']";

    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/profile/[a-zA-Z0-9]*";
    }

    public MyProfilePage checkIsRedirectToMyProfilePage() {
        checkUrlWithPattern();
        return this;
    }

    public List<WebElement> getPostsList(String title) {
        return webDriver.findElements(By.xpath(String.format(postTitleLocator, title)));
    }

    public MyProfilePage checkPostWithTitleIsPresent(String title) {
        Assert.assertEquals("Count of posts with title " + title,
                1, getPostsList(title).size());
        return this;
    }

    public PostPage clickOnPostFromTheList(String title) {
        clickOnElement(getPostsList(title).get(0));
        return new PostPage(webDriver);
    }

    public MyProfilePage deletePostWithTitle(String postTitle) {
        List<WebElement> postsList = getPostsList(postTitle);
        int counter = 0;
        while (!postsList.isEmpty() && counter < 100) {
            clickOnElement(postsList.get(0));
            new PostPage(webDriver)
                    .checkIsRedirectToPostPage()
                    .clickOnDeletePostButton()
                    .checkIsRedirectToMyProfilePage();
            logger.info("Post with title " + postTitle + " was deleted");
            postsList = getPostsList(postTitle);
            counter++;
        }
        if (counter >= 100) {
            Assert.fail("There are more than 100 posts with title " + postTitle);
        }
        return this;
    }

    public void checkNumberOfPosts(int numberOfPosts) {
        Assert.assertEquals("number of posts", numberOfPosts, postsList.size());
    }
}
