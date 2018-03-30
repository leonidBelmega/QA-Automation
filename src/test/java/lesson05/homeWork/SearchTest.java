package lesson05.homeWork;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

public class SearchTest {

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
    public void Search() {
        String s1 = "Printed Summer Dress";
        String s2 = "Showing 1 - 3 of 3 items";

        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys(s1);
        driver.findElement(By.id("search_query_top")).submit();

        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/h5/a")).getText(),
                containsString(s1));
        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/div[2]/div[2]")).getText(),
                containsString(s2));

    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
