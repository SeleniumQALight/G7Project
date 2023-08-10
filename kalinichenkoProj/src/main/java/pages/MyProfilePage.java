package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyProfilePage extends ParentPageWithHeader {
    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    private String postTitleLocator = ".//*[text()='%s']";

    public MyProfilePage checkIsRedirectToMyProfilePage() {
        //TODO check url
        //todo check unique element
        return this;
    }

    private List<WebElement> getPostsList(String title) {
        return webDriver.findElements(By.xpath(
                String.format(postTitleLocator, title)
        ));
    }

    public MyProfilePage checkIsPostWithTitlePresent(String title) {
        Assert.assertEquals("Number of posts with title " + title,
                1, getPostsList(title).size());
        return this;
    }

    public MyProfilePage deletePostsTillPresent(String title) {
        List<WebElement> postsList = getPostsList(title);
        int counter = 0;
        while (!postsList.isEmpty() && counter < 100) {
            clickOnElement(postsList.get(0));
            new PostPage(webDriver)
                    .checkIsRedirectToPostPage()
                    .clickOnDeletePostButton()
                    .checkIsRedirectToMyProfilePage();
            logger.info("Post with title " + title + " was deleted");
            postsList = getPostsList(title);
            counter++;
        }
        if (counter >= 100) {
            Assert.fail("There are more than 100 posts with title " + title
                    + " or deleting takes too much time");
        }

        return this;
    }
}
