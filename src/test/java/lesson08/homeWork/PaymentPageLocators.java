package lesson08.homeWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public interface PaymentPageLocators {
    By TOTAL = By.xpath("//*[@id=\"total_price\"]");
    By HOOK_PAYMENT = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a");
    By PAYMENT_CHECK = By.xpath("//*[@id=\"center_column\"]/form/div/p[2]");
    By I_CONFIRM_MY_ORDER = By.xpath("//*[@id=\"cart_navigation\"]/button/span");
    By FINAL_CONFIRM = By.xpath("//*[@id=\"center_column\"]/div");

}