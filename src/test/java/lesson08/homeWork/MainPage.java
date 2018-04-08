package lesson08.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage implements MainPageLocators{


    private WebDriver driver;

    MainPage(WebDriver driver) {
        super(driver);
    }

    void selectSearchResult(){
        $(SEARCH_RESULT).click();
    }

    void enterQuery(String query) {
        $(FIELD_QUERY).click();
        $(FIELD_QUERY).clear();
        $(FIELD_QUERY).sendKeys(query);
       $(SEARCH_BUTTON).click();
    }

    void visit(){
        open("http://automationpractice.com/index.php");
    }

    public MainPage enterUsername(String login) {
        $(SING_IN_BUTTON).click();
        $(LOGIN_FIELD).sendKeys(login);
        return new MainPage(driver);
    }

    public MainPage enterPassword(String password) {
        $(PASSWORD_FIELD).sendKeys(password);
        return new MainPage(driver);
    }

    public AccountPage clickSignInBtn() {
        $(LOGIN_BUTTON).click();
        return new AccountPage(driver);
    }

}