package suits;

import loginTests.LoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import postTests.createPost;


@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTest.class,
createPost.class}
)

public class SmokeSuite {

}
