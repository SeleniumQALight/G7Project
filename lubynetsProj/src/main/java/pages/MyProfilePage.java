package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MyProfilePage  extends  ParentPageWithHeader {

    private String postTitleLocator = ".//*[text()='%s']";

    public MyProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public MyProfilePage checkIsRedirectToMyProfilePage() {
        //TODO check url
        // TODO check unique element

        return this;
    }

    public List<WebElement> getPostList(String title) {

        return webDriver.findElements(By.xpath(
                String.format(postTitleLocator, title
                )));
    }

    public MyProfilePage checkPostWithTitleIsPresent(String title) {
        Assert.assertEquals(" Count of posts with title " + title, 1, getPostList(title).size());

        return this;
    }

    public MyProfilePage deletePostTillPresent(String title) {
    List<WebElement> postlist = getPostList(title);
        int counter = 0;
    while (!postlist.isEmpty()  && counter < 100 ){

        clickOnElement(postlist.get(0));
        new PostPage(webDriver).checkIsRedirectOnPostPage()
                .clickOnDeleteButton()
                .checkIsRedirectToMyProfilePage();
        logger.info("Post with title " + title + " was deleted");
        postlist = getPostList(title);

        counter++;
    }

    if (counter >= 100){
        Assert.fail("There are more than 100 posts with title " + title + "or delete button does not work");
    }
        return this;
    }




    }

