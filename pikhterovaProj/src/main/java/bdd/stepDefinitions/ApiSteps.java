package bdd.stepDefinitions;

import api.ApiHelper;
import bdd.helpers.WebDriverHelper;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import testData.TestData;

public class ApiSteps extends MainSteps{
    final String DEFAULT = "default";
    private ApiHelper apiHelper = new ApiHelper();
    public ApiSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I create {int} new posts via API for {string} user and {string} password")
    public void iCreateNumberOfPostsNewPostsViaAPIForDefaultUserAndDefaultPassword(Integer numberOfPosts, String userName, String password, DataTable dataTable) {
       if (DEFAULT.equalsIgnoreCase(userName) ){
           userName = TestData.LOGIN_API_DEFAULT;
       }
       if (DEFAULT.equalsIgnoreCase(password) ){
           password = TestData.PASSWORD_API_DEFAULT;
       }
        for (int i = 0; i < numberOfPosts; i++) {
            apiHelper.createPosts(userName, password, dataTable.asMap(), i);

        }
    }
}
