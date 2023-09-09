package bdd.cucumber.stepDefinitions;

import bdd.cucumber.WebDriverHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pages.PageProvider;


public class MyStepdefs {



    PageProvider pageProvider = new PageProvider(WebDriverHelper.getWebDriver());

    @Given("I am on the login page")
    @Step("I am on the login page")
    public void iAmOnTheLoginPage() {
//        pageProvider.getLoginPage().openLoginPage();
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

    @Then("I should see error message")
    @Step("I should see error message")
    public void iEnterValidLoginCredentials() {
        pageProvider.getLoginPage().checkIsButtonSignInDisplayed();

    }
}
