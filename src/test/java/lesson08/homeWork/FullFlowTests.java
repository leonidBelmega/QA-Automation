package lesson08.homeWork;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.hamcrest.CoreMatchers.containsString;


public class FullFlowTests extends BaseTest {
    private static final Logger LOG = LogManager.getLogger(FullFlowTests.class);

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
        AccountPage accountPage = new AccountPage(driver);

        mainPage.visit();
        LOG.info("Sing In");
        mainPage.enterUsername(email);
        System.out.println(11111);
                mainPage.enterPassword(pass);
        System.out.println(222);
                mainPage.clickSignInBtn();

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
        shippingPage.clickAgrementCheckbox();
        shippingPage.setProceedToCheckout();

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
}
