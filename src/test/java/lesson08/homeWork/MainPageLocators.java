package lesson08.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface MainPageLocators {

    By SING_IN_BUTTON =By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a");

    By LOGIN_FIELD =By.id("email");
    By PASSWORD_FIELD =By.id("passwd");

    By LOGIN_BUTTON=By.id("SubmitLogin");
    By FIELD_QUERY = By.id("search_query_top");
    By SEARCH_BUTTON = By.xpath("//*[@id=\"searchbox\"]/button");
    By SEARCH_RESULT = By.xpath("//*[@id=\"best-sellers_block_right\"]/div/ul/li[5]/div/h5");
}