package lesson07.h;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class MainPage extends BasePage implements MainPageLocators {

    private WebDriver driver;

    MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath="//*[@id='index']/div[2]/")
            private WebElement adviceList;

    void enterQuery(String query){
        $(FIELD_QUERY_LOCATOR).click();
        $(FIELD_QUERY_LOCATOR).clear();
        $(FIELD_QUERY_LOCATOR).sendKeys(query);
    }

    void visit(){
        open("http://automationpractice.com/index.php");
    }

}