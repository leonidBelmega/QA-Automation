package lesson10.b;

import org.openqa.selenium.By;

public interface MainPageLocators {
    By ADVICE_LOCATOR = By.xpath("//*[@id='index']/div[2]/ul/li");
    By FIELD_QUERY_LOCATOR = By.id("search_query_top");
}