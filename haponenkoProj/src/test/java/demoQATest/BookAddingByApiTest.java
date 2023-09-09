package demoQATest;

import demoQA.ApiHelperDemoQA;
import demoQA.TestDataDemoQA;
import demoQA.UserInfoDTO;
import org.junit.Before;
import org.junit.Test;

public class BookAddingByApiTest {
    ApiHelperDemoQA apiHelperDemoQA = new ApiHelperDemoQA();


    @Test
    public void addBookByApiTest() {
        UserInfoDTO userInfo = apiHelperDemoQA.getUserInfo(TestDataDemoQA.LOGIN_DEFAULT, TestDataDemoQA.PASSWORD_DEFAULT);
        String userId = userInfo.getUserId();
        String token = userInfo.getToken();

//            apiHelperDemoQA.deleteAllBooksByUser(ApiHelperDemoQA.getUserInfo().getUserId());}


//        apiHelperDemoQA.addBookByApi(token);
    }
}
