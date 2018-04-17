package lesson09.b;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(JUnit4.class)
public class FirstTest extends BaseTest {
    private static final Logger LOG = LogManager.getLogger(FirstTest.class);
    LoginPage loginPage = new LoginPage(driver);

    @Test
    public void firstResultShouldContainExpectedText() {

        loginPage.visit();
        loginPage.login();

        Set<Cookie> cookies = driver.manage().getCookies();
        $(By.className("logout")).click();
        assertThat(titleContains("Login"));

        for (Cookie cookie : cookies) {
            if (cookie.getName().contains("PrestaShop")) {
                driver.manage().addCookie(cookie);
            }  else LOG.error("Oops...");
        }
driver.navigate().refresh();

        assertThat(titleContains("My account"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = (WebElement) js.executeScript("return JQuery");
                driver.manage().timeouts();
    }

    static {
        if (System.getProperty("report.path") == null) {
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }
}
