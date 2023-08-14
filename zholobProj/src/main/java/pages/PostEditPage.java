package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PostEditPage extends ParentPageWithHeder {
    public PostEditPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return null;
    }

    @FindBy(xpath = "//input[@id='post-title']") // локатор для поля вводу заголовку поста
    private WebElement inputTitleOnEditPage;

    @FindBy(xpath = "//button[@class='btn btn-primary']") // локатор для кнопки Save Updates
    private WebElement buttonSaveUpdates;

    @FindBy(xpath = "//div[@class='alert alert-success text-center']") // локатор для повідомлення про успішне редагування поста
    private WebElement successfullyEditPost;



    public PostEditPage checkIsRedirectToPostEditPage() { // перевірка чи ми на сторінці редагування поста
        checkUrlWithPattern("/edit/\\d+");
        return this;
    }


    public PostEditPage enterTextIntoInputTitle(String title) { // метод для вводу заголовку в поле
        enterTextIntoInput(inputTitleOnEditPage, title);
        return this;
    }


    public PostEditPage clickOnButtonSaveUpdates() { // метод для кліку на кнопку Save Updates
        clickOnElement(buttonSaveUpdates);
        return this;
    }

    public PostEditPage checkIsMessageSuccessfullyEditPost () { // перевірка чи є повідомлення про успішне редагування поста
        Assert.assertTrue("Message is not displayed", isElementDisplayed(successfullyEditPost));
        return this;
    }
}
