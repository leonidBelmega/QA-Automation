package lesson08.homeWork;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PaymentPage extends BasePage implements PaymentPageLocators{

    private WebDriver driver;
    PaymentPage(WebDriver driver) {
        super(driver);
    }


    String total(){ return $(TOTAL).getText();}

    String paymentCheck(){
        return $(PAYMENT_CHECK).getText();
    }

    String finalConfirm(){
        return $(FINAL_CONFIRM).getText();
    }

    void confirmMyOrder(){
        $(I_CONFIRM_MY_ORDER).click();
    }

    void hookPayment(){
        $(HOOK_PAYMENT).click();
    }

    }





