package lesson08.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface OrderPageLocators {
    By TOTAL_PRICE = By.xpath("//*[@id=\"total_price\"]");
    By PROCEED_TO_CHECKOUT = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span");
}