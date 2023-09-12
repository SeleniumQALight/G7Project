package suits;

import apiTests.CreatePostByApiTest;
import loginTests.LoginTestWithPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import postTests.CreatePost;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTestWithPageObject.class,
        CreatePost.class,
        CreatePostByApiTest.class
})
public class SmokeSuite {
}
