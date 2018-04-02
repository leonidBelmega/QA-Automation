package lesson05.homeWork;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest {

    static WebDriver driver;


    public void returnBackToTheMainPage() {
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span")).click();

    }

    @BeforeClass
    public static void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("collector.sharing@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"passwd\"]")).sendKeys("manchester-123a");
        driver.findElement(By.xpath("//*[@id=\"SubmitLogin\"]/span")).click();
    }


    @Test
    public void login() {

        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a")).getText(),
                containsString("test user"));
    }

    @Test
    public void openOrderHistoryAndDetailsPage() {

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[1]/a/span")).click();

        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText(),
                containsString("ORDER HISTORY"));
        returnBackToTheMainPage();
    }

    @Test
    public void openMyCreditSlipsPage() {

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[2]/a/span")).click();

        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText(),
                containsString("CREDIT SLIPS"));
        returnBackToTheMainPage();
    }

    @Test
    public void openMyAddressesPage() {

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[3]/a/span")).click();

        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/h1")).getText(),
                containsString("MY ADDRESSES"));
        returnBackToTheMainPage();
    }

    @Test
    public void openMyPersonalInformationPage() {

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[1]/ul/li[4]/a/span")).click();

        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/h1")).getText(),
                containsString("YOUR PERSONAL INFORMATION"));
        returnBackToTheMainPage();
    }

    @Test
    public void openMyWishListsPage() {

        driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/div[2]/ul/li")).click();

        Assert.assertThat(driver.findElement(By.xpath("//*[@id=\"columns\"]/div[1]/span[3]")).getText(),
                containsString("My wishlists"));

        returnBackToTheMainPage();
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

}
