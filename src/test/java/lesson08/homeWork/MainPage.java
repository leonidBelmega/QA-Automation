package lesson08.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")
    private WebElement signInButton;

    @FindBy(id = "email")
    private WebElement loginField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy (id = "search_query_top")
    private WebElement fieldQuery;

    @FindBy (xpath = "//*[@id=\"searchbox\"]/button")
    private WebElement searchBoxButton;
    @FindBy (xpath = "//*[@id=\"best-sellers_block_right\"]/div/ul/li[5]/div/h5")
    private  WebElement searchResult;


    void selectSearchResult(){
        searchResult.click();
    }

    void enterQuery(String query) {
        fieldQuery.click();
        fieldQuery.clear();
       fieldQuery.sendKeys(query);
       searchBoxButton.click();

    }

    public MainPage enterUsername(String login) {
        signInButton.click();
        loginField.sendKeys(login);
        return new MainPage(driver);
    }

    public MainPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return new MainPage(driver);
    }

    public AccountPage clickSignInBtn() {
        loginButton.click();
        return new AccountPage(driver);
    }

}