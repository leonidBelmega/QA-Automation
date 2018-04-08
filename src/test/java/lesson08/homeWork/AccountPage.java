package lesson08.homeWork;

import lesson06.homeWork.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage implements AccountPageLocators{

    private WebDriver driver;

    AccountPage(WebDriver driver) {
        super(driver);
    }



    public LoginPage enterUsername(String login) {
        $(SIGN_IN_BUTTON).click();
        $(LOGIN_FIELD).sendKeys(login);
        return new LoginPage(driver);
    }

    public LoginPage enterPassword(String password) {
        $(PASSWORD_FIELD).sendKeys(password);
        return new LoginPage(driver);
    }

    public void clickSignInBtn() {
        $(LOGIN_BUTTON).click();
    }

    public String userAccountName() {
        return $(USER_ACCOUNT_NAME).getText();
    }

}