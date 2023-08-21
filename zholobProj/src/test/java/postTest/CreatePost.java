package postTest;


import baseTest.BaseTest;
import libs.Util;
import org.junit.After;
import org.junit.Test;


public class CreatePost extends BaseTest {
    private String title = "TC01 - New Post Inna" + Util.getDateAndTimeFormatted();
    private String body = "Body of Post Inna";



    @Test
    public void createNewPost() {

        pageProvider.getHomePage()
                .openHomePage().checkIsRedirectToHomePage() //певірка чи ми на дошній сторінці
                .getHeader().clickOnButtonCreatePost() // клік на кнопку CreatePost
                .checkIsRedirectToCreatePostPage() //певірка чи ми на сторінці CreatePost
                .enterTextIntoInputTitle(title)// вводимо текст в поле Title
                .enterTextIntoInputBody(body)
                .selectTextInDropDown2("Приватне повідомлення") // вибираємо значення з дропдауну по тексту
                .selectOnCheckBoxIs("check") // вибираємо чекбокс
                //.selectValueInDropDown("One Person")//
                .clickOnButtonSaveNewPost()
                .checkTextInSuccessMessage("New post successfully created.") // перевірка чи  повідомлення выдповідає тексту в елементі

//перевірка створеного поста:
                .checkTitleTextInSuccessMessage(title) // перевірка чи  заголовок выдповідає тексту в елементі
                .checkBodyTextInSuccessMessage(body) // перевірка чи  тіло выдповідає тексту в елементі
                .checkPostUniqueSuccessMessage("Is this post unique? : yes") // перевірка чи  пост є унікальним
                .checkPostForUsersSuccessMessage("One Person");


// перевіряє повідомлення в профайлі
        pageProvider.getPostPage().getHeader().clickOnMyProfileButton()//
                .checkIsRedirectToMyProfilePage()// перевірка чи ми на сторінці профайлу
                .checkpostWithTitleIsPresent(title) // перевырка  чи є пост з таким заголовком
        ;
    }

    @After
    public void deletePosts() {
        pageProvider.getHomePage().openHomePageAndLoginifNeeded()
                .openHomePageAndLoginifNeeded()
                .getHeader().clickOnMyProfileButton()
                .checkIsRedirectToMyProfilePage()
                .deletePostsTillPresent(title)
        ;
    }

}

