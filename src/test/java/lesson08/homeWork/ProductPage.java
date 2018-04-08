package lesson08.homeWork;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage extends BasePage implements ProductPageLocators {
    private WebDriver driver;

    ProductPage(WebDriver driver) {
        super(driver);
    }

    void addToChart() {
        $(ADD_TO_CHART).click();
    }

    String productName() {
        return $(PRODUCT_NAME).getText();
    }

    void proceedToCheckOut() {
        $(PROCEED_TO_CHECKOUT).click();
        $(PROCEED_TO_CHECKOUT).click();
    }

}





