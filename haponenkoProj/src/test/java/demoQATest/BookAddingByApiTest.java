package demoQATest;

import demoQA.*;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class BookAddingByApiTest {
    Logger logger = Logger.getLogger(getClass());
    ApiHelperDemoQA apiHelperDemoQA = new ApiHelperDemoQA();
    LoginApiResponseDTO userInfo;


    @Before
    public void loginAndDeleteAllBooksByUser() {
        userInfo = apiHelperDemoQA.getUserInfo(TestDataDemoQA.LOGIN_DEFAULT, TestDataDemoQA.PASSWORD_DEFAULT);
        String userId = userInfo.getUserId();
        String token = userInfo.getToken();
        logger.info(String.format("User is logged in. User ID is '%s'. Token is '%s'", userId, token));

        apiHelperDemoQA.deleteAllBooksByUser(token, userId);
        logger.info("All user's books are deleted");

        int numberOfBooks = apiHelperDemoQA.getUserProfile(userId, token).getBooks().size();
        logger.info(String.format("Number of books after deletion: %d", numberOfBooks));
        Assert.assertEquals("Number of books", 0, numberOfBooks);

    }

    @Test
    public void addBookByApiTest() {

        String bookIsbn = apiHelperDemoQA.getAllBooks().getBooks().get(0).getIsbn();
        apiHelperDemoQA.addBooksToUser(userInfo.getUserId(), bookIsbn, userInfo.getToken());
        logger.info(String.format("Book with ISBN '%s' is added to user", bookIsbn));
        List<BookDTO> bookDTOList = apiHelperDemoQA.getUserProfile(userInfo.getUserId(), userInfo.getToken()).getBooks();
        logger.info(String.format("Number of books after adding: %d", bookDTOList.size()));
        Assert.assertEquals("Number of books", 1, bookDTOList.size());
        Assert.assertEquals("ISBN of the first book", bookIsbn, bookDTOList.get(0).getIsbn());
    }
}

