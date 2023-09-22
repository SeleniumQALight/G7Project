package bdd.stepDefinitions;

import bdd.helper.WebDriverHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MyProfilePageSteps extends MainSteps {
    public MyProfilePageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }

    @Then("I redirect to MyProfile page")
    public void iRedirectToMyProfilePage() {
        pageProvider.getMyProfilePage().checkIsRedirectToMyProfilePage();
    }

    @And("I see {int} posts in Post list on MyProfile page")
    public void iSeePostsInPostListOnMyProfilePage(Integer numberOfPosts) {
        pageProvider.getMyProfilePage().checkIsNumberOfPosts(numberOfPosts);
    }
}

