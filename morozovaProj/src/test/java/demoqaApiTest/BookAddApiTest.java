package demoqaApiTest;

import demoqaAPi_hw.ApiHelperDemoqa;
import demoqaAPi_hw.BookDTO;
import demoqaAPi_hw.LoginApiDTO;
import demoqaAPi_hw.TestDataDemoqa;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BookAddApiTest {
    Logger logger = Logger.getLogger(getClass());
    ApiHelperDemoqa apiHelperDemoQA = new ApiHelperDemoqa();
    LoginApiDTO userInfo;


    @Before
    @After
    public void loginAndDeleteAllBooksByUser() {
        userInfo = apiHelperDemoQA.getUserInfo(TestDataDemoqa.LOGIN_DEFAULT, TestDataDemoqa.PASSWORD_DEFAULT);
        String userId = userInfo.getUserId();
        String token = userInfo.getToken();
        logger.info("The user has logged in");
        logger.info(String.format("UserId = '%s'. Token = '%s'", userId, token));

        apiHelperDemoQA.deleteAllBooksByUser(token, userId);
        logger.info("All books in Profile are deleted");

        int numberOfBooks = apiHelperDemoQA.getUserProfile(userId, token).getBooks().size();
        logger.info(String.format("Count of books after delete: %d", numberOfBooks));

        Assert.assertEquals("Count of books", 0, numberOfBooks);
    }

    @Test
    public void addBookByApiTest() {
        // Обираємо собі 1 книжку зі списку
        String bookIsbn = apiHelperDemoQA.getAllBooks().getBooks().get(0).getIsbn();
        apiHelperDemoQA.addBooksToUser(userInfo.getUserId(), bookIsbn, userInfo.getToken());
        logger.info(String.format("First book with ISBN '%s' add to user", bookIsbn));

        List<BookDTO> bookDTOList = apiHelperDemoQA.getUserProfile(userInfo.getUserId(), userInfo.getToken()).getBooks();
        logger.info(String.format("Count of books after add: %d", bookDTOList.size()));

        Assert.assertEquals("Count of books", 1, bookDTOList.size());
        Assert.assertEquals("ISBN of the first book", bookIsbn, bookDTOList.get(0).getIsbn());
    }
}

