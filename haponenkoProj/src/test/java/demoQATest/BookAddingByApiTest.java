package demoQATest;

import demoQA.*;
import org.apache.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import org.assertj.core.api.SoftAssertions;
import org.junit.Test;

public class BookAddingByApiTest {
    Logger logger = Logger.getLogger(getClass());
    ApiHelperDemoQA apiHelperDemoQA = new ApiHelperDemoQA();


    @Test
    public void addBookByApiTest() {
        SoftAssertions softAssertions = new SoftAssertions();
        UserInfoDTO userInfo = apiHelperDemoQA.getUserInfo(TestDataDemoQA.LOGIN_DEFAULT, TestDataDemoQA.PASSWORD_DEFAULT);
        String userId = userInfo.getUserId();
        String token = userInfo.getToken();

        softAssertions.assertThat(userInfo.getUserId()).as("User ID is empty").isNotEmpty();
        softAssertions.assertThat(userInfo.getToken()).as("Token is empty").isNotEmpty();

        softAssertions.assertAll();

        apiHelperDemoQA.deleteAllBooksByUser(token, userId);

        int numberOfBooks = apiHelperDemoQA.getNumberOfBooks(userId);
        softAssertions.assertThat(numberOfBooks).as("Number of books").isEqualTo(0);

        softAssertions.assertAll();

    }
}

