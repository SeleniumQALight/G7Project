package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = "//input[@placeholder='Username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    private WebElement signInButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage(){
        openPage(BASE_URL);
    }

    public void enterTextIntoInputUsername(String username) {
        enterTextIntoInput(username, inputUsername);
    }

    public void enterTextIntoInputPassword(String password) {
        enterTextIntoInput(password, inputPassword);
    }

    public void clickOnSignInButton() {
        clickOnElement(signInButton);
    }



}
