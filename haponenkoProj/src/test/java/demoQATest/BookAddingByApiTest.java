package demoQATest;

import demoQA.*;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Before;
import org.junit.Test;

public class BookAddingByApiTest {
    Logger logger = Logger.getLogger(getClass());
    ApiHelperDemoQA apiHelperDemoQA = new ApiHelperDemoQA();


    @Before
    public void deleteAllBooksByUser() {
        SoftAssertions softAssertions = new SoftAssertions();
        UserInfoDTO userInfo = apiHelperDemoQA.getUserInfo(TestDataDemoQA.LOGIN_DEFAULT, TestDataDemoQA.PASSWORD_DEFAULT);
        String userId = userInfo.getUserId();
        String token = userInfo.getToken();

        apiHelperDemoQA.deleteAllBooksByUser(token, userId);

        int numberOfBooks = apiHelperDemoQA.getNumberOfUserBooks(userId);
        softAssertions.assertThat(numberOfBooks).as("Number of books").isEqualTo(0);

        softAssertions.assertAll();

    }

    @Test
    public void addBookByApiTest() {

        String bookIsbn = ApiHelperDemoQA.getAllBooks().getBooks().get(0).getIsbn();
//        logger.info("ISBN of the first book: " + bookIsbn);
    }
}

