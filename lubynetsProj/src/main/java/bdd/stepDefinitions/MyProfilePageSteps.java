package bdd.stepDefinitions;

import bdd.helpers.WebDriverHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MyProfilePageSteps extends MainSteps{
    public MyProfilePageSteps(WebDriverHelper webDriverHelper) {
        super(webDriverHelper);
    }


    @Then("I redirect on MyProfile page")
    public void iRedirectOnMyProfilePage() {
        pageProvider.getMyProfilePage().checkIsRedirectToMyProfilePage();
    }

    @And("I See {int} posts in Post lists on MyProfile page")
    public void iSeePostsInPostListsOnMyProfilePage(Integer numberOfPosts) {
pageProvider.getMyProfilePage().checkNumberOfPosts(numberOfPosts);

    }
    }

