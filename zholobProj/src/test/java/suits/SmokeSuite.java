package suits;

import LoginTest.LoginTestWithPageObject;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import postTest.CreatePost;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        LoginTestWithPageObject.class, CreatePost.class})
public class SmokeSuite {


}