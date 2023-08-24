package suits;

import categories.SmokeTestFilters;
import loginTest.LoginTestWithPageObject;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import registrationTest.registrationTest;

@RunWith(Categories.class)
@Categories.IncludeCategory(SmokeTestFilters.class)
@Suite.SuiteClasses({
        LoginTestWithPageObject.class,
        registrationTest.class
})
public class SmokeSuiteWithCategories {
}
