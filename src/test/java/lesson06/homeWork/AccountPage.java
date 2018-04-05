package lesson06.homeWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

    public AccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a_custom_condition")

    private WebElement signOutButton;

    @FindBy(xpath = "//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a_custom_condition")

    private WebElement userAccountName;

    public String userAccountName() {
        return userAccountName.getText();
    }

    public void singOut() {
        signOutButton.click();

    }
}