package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import java.util.List;


public class UpdatePostPage extends ParentPageWithHeader {


    @FindBy(id = "post-title")
    private WebElement inputTitle;

    @FindBy(id = "post-body")
    private WebElement inputBody;

    @FindBy(xpath = ".//input[@type='checkbox']")
    private WebElement checkbox;

    @FindBy(tagName = "select")
    private WebElement dropDownSelectValue;

    @FindBy(xpath = ".//button[text()='Save Updates']")
    private WebElement buttonSaveUpdates;

    @FindBy(xpath = ".//div[@class='alert alert-success text-center']")
    private WebElement successMessageElement;

    @FindBy(xpath = "//input[@class='form-control form-control-lg form-control-title']")
    private WebElement updatePostTitle;

    private String postTitleLocator = ".//*[text()='%s']";


    public UpdatePostPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/post/[a-zA-Z0-9]*/edit";
    }


    public UpdatePostPage checkIsRedirectToUpdatePostPage() {
        checkUrlWithPattern();
        //TODO UNIQUE ELEMENT
        return this;
    }


    public UpdatePostPage enterTextIntoInputTitle(String s) {
        enterTextIntoInput(inputTitle, s);
        return this;
    }

    public UpdatePostPage enterTextIntoInputBody(String bodyOfUpdatedPost) {
        enterTextIntoInput(inputBody, bodyOfUpdatedPost);
        return this;
    }


    public UpdatePostPage workWithCheckBox() {
        setCheckStatusToCheckBox(checkbox);
        return this;
    }

    public UpdatePostPage checkOrUncheckCheckBoxDependingOnText(String text) {
        checkOrUncheckCheckBoxDependingOnText(checkbox, text);
        return this;
    }

    public UpdatePostPage selectTextInDropDownByUI() {
        selectTextInDropDownByUI(dropDownSelectValue, "Частное сообщение");
        return this;
    }

    public UpdatePostPage clickOnButtonSaveUpdates() {
        clickOnElement(buttonSaveUpdates);
        return this;
    }

    public UpdatePostPage checkIsSuccessMessageDisplayed(String text) {
        Assert.assertEquals("Text in message", text, successMessageElement.getText());
        return this;
    }


    public UpdatePostPage checkIsTextIntoInputBody(String bodyOfUpdatedPost) {
        Assert.assertEquals("Text in input body", bodyOfUpdatedPost, inputBody.getAttribute("value"));
        return this;
    }

}
