package suits;

import LoginTest.LoginTestWithPageObject;
import apiTest.ApiTests;
import categories.SmokeTestFilter;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import postTest.CreatePost;
import registrationTest.RegistrationTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTestFilter.class)
@Suite.SuiteClasses({
        LoginTestWithPageObject.class,
        RegistrationTest.class,
       CreatePost.class,
        ApiTests.class

})
public class SmokeSuiteWithCategories {
}



