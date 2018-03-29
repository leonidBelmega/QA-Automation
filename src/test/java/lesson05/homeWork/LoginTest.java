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

public class LoginTest {

    static WebDriver driver;

    public void loginUser(){
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("collector.sharing@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("manchester-123a");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
    }

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
    public void login() {

        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();

        driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("collector.sharing@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("manchester-123a");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();

        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText(),
                containsString("test user"));

    }

    @Test
    public void openOrderHistoryAndDetailsPage(){
        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).click();

        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText(),
                containsString("Order history"));

        //Return to My Account page back
        driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/a[2]\n")).click();



    }


    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
