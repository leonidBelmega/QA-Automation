package lesson09.b;

import org.openqa.selenium.By;

public interface MainPageLocators {
    By ADVICE_LOCATOR = By.xpath("//*[@id='index']/div[2]/ul/li");
    By FIELD_QUERY_LOCATOR = By.id("search_query_top");
    By IFRAME_LOCATOR = By.xpath("/html/body/div/div[2]/div/div[2]/div/div[2]/div[3]/div/div/span/iframe");


}