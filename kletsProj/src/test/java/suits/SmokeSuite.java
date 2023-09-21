package suits;


import LoginTests.SignOutTest;
import apiTests.ApiTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import postTests.CreatePost;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SignOutTest.class,
        CreatePost.class,
        ApiTest.class
})

public class SmokeSuite {
}
