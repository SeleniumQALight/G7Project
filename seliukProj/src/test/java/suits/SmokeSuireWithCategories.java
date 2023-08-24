package suits;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import postTests.createPost;
import loginTests.LoginTest;
import registrationTest.RegistrationTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeSuireWithCategories.class)
@Categories.ExcludeCategory()
@Suite.SuiteClasses({
        LoginTest.class,
        RegistrationTest.class,
    createPost.class}
)
public class SmokeSuireWithCategories {

}
