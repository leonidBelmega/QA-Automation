package lesson08.homeWork;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;


public class FullFlowTests {
    private static final Logger LOG = LogManager.getLogger(FullFlowTests.class);
    static WebDriver driver;
    public static MainPage loginPage;
    public static AccountPage accountPage;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        loginPage = new MainPage(driver);
        accountPage = new AccountPage(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
    }

    @Test

    public void FullFlowTest() {
        String query1 = "Dress";
        String productName = "Printed Dress";
        String email = "collector.sharing@gmail.com";
        String pass = "manchester-123a";
        String user = "test user";
        String total = "$28.00";

        MainPage mainPage = new MainPage(driver);
        ProductPage productPage = new ProductPage(driver);
        OrderPage orderPage = new OrderPage(driver);
        AddressPage addressPage = new AddressPage(driver);
        ShippingPage shippingPage = new ShippingPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);

        LOG.info("Sing In");
        accountPage.enterUsername(email).enterPassword(pass).clickSignInBtn();
        LOG.info("Start search");
        mainPage.enterQuery(query1);
        LOG.info("select search result");
        mainPage.selectSearchResult();

        Assert.assertThat(productPage.productName(), containsString(productName));
        LOG.info("Add product to a chart");
        productPage.addToChart();
        LOG.info("proceed to checkout");
        productPage.proceedToCheckOut();

        Assert.assertThat(orderPage.totalPrice(), containsString(total));
        LOG.info("proceed to checkout");
        orderPage.proceedToCheckOut();

        Assert.assertThat(addressPage.firstName(), containsString(user));
        LOG.info("proceed to checkout");
        addressPage.proceedToCheckOut();

        LOG.info("proceed to checkout");
        shippingPage.setAgrementCheckbox().setProceedToCheckout();

        Assert.assertThat(paymentPage.total(), containsString(total));
        LOG.info("select payment");
        paymentPage.hookPayment();
        Assert.assertThat(paymentPage.paymentCheck(), containsString(total));

        LOG.info("confirm my order");
        paymentPage.confirmMyOrder();
        Assert.assertThat(paymentPage.finalConfirm(), containsString(total));
    }

    static {
        if (System.getProperty("report.path") == null) {
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
