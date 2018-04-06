package lesson06.homeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver) {
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

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a")
    private WebElement signOutButton;

    public LoginPage enterUsername(String login) {
        signInButton.click();
        loginField.sendKeys(login);
        return new LoginPage(driver);
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return new LoginPage(driver);
    }

    public AccountPage clickSignInBtn() {
        loginButton.click();
        return new AccountPage(driver);
    }

    public AccountPage logIn(String login, String password) {
        enterUsername(login);
        enterPassword(password);
        clickSignInBtn();
        return new AccountPage(driver);
    }

    public String singInText() {
        return signInButton.getText();
    }
}