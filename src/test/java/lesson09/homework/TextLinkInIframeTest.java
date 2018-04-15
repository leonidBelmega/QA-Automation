package lesson09.homework;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import static org.hamcrest.CoreMatchers.containsString;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

@RunWith(JUnit4.class)
public class TextLinkInIframeTest extends BaseTest {
    private static final Logger LOG = LogManager.getLogger(TextLinkInIframeTest.class);

    MainPage mainPage = new MainPage(driver);

    @Test
    public void IframeLinkText() throws InterruptedException {
        String title = "PrestaShop";
        String likes = "108,906 likes";
        mainPage.visit();

        WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/div[2]/div[3]/div/div/span/iframe"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        LOG.info("switch to iFrame");
        driver.switchTo().frame(element);

        WebElement elementInIframe = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div/div[2]/div[2]/div[1]/a"));
        Assert.assertThat(elementInIframe.getText(), containsString(title));

        WebElement numberOfLikes = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div/div[2]/div[2]/div[2]"));
        Assert.assertThat(numberOfLikes.getText(), containsString(likes));

        driver.switchTo().parentFrame();
    }

    static {
        if (System.getProperty("report.path") == null) {
            Date dateNow = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
            System.setProperty("report.path", "./reports/IDE-test-build-" + format.format(dateNow));
        }
    }
}
