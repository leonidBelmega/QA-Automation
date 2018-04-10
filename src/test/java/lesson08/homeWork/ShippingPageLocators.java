package lesson08.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface ShippingPageLocators {
    By AGREEMENT_CHECKBOX = By.id("uniform-cgv");
    By PROCEED_TO_CHECKOUT = By.xpath("//*[@id=\"form\"]/p/button/span");
}