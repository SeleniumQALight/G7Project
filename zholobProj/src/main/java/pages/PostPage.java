package pages;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostPage extends ParentPageWithHeder {
    @FindBy(xpath = ".//div[@class='alert alert-success text-center']") // повыдомлення про успішне створення поста
    private WebElement successMessageElement;

    @FindBy(xpath = ".//h2") // заголовок поста на сторінці Post Page
    private WebElement postTitleOnPostPageElement;

    @FindBy(xpath = "//*[@class='body-content'][2]//p") // тіло поста на сторінці Post Page
    private WebElement postBodyOnPostPageElement;

    @FindBy(xpath = "//i//u ") // повыдомлення для кого створено пост на сторінці Post Page (для всіх)
    private WebElement postForUsersOnPostPageElement;

    @FindBy(xpath = "//*/p[contains(text(),'unique')] ") // повыдомлення про унікальність поста на сторінці Post Page (no)
    private WebElement postUniqueOnPostPageElement;


    public PostPage(WebDriver webDriver) {
        super(webDriver);
    }

    public PostPage checkIsRedirectToPostPage() { // перевірка чи ми на сторінці Post Page
//TODO check URL
// TODO unique elements
        return this;
    }

    public PostPage checkIsSuccessMessageDisplayed() { // перевірка чи є повідомлення про успішне створення поста
        checkElementDisplayed(successMessageElement);
        return this;
    }

   // Методи для перевірки тексту в елементах:

    public PostPage checkTextInSuccessMessage(String text) {  //метод перевыряє чи відповідає заданий текст тексту  в елементі
        Assert.assertEquals("Text in message", text, successMessageElement.getText());
        return this;
    }
   public PostPage checkTitleTextInSuccessMessage(String text) {  //метод перевыряє чи відповідає заголовок  тексту  в елементі
        Assert.assertEquals("Text in message", text, postTitleOnPostPageElement.getText());
        return this;
    }
    public PostPage checkBodyTextInSuccessMessage(String text) {  //метод перевыряє чи відповідає тіло поста  тексту  в елементі
        Assert.assertEquals("Text in message", text, postBodyOnPostPageElement.getText());
        return this;
    }

    public PostPage checkPostForUsersSuccessMessage(String text) {  //метод перевыряє чи відповідає для кого створено пост  тексту  в елементі
        Assert.assertEquals("Text in message", text, postForUsersOnPostPageElement.getText());
        return this;
    }

    public PostPage checkPostUniqueSuccessMessage(String text) {  //метод перевыряє чи відповідає унікальність поста  тексту  в елементі
        Assert.assertEquals("Text in message", text, postUniqueOnPostPageElement.getText());
        return this;
    }

}


