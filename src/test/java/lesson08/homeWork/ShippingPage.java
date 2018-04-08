package lesson08.homeWork;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ShippingPage extends BasePage implements ShippingPageLocators{protected WebElement $(String xpath){
    return $(By.xpath(xpath));
}


    private WebDriver driver;

    ShippingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"cgv\"]")
    private WebElement agreementCheckbox;

    @FindBy(xpath = "//*[@id=\"form\"]/p/button/span")
    private WebElement proceedToCheckout;
    ShippingPage clickAgrementCheckbox() {
        agreementCheckbox.click();
        return new ShippingPage(driver);
    }

    void setProceedToCheckout() {
        proceedToCheckout.click();
    }


}





