package lesson08.homeWork;


import lesson07.homeWork.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddressPage extends BasePage implements AddressPageLocators {

    private WebDriver driver;

    AddressPage(WebDriver driver) {
        super(driver);
    }


    String firstName(){
        return $(ADDRESS_FIRST_NAME).getText();
    }

    void proceedToCheckOut(){
    $(PROCEED_TO_CHECKOUT).click();
     }
    }





