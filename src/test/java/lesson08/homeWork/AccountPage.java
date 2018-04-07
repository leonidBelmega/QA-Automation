package lesson08.homeWork;

import lesson06.homeWork.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    public AccountPage(WebDriver driver) {
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


    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")

    private WebElement userAccountName;
    public LoginPage enterUsername(String login) {
        signInButton.click();
        loginField.sendKeys(login);
        return new LoginPage(driver);
    }

    public LoginPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return new LoginPage(driver);
    }

    public void clickSignInBtn() {
        loginButton.click();
    }

    public String userAccountName() {
        return userAccountName.getText();
    }

}