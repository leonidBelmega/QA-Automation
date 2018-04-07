package lesson08.homeWork;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddressPage {

    public AddressPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"center_column\"]/form/p/button/span")
    private WebElement proceedToCheckout;

    @FindBy(xpath = "//*[@id=\"address_delivery\"]/li[2]")
    private WebElement addressFirstName;

    String firstName(){
        return addressFirstName.getText();
    }

    void proceedToCheckOut(){
    proceedToCheckout.click();
     }
    }





