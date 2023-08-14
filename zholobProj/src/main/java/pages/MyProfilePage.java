package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyProfilePage extends ParentPageWithHeder{
    private String postTitleLocator = "//*[text()='%s']"; // змінна для локатора заголовка поста
    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/profile/[a-zA-Z0-9]*"; // регулярний вираз для перевірки чи ми на сторінці профілю
    }

    public MyProfilePage checkIsRedirectToMyProfilePage() {
        checkUrlWithPattern(); //TODO check url
        return this;


        //TODO check unique element
    }

    private List<WebElement> getPostList(String title) {
        return webDriver.findElements(By.xpath(
                String.format(postTitleLocator, title)
        ));


    }

    public MyProfilePage checkpostWithTitleIsPresent(String title) {
        Assert.assertEquals("Count of posts with title " + title,
                1,
                getPostList(title).size());

        return this;

    }

    public MyProfilePage deletePostsTillPresent(String title) {
List<WebElement> postsList = getPostList(title);

int counter = 0;
while (!postsList.isEmpty() && counter < 100) {

    clickOnElement(getPostList(title).get(0));
    new PostPage(webDriver)
            .checkIsRedirectToPostPage()
            .clickOnDeletePostButton()
            .checkIsRedirectToMyProfilePage();
    logger.info("Post with title " + title + " was deleted");
    postsList = getPostList(title);
    counter++;

}
if (counter >= 100) {
    Assert.fail("There are more than 100 posts with title " + title );
}
//
        return this;
    }
}