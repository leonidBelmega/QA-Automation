package lesson08.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface ProductPageLocators {
    By ADD_TO_CHART = By.xpath("//*[@id=\"add_to_cart\"]/button/span");
    By PRODUCT_NAME = By.xpath("//*[@id=\"center_column\"]/div/div/div[3]/h1");
    By PROCEED_TO_CHECKOUT = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
}