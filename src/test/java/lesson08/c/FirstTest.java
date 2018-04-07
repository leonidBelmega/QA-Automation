package lesson08.c;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {

    private static final Logger LOG = LogManager.getLogger(FirstTest.class);

    @Test
    public void firstResultShouldContainExpectedText() {
        String query1 = "Dress";
        String query2 = "T-shirt";
        MainPage mainPage = new MainPage(driver);

        LOG.info("visit main page");
        mainPage.visit();
        assertThat(new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return driver.getTitle().equals("My Store");
            }
        });

        LOG.info("Entering first value");
        mainPage.enterQuery(query1);
        assertThat(CustomExpectedCondition.listShouldHaveSize(mainPage.ADVICE_LOCATOR, 7));
        assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query1));

        LOG.info("Entering second value");
        mainPage.enterQuery(query2);
        assertThat(CustomExpectedCondition.listShouldHaveSize(mainPage.ADVICE_LOCATOR, 1));
        assertThat(textToBePresentInElementLocated(mainPage.ADVICE_LOCATOR, query2));
    }

    static {
        if (System.getProperty("report.path") == null) {
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }
}
