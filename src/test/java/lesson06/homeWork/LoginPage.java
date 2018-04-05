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

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a_custom_condition")
    private WebElement signInButton;

    @FindBy(id = "email")
    private WebElement loginField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a_custom_condition")
    private WebElement signOutButton;

    public void enterUsername(String login) {
        signInButton.click();
        loginField.sendKeys(login);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignInBtn() {
        loginButton.click();
    }

    public void logIn(String login, String password) {
        enterUsername(login);
        enterPassword(password);
        clickSignInBtn();
        
    }

    public String singInText() {
        return signInButton.getText();
    }
}