package suits;


import LoginTests.LoginTestWithPageObject;
import categories.SmokeTestFilters;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import postTests.CreatePost;
import registrationTest.RegistrationTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTestFilters.class)
@Suite.SuiteClasses({
        LoginTestWithPageObject.class,
        RegistrationTest.class,
        CreatePost.class
})
public class SmokeSuiteWithCategories {

}
