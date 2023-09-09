package bdd.cucumber.stepDefinitions;

import bdd.cucumber.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pages.PageProvider;


public class MyStepdefs extends MainSteps{

    public MyStepdefs(TestUser testUser, WebDriverHelper webDriverHelper) {
        super(testUser, webDriverHelper);
    }



    @Given("I am on the login page")
    @Step("I am on the login page")
    public void iAmOnTheLoginPage() {
//        pageProvider.getLoginPage().openLoginPage();
        testUser.setName("name_test");
        System.out.println("User name is " + testUser.getName());
    }

    @When("I enter valid credentials")
    @Step("I enter valid credentials")
    public void iEnterValidCredentials() {
        pageProvider.getLoginPage().loginWithValidCreds();
    }

    @Then("I should be {int}time Avatar")
    @Step("I should be {int}time Avatar")
    public void iShouldBeTimeLoggedIn(int arg0) {
       pageProvider.getHomePage().checkIsRedirectToHomePage();
    }


}
