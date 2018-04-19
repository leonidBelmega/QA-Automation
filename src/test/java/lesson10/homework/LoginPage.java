package lesson10.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.CredManager;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void visit() {
        open("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }

    public void login() {
        $(By.id("email")).sendKeys(CredManager.getCred("username"));
        $(By.id("passwd")).sendKeys(CredManager.getCred("wrongpass"));
        $(By.id("SubmitLogin")).click();

    }
}