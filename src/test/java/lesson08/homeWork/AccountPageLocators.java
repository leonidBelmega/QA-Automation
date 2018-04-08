package lesson08.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface AccountPageLocators {
    By SIGN_IN_BUTTON = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");
    By LOGIN_FIELD = By.id("email");
    By PASSWORD_FIELD = By.id("passwd");
    By LOGIN_BUTTON = By.id("SubmitLogin");
    By USER_ACCOUNT_NAME = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");

}