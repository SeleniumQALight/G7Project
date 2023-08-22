package suits;


import LoginTests.SignOutTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import postTests.CreatePost;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SignOutTest.class,
        CreatePost.class
})

public class SmokeSuite {
}
