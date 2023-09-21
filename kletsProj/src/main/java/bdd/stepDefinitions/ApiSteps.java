package bdd.stepDefinitions;

import api.ApiHelper;
import bdd.helper.WebDriverHelper;
import data.TestData;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;

public class ApiSteps extends MainSteps {
    final String DEFAULT = "default"; // default username
    private ApiHelper apiHelper = new ApiHelper();

    public ApiSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Given("I create {int} new posts via API for {string} user and {string} password")
    public void iCreateNewPostsViaAPIForDefaultUserAndPassword(Integer numberOfPosts, String username, String password, DataTable dataTable) {
        if(DEFAULT.equalsIgnoreCase(username)){ // if username is default
            username = TestData.LOGIN_API_DEFAULT; // set default username
        }

        if(DEFAULT.equalsIgnoreCase(password)){ // if password is default
            password = TestData.PASSWORD_API_DEFAULT; // set default password
        }

        for (int i = 0; i < numberOfPosts; i++) {
            apiHelper.createPosts(username, password, dataTable.asMap(), i);

        }

    }
}

