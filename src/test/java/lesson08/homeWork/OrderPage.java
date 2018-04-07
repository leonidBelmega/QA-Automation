package lesson08.homeWork;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrderPage {


    public OrderPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"total_price\"]")
    private WebElement totalprice;

    @FindBy(xpath = "//*[@id=\"center_column\"]/p[2]/a[1]/span")
    private WebElement proceedToCheckout;

void proceedToCheckOut(){
    proceedToCheckout.click();
}
    String totalPrice(){
       return totalprice.getText();
    }


    }





