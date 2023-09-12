package suits;

import apiTests.ApiTest;
import apiTests.ApiTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import postTests.CreatePost;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreatePost.class,
        ApiTest.class
})
public class SmokeSuite {
}