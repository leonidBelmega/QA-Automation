package lesson08.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface AddressPageLocators {
    By PROCEED_TO_CHECKOUT = By.xpath("//*[@id=\"center_column\"]/form/p/button/span");
    By ADDRESS_FIRST_NAME = By.xpath("//*[@id=\"address_delivery\"]/li[2]");
}