package BooksDemoqa;

import BooksDemoqa.BooksDto.BooksDto;
import BooksDemoqa.BooksDto.LoginBooksDto;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

//import java.util.logging.Logger;

public class CheckAddBookTest {
    Logger logger = Logger.getLogger(getClass());
    ApiHelperBooks apiHelperBooks = new ApiHelperBooks();
    LoginBooksDto userInfo;

    //////!!!!! Напевно найкраще б було тут використати Кукумбер !!!!!
    @Test
    public void checkAddBookForUser() {
        //ЛОГІНЮСЬ
        userInfo = apiHelperBooks.getUserInfo(TestDataBooks.DEFAULT_USERNAME, TestDataBooks.DEFAULT_PASSWORD);
        String userId = userInfo.getUserId();
        String token = userInfo.getToken();
        logger.info("!!!!!!!!!!!користувач залогінився");
        logger.info(String.format(" UserId = '%s'. Token = '%s'", userId, token));


        //ВИДАЛЯЮ ВСІ КНИЖКИ ЮЗЕРА
        ApiHelperBooks.deleteAllBooksForUser(token, userId);
        logger.info("!!!!!!!!!!!!!всі книжки видалено");
        //Кількість книжок юзера після видалення
        int sizeOfBooksUser = apiHelperBooks.getUserBooks(userId, token)
                .getBooks().size();
        //перевыряю що в списку 0 книжок пысля видалення
        Assert.assertEquals("!!!!!!!!!!!!!!кількість книжок", 0, sizeOfBooksUser);


        //ДОДАЮ ПЕРШУ КНИЖКУ
        //обираю першу зі списку всіх книжок на сайті
        String isbn = apiHelperBooks.getAllBooks().getBooks().get(0).getIsbn();
        //додаю першу книжку
        apiHelperBooks.addBookForUser(userId, token, isbn);
        logger.info(String.format("!!!!!!!!!!!!!перша книжка ISBN '%s' додана юзеру", isbn));


        //СПИСОК КНИЖОК ЮЗЕРА ПІСЛЯ ДОДАВАННЯ
        List<BooksDto> booksDtoList = apiHelperBooks.getUserBooks(userId, token)
                .getBooks();
        logger.info(String.format("!!!!!!!!!!!!!кількість книжок після додавання %s ", booksDtoList.size()));



        //ПЕРЕВІРКА ЩО В СПИСКУ 1 КНИЖКА І ЩО ЦЕ ТА КНИЖКА ЯКА ПЕРША ЗІ СПИСКУ ВСІХ КНИЖОК
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(booksDtoList.size())
                .as("Кількість книжок")
                .isEqualTo(1);

        softAssertions.assertThat(booksDtoList.get(0).getIsbn())
                .as("Перша книга списку")
                .isEqualTo(isbn);

        softAssertions.assertAll();
    }
}


