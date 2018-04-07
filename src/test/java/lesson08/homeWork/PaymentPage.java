package lesson08.homeWork;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PaymentPage {
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(PaymentPage.class);

    public PaymentPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"total_price\"]")
    private WebElement total;

    @FindBy(xpath = "//*[@id=\"HOOK_PAYMENT\"]/div[2]/div/p/a")
    private WebElement hookPayment;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/div/p[2]")
    private WebElement paymentCheck;

    @FindBy(xpath = "//*[@id=\"cart_navigation\"]/button/span")
    private WebElement iConfirmMyOrder;

    @FindBy(xpath = "//*[@id=\"center_column\"]/div")
    private WebElement finalConfirm;

    String total(){ return total.getText();}

    String paymentCheck(){
        return paymentCheck.getText();
    }
    String finalConfirm(){
        return finalConfirm.getText();
    }

    void confirmMyOrder(){
        iConfirmMyOrder.click();
    }

    void hookPayment(){
        hookPayment.click();
    }



    }





