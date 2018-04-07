package lesson08.homeWork;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ProductPage {
    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebDriver driver;

    @FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span")
    private WebElement addToChart;

@FindBy(xpath = "//*[@id=\"center_column\"]/div/div/div[3]/h1")
private  WebElement productName;
@FindBy(xpath = "//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
private  WebElement proceedToCheckout;

    void addToChart(){
        addToChart.click();
    }
    String productName() {
        return productName.getText();
    }
    void proceedToCheckOut(){
        proceedToCheckout.click();
        proceedToCheckout.click();

        }

    }





