package lesson08.homeWork;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrderPage extends  BasePage implements OrderPageLocators{

    private WebDriver driver;

    OrderPage(WebDriver driver) {
        super(driver);
    }


    void proceedToCheckOut(){
    $(PROCEED_TO_CHECKOUT).click();
}

    String totalPrice(){
       return $(TOTAL_PRICE).getText();
    }

    }





