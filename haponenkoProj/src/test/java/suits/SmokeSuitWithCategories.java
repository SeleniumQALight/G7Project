package suits;

import categories.SmokeTestFilter;
import logOutTest.SignOutTest;
import loginTest.LoginTestWithPageObject;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import postTests.CreatePost;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTestFilter.class)
@Suite.SuiteClasses({
        LoginTestWithPageObject.class,
        SignOutTest.class,
        CreatePost.class
})
public class SmokeSuitWithCategories {
}
