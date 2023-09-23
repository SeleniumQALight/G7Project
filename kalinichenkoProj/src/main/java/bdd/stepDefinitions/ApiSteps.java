package bdd.stepDefinitions;

import api.ApiHelper;
import bdd.helpers.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import test_data.TestData;

public class ApiSteps extends MainSteps {
    final String DEFAULT = "default";
private ApiHelper apiHelper = new ApiHelper();
    public ApiSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("i create {int} new posts via API for {string} user and {string} password")
    public void iCreateNewPostsViaAPIForUserAndPassword(
            Integer numberOfPosts, String userName, String password, DataTable dataTable) {
        if (DEFAULT.equalsIgnoreCase(userName)) {
            userName = TestData.LOGIN_API_DEFAULT;
        }
        if (DEFAULT.equalsIgnoreCase(password)) {
            password = TestData.PASSWORD_API_DEFAULT;
        }
        for (int i = 0; i < numberOfPosts; i++) {
            apiHelper.createPostViaAPI(userName, password, dataTable.asMap(), i);
        }
    }
}
