package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputPassWord;

    @FindBy(xpath = ".//button[text()='Sign In']")
    private WebElement buttonSignIn;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        openPage(BASE_URL);
    }

    public void enterTextInToInputUserName(String userName) {
        enterTextIntoInput(inputUserName, userName);
    }

    public void enterTextInToInputPassWord(String passWord) {
        enterTextIntoInput(inputPassWord, passWord);
    }

    public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }



}
