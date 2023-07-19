package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(xpath = ".//input[@placeholder='Username']")
    private WebElement inputUserNane;

    @FindBy(xpath = ".//input[@placeholder='Password']")
    private WebElement inputPassword;

    @FindBy(xpath = ".//button[text()='Sign In']")
    private WebElement buttonSignIn;


    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void openLoginPage() {
        openPage(BASE_URL);
    }

    public void enterTextIntoInputUserNane(String UserNane) {
        enterTextIntoInput(inputUserNane, UserNane);
    }
    public void enterTextIntoInputPassword(String Password) {
        enterTextIntoInput(inputPassword,Password);
    }

public void clickOnButtonSignIn() {
        clickOnElement(buttonSignIn);
    }
//    public void enterTextInToInputPassword(String password) {
//        enterTextIntoInput(inputPassword, password);
//    }

}
