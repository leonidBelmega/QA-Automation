package lesson08.homeWork;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShippingPage {
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(ShippingPage.class);

    public ShippingPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"cgv\"]")
    private WebElement agrementCheckbox;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    private WebElement proceedToCheckout;


    ShippingPage setAgrementCheckbox(){
    agrementCheckbox.click();
            return new ShippingPage(driver);
}

    void setProceedToCheckout(){
        proceedToCheckout.click();
    }



    }





