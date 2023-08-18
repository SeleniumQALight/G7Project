package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyProfilePage extends ParentPageWithHeader {

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
        //TODO check some unique element
        return this;
    }

    private List<WebElement> getPostList(String title) {
        return webDriver.findElements(By.xpath(
                String.format(postTitleLocator, title)
        ));
    }

    public MyProfilePage checkPostWithTitleIsPresent(String title) {
        Assert.assertEquals("Count of posts with title " + title,
                1, getPostList(title).size());
        return this;
    }

    public MyProfilePage deletePostsTillPresent(String title) {
        List<WebElement> postsList = getPostList(title);
        int counter = 0;
        while (!postsList.isEmpty() && counter < 100) {

            clickOnElement(postsList.get(0));
            new PostPage(webDriver)
                    .checkIsRedirectToPostPage()
                    .clickOnDeletePostButton()
                    .checkIsRedirectToMyProfilePage();
            logger.info("Post with title " + title + " was deleted");
            postsList = getPostList(title);
            counter++;
        }
        if (counter >= 100) {
            Assert.fail("There are more than 100 posts with title " + title);
        }
        return this;
    }

    public PostPage selectPostByTitle(String title) {
        clickOnElement(webDriver.findElement(By.xpath(String.format(postTitleLocator, title))));
        return new PostPage(webDriver);
    }
}
