package suit;

import apiTest.ApiTest;
import loginTests.LoginTestWithPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import postTests.CreatePostWithDB;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTestWithPageObject.class,
        CreatePostWithDB.class,
        ApiTest.class
})
public class SmokeSuite {
}
