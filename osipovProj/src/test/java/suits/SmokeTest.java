package suits;

import loginTests.LoginTestWithPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import postTests.CreatePost;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTestWithPageObject.class,
        CreatePost.class
})
public class SmokeTest {
}
