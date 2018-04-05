package lesson05.classWork;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

public class FirstTest {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();

    }

    @Test
    public void firstresultShouldContainExpectedText() {
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("Dress");
        driver.findElement(By.id("search_query_top")).submit();

        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a_custom_condition")).getText(),
                containsString("Dress"));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
