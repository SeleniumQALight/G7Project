package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MyProfilePage extends ParentPageWithHeader {

    private String postTitleLocator = ".//*[text()='%s']";//".//*[text()='" + title + "']";


    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MyProfilePage checkIsRedirectToMyProfilePage() {
        //TODO check url
        //TODO check is Page Title correct
        return this;

    }

    public MyProfilePage checkPostWithTitleIsPresent(String title) {
        Assert.assertEquals("Count of posts with title " + title, 1, getPostsList(title).size());
        return this;
    }

    private List<WebElement> getPostsList(String title) {
        return webDriver.findElements(By.xpath(String.format(postTitleLocator, title)));
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
            Assert.fail("There are more than 100 posts with title " + title + " or Delete button was not found");
        }
        return this;
    }
}
