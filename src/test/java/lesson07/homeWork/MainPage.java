package lesson07.homeWork;

import org.openqa.selenium.WebDriver;

class MainPage extends BasePage implements MainPageLocators {

    MainPage(WebDriver driver) {
        super(driver);
    }

    void enterQuery(String query) {
        $(FIELD_QUERY_LOCATOR).click();
        $(FIELD_QUERY_LOCATOR).clear();
        $(FIELD_QUERY_LOCATOR).sendKeys(query);
    }

    void clear() {
        $(FIELD_QUERY_LOCATOR).clear();
    }

    void visit() {
        open("http://automationpractice.com/index.php");
    }

}