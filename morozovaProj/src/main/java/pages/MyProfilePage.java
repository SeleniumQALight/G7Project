package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyProfilePage extends ParentPageWithHeder {

    private String postTitleLocator = ".//*[text()='%s']";

    public MyProfilePage(WebDriver webDriver) {

        super(webDriver);

    }

    @Override
    protected String getRelativeUrl() {
        return "/profile/[a-zA-Z0-9]*";// символів може бути від 1 до безлічі
    }

    public MyProfilePage checkIsRedirectToMyProfilePage() {
        checkUrlWithPattern();
        // TODO unique element

        return this;
    }

    private List<WebElement> getPostslist(String title) {
        return webDriver.findElements(By.xpath(
                String.format(postTitleLocator, title)
        ));
    }

    public MyProfilePage checkPostWithTitleIsPresent(String title) {
        // TODO отримати локатор з текстом
        // TODO перевірити чи елемент присутній s nskmrb 1
        Assert.assertEquals("Count of posts with title " + title,
                1, getPostslist(title).size());//порівняй з 1(що він 1 елемент)
        return this;
    }

    public MyProfilePage deletePostsTillPresent(String title) {
        List<WebElement> postsList = getPostslist(title);
        int counter = 0;
        while (!postsList.isEmpty() && counter < 100) {// роби поки список не пустий

            clickOnElement(postsList.get(0));
            new PostPage(webDriver)
                    .checkIsRedirectToPostPage()
                    .clickOnDeletePostButton()
                    .checkIsRedirectToMyProfilePage();
            logger.info("Post with title " + title + " was deleted");
            postsList = getPostslist(title);
            counter++;
        }
        if (counter >= 100) {
            Assert.fail("There are more than 100 posts with title " + title);
        }
        //TODO check that posts with title not present

        return this;
    }

    public void clickOnPostWithTitle(String title) {
        clickOnElement(title);
    }
}
